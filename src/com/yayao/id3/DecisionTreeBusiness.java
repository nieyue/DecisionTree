package com.yayao.id3;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yayao.bean.Account;
import com.yayao.bean.Analyse;
import com.yayao.bean.Course;
import com.yayao.bean.Score;
import com.yayao.bean.TeacherCourse;
import com.yayao.service.AnalyseService;
import com.yayao.service.CourseService;
import com.yayao.service.ScoreService;
import com.yayao.service.TeacherCourseService;
import com.yayao.util.Arith;

/**
 * 决策树业务
 * @author 聂跃
 * @date 2018年4月28日
 */
@Component
public class DecisionTreeBusiness  {
	IAttrSelector<StudentRecord> selector;
	@Autowired
	TeacherCourseService teacherCourseService;
	@Autowired
	CourseService courseService;
    /**
     * 学生决策树执行
     * @param studentAccountId
     */
	public  void student(ScoreService scoreService,AnalyseService analyseService,Integer studentAccountId){
		//所有成绩都查出
		List<Score> scoreList=scoreService.list(1, Integer.MAX_VALUE, null, null, null, null, null, null, null, null, null, null);
		//总成绩
		List<Score> dScore=new ArrayList<>();
		//总成绩
		Double totalScore=0.0;
		//总成绩数目
		int totalSize=scoreList.size();
		//自身成绩
		Double selfScore=0.0;
		//自身成绩数目
		int selfSize=0;
		//占比=自身成绩/总成绩
		Double scale=0.0;
		for (int i = 0; i < totalSize; i++) {
			Score score=scoreList.get(i);
			totalScore+=score.getScore();
			if(score.getStudentAccountId().equals(studentAccountId)){
				selfScore+=score.getScore();
				selfSize+=1;
				if(score.getScore()<60){
					dScore.add(score);
					}
			}
			
		}
		//scale=Arith.div(selfScore,totalScore);
		double s=0;
		if(selfSize<=0){
			s=0;
		}else{
			s=Arith.div(selfScore, selfSize);			
		}
		scale=Arith.div(s,100);
		Map<String,String> studentMap=getStudentMap(scale,s,dScore);
		DecisionTree<StudentRecord> dt=new DecisionTree<StudentRecord>(new DecisionTreeBusiness().selector);
	    StudentRecord css2=new StudentRecord(studentMap.get("scale"),studentMap.get("score"),studentAccountId,true);
	    boolean result=dt.callStudentTree(css2);
	    Map<String, Object> eq=new HashMap<>();
	    eq.put("type", 2);
		eq.put("businessId", studentAccountId);
	    List<Analyse> al=analyseService.list(1, Integer.MAX_VALUE, null, null, eq, null, null, null, null, null, null, null);
		if(al.size()>0){
			Analyse analyse=al.get(0);
			analyse.setScore(scale);
			if(result){
				analyse.setSubType(3);//合格				
			}else{
				analyse.setSubType(4);				
			}
			analyse.setUpdateDate(new Date());
			analyse.setConclusion(studentMap.get("conclusion"));
			analyseService.update(analyse);
		}else{
			Analyse aa=new Analyse();
			aa.setBusinessId(studentAccountId);
			aa.setScore(scale);
			aa.setType(2);//学生
			if(result){
				aa.setSubType(3);//合格				
			}else{
				aa.setSubType(4);				
			}
			aa.setUpdateDate(new Date());
			aa.setConclusion(studentMap.get("conclusion"));
			analyseService.add(aa);
		}
	}
	/**
     * 学生规则分配
     * @param studentAccountId
     */
	public Map<String,String> getStudentMap(Double scale,Double score,List<Score> dScore){
		Map<String,String> map=new HashMap<>();
		String s="<0.2";
		String ss="any";
		String c="";
		String dc="";
		if(scale>=0.8){
			s=">=0.8";
		 if(score<90.0){
				c="您的整体成绩良好，请下次继续努力，冲进优秀！";
			}else if(score<=100.0){
				c="您的整体成绩非常优秀，请下次继续加油，保持！";
			}
		}else if(scale>=0.2){
			s=">=0.2&&<0.8";
			if(score<60.0){
				ss="<60.0";
				c="您本次的成绩不合格，不要灰心，请改变学习方法！";
			}else if(score>=60.0){
				ss=">=60.0";
				c="您的整体成绩合格，请下次再接再厉，继续保持！";
			}
		}else if(scale<0.2){
			s="<0.2";
			c="您本次的成绩不合格，不要灰心，请改变学习方法！";
		}
		if(dScore.size()>0){
			c+="\n";
			for (int i = 0; i < dScore.size(); i++) {
				Score ddd = dScore.get(i);
				Map<String, Object> eq1=new HashMap<>();
				eq1.put("teacherCourseId", ddd.getTeacherCourseId());
				List<TeacherCourse> tcl=teacherCourseService.list(1, 10, null, null, eq1, null, null, null, null, null, null, null);
				for (int j = 0; j < tcl.size(); j++) {
					TeacherCourse tc=tcl.get(j);
					Course course=courseService.load(tc.getCourseId());
					tc.setCourse(course);
					ddd.setTeacherCourse(tc);
				}
				c+="您的偏课："+ddd.getTeacherCourse().getCourse().getName()+"，只有"+ddd.getScore()+"分!"+"\n";
			}
		}
		map.put("scale", s);
		map.put("score", ss);
		map.put("conclusion", c);
		return map;
	}
	
