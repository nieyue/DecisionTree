package com.yayao.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 分析类
 * @author yy
 *
 */
@Entity
@Table(name="analyse_tb")
public class Analyse implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="increment")
	@SequenceGenerator(name = "increment",initialValue = 1000)
	private Integer analyseId;
	/**
	 * 类型1教师建议，2学生建议
	 */
	private Integer type;
	/**
	 * 子类型，1优，2良，3合格，4不合格
	 */
	private Integer subType;
	/**
	 * 总评分
	 */
	private Double score;
	/**
	 * 结论
	 */
	private String conclusion;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 业务id,type=1就是教师课程id,type=2就是学生账户id
	 */
	private Integer businessId;
	public Integer getAnalyseId() {
		return analyseId;
	}
	public void setAnalyseId(Integer analyseId) {
		this.analyseId = analyseId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSubType() {
		return subType;
	}
	public void setSubType(Integer subType) {
		this.subType = subType;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}