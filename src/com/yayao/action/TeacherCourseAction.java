package com.yayao.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.bean.TeacherCourse;
import com.yayao.service.TeacherCourseService;


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
	private TeacherCourse teacherCourse=new TeacherCourse();//教师课程模型

	@Override
	public TeacherCourse getModel() {
		return teacherCourse;
	}
	/**
	 * 增加
	 */
	public String add()  {
		teacherCourse.setUpdateDate(new Date());
		return super.add(teacherCourse);
	}
	/**
	* 更新
	*/
	public String update()  {
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
		return super.countAll(null, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, null, null, null, null, null, null, null, null);
	}

	
}