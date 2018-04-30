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
 * 成绩类
 * @author yy
 *
 */
@Entity
@Table(name="score_tb")
public class Score implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="increment")
	@SequenceGenerator(name = "increment",initialValue = 1000)
	private Integer scoreId;
	/**
	 * 成绩
	 */
	private Double score;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 学生id
	 */
	private Integer studentAccountId;
	/**
	 * 教师课程id
	 */
	private Integer teacherCourseId;
	/**
	 * 学生
	 */
	@Transient
	private Account studentAccount;
	/**
	 * 教师课程
	 */
	@Transient
	private TeacherCourse teacherCourse;
	
	public Account getStudentAccount() {
		return studentAccount;
	}
	public void setStudentAccount(Account studentAccount) {
		this.studentAccount = studentAccount;
	}
	public Integer getScoreId() {
		return scoreId;
	}
	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getStudentAccountId() {
		return studentAccountId;
	}
	public void setStudentAccountId(Integer studentAccountId) {
		this.studentAccountId = studentAccountId;
	}
	public Integer getTeacherCourseId() {
		return teacherCourseId;
	}
	public void setTeacherCourseId(Integer teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TeacherCourse getTeacherCourse() {
		return teacherCourse;
	}
	public void setTeacherCourse(TeacherCourse teacherCourse) {
		this.teacherCourse = teacherCourse;
	}
	
}