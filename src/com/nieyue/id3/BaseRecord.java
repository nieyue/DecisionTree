package com.nieyue.id3;
/** 
 * 基础记录，这里只有一个属性，就是要分类的属性Boolean的，其他数据库实体都应该继承该类
 */  
public class BaseRecord {  
  
    private Boolean decisionAttr;  
  
    public BaseRecord(Boolean decisionAttr) {  
        this.decisionAttr = decisionAttr;  
    }  
  
    public Boolean getDecisionAttr() {  
        return decisionAttr;  
    }  
  
    public void setDecisionAttr(Boolean decisionAttr) {  
        this.decisionAttr = decisionAttr;  
    }  
  
  
  
  
}  