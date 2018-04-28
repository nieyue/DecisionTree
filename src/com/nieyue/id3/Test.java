package com.nieyue.id3;
import java.lang.reflect.InvocationTargetException;  
  
/** 
 * Created by wudi on 2016/1/23. 
 */  
public class Test {
	IAttrSelector<StudentRecord> selector;  
	  
    public static void main(String[] arr) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {  
    	DecisionTree<StudentRecord> dt=new DecisionTree<StudentRecord>(new Test().selector);
       // System.out.println(root);
        	 //StudentRecord css2=new StudentRecord("<0.2","any",1000,true);
        	//占比大于等于0.8  合格
        	//StudentRecord css2=new StudentRecord(">=0.8","any",1000,true);
             //占比大于等于0.2且小于0.8， 如果分数小于60  不合格,如果分数大于等于60 合格  （二级推断）
             //StudentRecord css2=new StudentRecord(">=0.2&&<0.8","<60.0",1000,false);
             //StudentRecord css2=new StudentRecord(">=0.2&&<0.8",">=60.0",1000,true);
           //  System.err.println(dt.callStudentTree(css2));
    	
    	 //StudentRecord css2=new StudentRecord("<0.2","不合格",false);
     	//StudentRecord css2=new StudentRecord(">=0.2&&<0.4",true);
     	//StudentRecord css2=new StudentRecord(">=0.4&&<0.6","良",true);
     	//StudentRecord css2=new StudentRecord(">=0.6&&<0.8","优秀",true);
    	//占比大于等于0.2  合格
     	StudentRecord css2=new StudentRecord("<0.2","any",1000,true);
    	//StudentRecord css2=new StudentRecord(">=0.2","any",1000,true);
             System.err.println(dt.callTeacherCourseTree(css2));
    }  
}  