package com.nieyue.id3;
/** 
 * 收入
 */  
public enum  EmIncome {  
  
    HIGH(1, "高收入"),  
    MEDIUM(2,"中收入"),  
    LOW(3,"低收入");  
  
    private final Integer level;  
    private final String desc;  
    private EmIncome(Integer level, String desc) {this.level = level;this.desc = desc;}  
  
    public Integer getLevel(){return this.level;}  
  public static void main(String[] args) {
	System.out.println(EmIncome.HIGH.desc);
	System.out.println(EmIncome.HIGH.level);
}
}  