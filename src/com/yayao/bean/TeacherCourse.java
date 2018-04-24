package com.yayao.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 教师课程类
 * @author yy
 *
 */
@Entity
@Table(name="teacher_course_tb")
public class TeacherCourse implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="increment")
	@SequenceGenerator(name = "increment",initialValue = 1000)
	private Integer teacherCourseId;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 教师id
	 */
	private Integer accountId;
	/**
	 * 课程id
	 */
	private Integer courseId;
	/**
	 * 课程
	 */
	@Transient
	private Course course;
	public Integer getTeacherCourseId() {
		return teacherCourseId;
	}
	public void setTeacherCourseId(Integer teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}