	  /**
     * 教师决策树执行
     * @param studentAccountId
     */
	public  void teacher(ScoreService scoreService,AnalyseService analyseService,Integer teacherCourseId){
		Map<String, Object> eq1=new HashMap<>();
		eq1.put("teacherCourseId", teacherCourseId);
		//所有该课程成绩都查出
		List<Score> scoreList=scoreService.list(1, Integer.MAX_VALUE, null, null, eq1, null, null, null, null, null, null, null);
		//课程总成绩
		Double totalScore=0.0;
		//课程总成绩数目
		int totalSize=scoreList.size();
		//优良课程成绩
		Double ylScore=0.0;
		//优良课程成绩数目
		int ylSize=0;
		//占比=自身平均成绩/总平均成绩
		Double scale=0.0;
		for (int i = 0; i < totalSize; i++) {
			Score score=scoreList.get(i);
			totalScore+=score.getScore();
			//只有大于等于80分才是优良
			if(score.getScore()>=80.0){
				ylScore+=score.getScore();
				ylSize+=1;
			}
		}
		if(totalSize<=0){
			scale=0.0;
		}else{
			scale=Arith.div(ylSize, totalSize);			
		}
		double s=0;
		if(ylSize<=0){
			s=0;
		}else{
			s=Arith.div(ylScore, ylSize);			
		}
		Map<String,String> studentMap=getTeacherMap(scale,s);
		DecisionTree<StudentRecord> dt=new DecisionTree<StudentRecord>(new DecisionTreeBusiness().selector);
	    StudentRecord css2=new StudentRecord(studentMap.get("scale"),studentMap.get("score"),teacherCourseId,true);
	    boolean result=dt.callTeacherCourseTree(css2);
	    Map<String, Object> eq=new HashMap<>();
	    eq.put("type", 1);
		eq.put("businessId", teacherCourseId);
	    List<Analyse> al=analyseService.list(1, Integer.MAX_VALUE, null, null, eq, null, null, null, null, null, null, null);
	    if(al.size()>0){
			Analyse analyse=al.get(0);
			analyse.setScore(scale);
			if(result){
				analyse.setSubType(3);//合格				
			}else{
				analyse.setSubType(4);				
			}
			analyse.setUpdateDate(new Date());
			analyse.setConclusion(studentMap.get("conclusion"));
			analyseService.update(analyse);
		}else{
			Analyse aa=new Analyse();
			aa.setBusinessId(teacherCourseId);
			aa.setScore(scale);
			aa.setType(1);//教师
			if(result){
				aa.setSubType(3);//合格				
			}else{
				aa.setSubType(4);				
			}
			aa.setUpdateDate(new Date());
			aa.setConclusion(studentMap.get("conclusion"));
			analyseService.add(aa);
		}
	}
	/**
     * 教师规则分配
     * @param studentAccountId
     */
	public Map<String,String> getTeacherMap(Double scale,Double score){
		Map<String,String> map=new HashMap<>();
		String s="<0.2";
		String ss="any";
		String c="";
		if(scale>=0.2){
			s=">=0.2";
		    if(scale<0.4){
				c="您的课程教育合格，请再接再厉！";
			}else if(scale<0.6){
					c="您的课程教育良好，请下次继续努力，冲进优秀！";
			}else if(scale<=1.0){
					c="您的课程教育非常优秀，请下次继续加油，保持！";
				}
			
		}else if(scale<0.2){
			s="<0.2";
			c="您的课程教育不合格，请改变教育方式！";
		}
		map.put("scale", s);
		map.put("score", ss);
		map.put("conclusion", c);
		return map;
	}
}
