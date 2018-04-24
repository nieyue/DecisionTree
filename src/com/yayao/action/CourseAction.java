package com.yayao.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.bean.Course;
import com.yayao.service.CourseService;


/**
 * 课程
 * @author yy
 *
 */
public class CourseAction extends BaseAction<Course,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CourseService courseService;
	private Course course=new Course();//课程模型

	@Override
	public Course getModel() {
		return course;
	}
	/**
	 * 增加
	 */
	public String add()  {
		course.setUpdateDate(new Date());
		return super.add(course);
	}
	/**
	* 更新
	*/
	public String update()  {
		course.setUpdateDate(new Date());
		return super.update(course);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(course.getCourseId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(course.getCourseId());
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