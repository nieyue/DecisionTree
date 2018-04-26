package com.nieyue.id3;
/** 
 * 信用记录
 */  
public enum  EmCreditRate {  
  
    EXCELLENT(1, "优秀"),  
    FAIR(2,"正常");  
  
    private final Integer level;  
    private final String desc;  
    private EmCreditRate(Integer level, String desc) {this.level = level;this.desc = desc;}  
  
    public Integer getLevel(){return this.level;}

	public String getDesc() {
		return desc;
	}  
  
}  