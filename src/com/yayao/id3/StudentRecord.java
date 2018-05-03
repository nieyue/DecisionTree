package com.yayao.id3;
/** 
 * 描述成绩的评定
 */  
public class StudentRecord extends BaseRecord{
	//比率
	private String scale;
	//分数
	private String score;
	//是否偏科
	private String isPartial;
	//账户id,不参与创建决策树，只用来做查询
	private Integer accountId; 
	//账户建议，不参与决策树
	private String advise; 
	
	
	public StudentRecord(String scale, String score,Integer accountId,String advise,Boolean decisionAttr) {
		super(decisionAttr);
		this.scale = scale;
		this.score = score;
		this.accountId = accountId;
		this.advise = advise;
	}
	public StudentRecord(String scale, String score,Integer accountId,Boolean decisionAttr) {
		super(decisionAttr);
		this.scale = scale;
		this.score = score;
		this.accountId = accountId;
	}
	public StudentRecord(String scale, String score,Boolean decisionAttr) {
		super(decisionAttr);
		this.scale = scale;
		this.score = score;
	}
	public StudentRecord(String scale,Boolean decisionAttr) {
		super(decisionAttr);
		this.scale = scale;
	}

	public StudentRecord(Boolean decisionAttr) {
		super(decisionAttr);
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}
    
}  