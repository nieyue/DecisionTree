package com.nieyue.id3;
/** 
 * 描述成绩的评定
 */  
public class StudentRecord extends BaseRecord{
	private Double avgscore;
	private Double score;
	
	@Override
	public String toString() {
		return "StudentRecord [avgscore=" + avgscore + ", score=" + score + "]";
	}
	public StudentRecord(Boolean decisionAttr) {
		super(decisionAttr);
	}
	public StudentRecord(Double avgscore,Double score,Boolean decisionAttr) {
		super(decisionAttr);
		this.avgscore=avgscore;
		this.score=score;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(Double avgscore) {
		this.avgscore = avgscore;
	}  
    
}  