package com.yayao.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.bean.Account;
import com.yayao.bean.Course;
import com.yayao.bean.Score;
import com.yayao.bean.TeacherCourse;
import com.yayao.id3.DecisionTreeBusiness;
import com.yayao.service.AccountService;
import com.yayao.service.AnalyseService;
import com.yayao.service.CourseService;
import com.yayao.service.ScoreService;
import com.yayao.service.TeacherCourseService;
import com.yayao.util.MyJSON;
import com.yayao.util.ResultUtil;


/**
 * 成绩
 * @author yy
 *
 */
public class ScoreAction extends BaseAction<Score,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AnalyseService analyseService;
	@Autowired
	private DecisionTreeBusiness decisionTreeBusiness;
	//private DecisionTreeBusiness decisionTreeBusiness=new DecisionTreeBusiness();
	private Score score=new Score();//成绩模型

	@Override
	public Score getModel() {
		return score;
	}
	/**
	 * 增加
	 */
	public String add()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		List<Score> cl=scoreService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","成绩已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		score.setUpdateDate(new Date());
		String r=super.add(score);
		//决策树切入点
		if(r.equals(SUCCESS)){
			if(score.getStudentAccountId()!=null&&!score.getStudentAccountId().equals(0)){
				decisionTreeBusiness.student(scoreService,analyseService,score.getStudentAccountId());				
			}
			if(score.getTeacherCourseId()!=null&&!score.getTeacherCourseId().equals(0)){
				decisionTreeBusiness.teacher(scoreService,analyseService,score.getTeacherCourseId());				
			}
		}
		return r;
	}
	/**
	* 更新
	*/
	public String update()  {
		Score oldScore=scoreService.load(score.getScoreId());
		Map<String, Object> eq=new HashMap<>();
		//如果还是原来的学生和教师课程
		if(oldScore.getStudentAccountId().equals(score.getStudentAccountId())
				&&oldScore.getTeacherCourseId().equals(score.getTeacherCourseId())){
			score.setUpdateDate(new Date());
			String rr=super.update(score);
			//决策树切入点
			if(rr.equals(SUCCESS)){
				if(score.getStudentAccountId()!=null&&!score.getStudentAccountId().equals(0)){
					decisionTreeBusiness.student(scoreService,analyseService,score.getStudentAccountId());				
				}
				if(score.getTeacherCourseId()!=null&&!score.getTeacherCourseId().equals(0)){
					decisionTreeBusiness.teacher(scoreService,analyseService,score.getTeacherCourseId());				
				}
			}
			return rr;
		}
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		List<Score> cl=scoreService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","成绩已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		score.setUpdateDate(new Date());
		String r=super.update(score);
		//决策树切入点
		if(r.equals(SUCCESS)){
			if(score.getStudentAccountId()!=null&&!score.getStudentAccountId().equals(0)){
				decisionTreeBusiness.student(scoreService,analyseService,score.getStudentAccountId());				
			}
			if(score.getTeacherCourseId()!=null&&!score.getTeacherCourseId().equals(0)){
				decisionTreeBusiness.teacher(scoreService,analyseService,score.getTeacherCourseId());				
			}
		}
		return r;
	}
	/**
	 * 删除
	 */
	public String delete()  {
		Score s=scoreService.load(score.getScoreId());
		String r=super.delete(score.getScoreId());
		//决策树切入点
		if(r.equals(SUCCESS)){
			if(s.getStudentAccountId()!=null&&!s.getStudentAccountId().equals(0)){
				decisionTreeBusiness.student(scoreService,analyseService,s.getStudentAccountId());				
			}
			if(s.getTeacherCourseId()!=null&&!s.getTeacherCourseId().equals(0)){
				decisionTreeBusiness.teacher(scoreService,analyseService,s.getTeacherCourseId());				
			}
		}
		return r;
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(score.getScoreId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		return list(super.pageNum, super.pageSize, super.orderName, super.orderWay, eq, null, null, null, null, null, null, null);
	}

	/**
	 * 重写查询
	 */
	@Override
	public String list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		Map<String,List<Score> > map=new HashMap<>();
		try {
			List<Score> sl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			for (int i = 0; i < sl.size(); i++) {
				
				Score s=sl.get(i);
				Map<String, Object> eq1=new HashMap<>();
				eq1.put("teacherCourseId", s.getTeacherCourseId());
				List<TeacherCourse> tcl=teacherCourseService.list(1, 10, null, null, eq1, null, null, null, null, null, null, null);
				for (int j = 0; j < tcl.size(); j++) {
					TeacherCourse tc=tcl.get(j);
					Course c=courseService.load(tc.getCourseId());
					tc.setCourse(c);
					Account a=accountService.load(tc.getAccountId());
					tc.setAccount(a);
					s.setTeacherCourse(tc);
				}
				//TeacherCourse ntc=tcl.get(0);
				//s.setTeacherCourse(ntc);
				
				Map<String, Object> eq2=new HashMap<>();
				eq2.put("accountId", s.getStudentAccountId());
				List<Account> al2=accountService.list(1, 10, null, null, eq2, null, null, null, null, null, null, null);
				for (int z = 0; z < al2.size(); z++) {
					Account a=al2.get(z);
					s.setStudentAccount(a);
				}
			}
			map.put("list", sl);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(
					MyJSON.getJSONObject(map));
			return ERROR;
		}
	}
}