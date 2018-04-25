package com.yayao.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.yayao.bean.Account;
import com.yayao.bean.Course;
import com.yayao.bean.TeacherCourse;
import com.yayao.service.AccountService;
import com.yayao.service.CourseService;
import com.yayao.service.TeacherCourseService;
import com.yayao.util.MyJSON;
import com.yayao.util.ResultUtil;


/**
 * 教师课程
 * @author yy
 *
 */
public class TeacherCourseAction extends BaseAction<TeacherCourse,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private AccountService accountService;
	private TeacherCourse teacherCourse=new TeacherCourse();//教师课程模型

	@Override
	public TeacherCourse getModel() {
		return teacherCourse;
	}
	/**
	 * 增加
	 */
	public String add()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("courseId", teacherCourse.getCourseId());
		eq.put("accountId", teacherCourse.getAccountId());
		List<TeacherCourse> cl=teacherCourseService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","教师课程已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		teacherCourse.setUpdateDate(new Date());
		return super.add(teacherCourse);
	}
	/**
	* 更新
	*/
	public String update()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("courseId", teacherCourse.getCourseId());
		eq.put("accountId", teacherCourse.getAccountId());
		List<TeacherCourse> cl=teacherCourseService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","教师课程已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		teacherCourse.setUpdateDate(new Date());
		return super.update(teacherCourse);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(teacherCourse.getTeacherCourseId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(teacherCourse.getTeacherCourseId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("accountId", teacherCourse.getAccountId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("accountId", teacherCourse.getAccountId());
		return list(super.pageNum, super.pageSize, super.orderName, super.orderWay, eq, null, null, null, null, null, null, null);
	}
	/**
	 * 重写查询
	 */
	@Override
	public String list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		Map<String,List<TeacherCourse> > map=new HashMap<>();
		try {
			List<TeacherCourse> rl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			for (int i = 0; i < rl.size(); i++) {
				TeacherCourse tc=rl.get(i);
				Course c=courseService.load(tc.getCourseId());
				tc.setCourse(c);
				Account a=accountService.load(tc.getAccountId());
				tc.setAccount(a);
			}
			map.put("list", rl);
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