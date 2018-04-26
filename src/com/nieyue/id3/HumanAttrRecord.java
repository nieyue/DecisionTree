package com.nieyue.id3;
/** 
 * 描述用户的属性类，包括收入、年龄、是否为学生、信用评级
 */  
public class HumanAttrRecord extends BaseRecord{  
    private EmAgeLevel age;  
    private EmIncome income;  
    private Boolean isStudent;  
    private EmCreditRate creditRate;  
  
  
    public HumanAttrRecord(EmAgeLevel age, EmIncome income, Boolean isStudent, EmCreditRate creditRate, Boolean decisionAttr) {  
        super(decisionAttr);  
        this.age = age;  
        this.income = income;  
        this.isStudent = isStudent;  
        this.creditRate = creditRate;  
  
    }  
  
    public EmAgeLevel getAge() {  
        return age;  
    }  
  
    public void setAge(EmAgeLevel age) {  
        this.age = age;  
    }  
  
    public EmIncome getIncome() {  
        return income;  
    }  
  
    public void setIncome(EmIncome income) {  
        this.income = income;  
    }  
  
    public Boolean getIsStudent() {  
        return isStudent;  
    }  
  
    public void setIsStudent(Boolean isStudent) {  
        this.isStudent = isStudent;  
    }  
  
    public EmCreditRate getCreditRate() {  
        return creditRate;  
    }  
  
    public void setCreditRate(EmCreditRate creditRate) {  
        this.creditRate = creditRate;  
    }  
  
}  