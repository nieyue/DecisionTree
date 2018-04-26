package com.nieyue.id3;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;  
  
/** 
 * Created by wudi on 2016/1/23. 
 */  
public class Test2 {  
    public static void main(String[] arr) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {  
        List<StudentRecord> records = new ArrayList<>();  
       StudentRecord ss0=new StudentRecord(70.0,50.0,false);
       StudentRecord ss1=new StudentRecord(70.0,48.0,false);
       StudentRecord ss2=new StudentRecord(90.0,66.0,false);
       StudentRecord ss3=new StudentRecord(50.0,70.0,true);
       StudentRecord ss4=new StudentRecord(70.0,80.0,true);
       StudentRecord ss5=new StudentRecord(90.0,80.0,false);
       StudentRecord ss6=new StudentRecord(44.0,44.0,false);
        records.add(ss0);  
        records.add(ss1);  
        records.add(ss2);  
        records.add(ss3);  
        records.add(ss4);  
        records.add(ss5);  
        records.add(ss6);  
  
//        System.out.println(records.get(0).getDecisionAttr());
//        System.out.println(records.get(0).getClass().getDeclaredField("score"));
//        System.out.println(records.get(0).getClass().getSimpleName());
//        System.out.println(records.get(0).getClass().getMethod("getAvgscore").invoke(records.get(2)));
//        System.out.println(records.get(0).getClass().getMethod("getDecisionAttr").invoke(records.get(3)));
        System.out.println("-----------");
        
        Set<Field> fieldSet = new HashSet<Field>();  
        Field[] fields = StudentRecord.class.getDeclaredFields();  
        for (Field field : fields) {  
            if(field.getName().equals("decisionAttr")) continue;;  
            fieldSet.add(field);  
        } 
        
        IAttrSelector<StudentRecord> selector = new BaseAttrSelector<>();  
        DecisionTree<StudentRecord> decisionTree = new DecisionTree<>(selector);  
        StudentTreeNode root = decisionTree.createStudentTree(records,fieldSet); 
        System.out.println(root);
        if(null != root) {  
        	StudentRecord css2=new StudentRecord(44.0,44.0,true);
            root.studentRecordPrint(0,css2);  
        } 
    }  
}  