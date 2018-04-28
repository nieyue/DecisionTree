package com.nieyue.id3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;  
  
/** 
 * 决策树生成算法
 */  
public class DecisionTree<T> {  
  
	
    IAttrSelector<T> selector;  
  
    public DecisionTree(IAttrSelector<T> selector) {  
        this.selector = selector;  
    }  
    /**
     * 调用学生决策树
     * @param studentRecord,需要决策的数据
     */
    public boolean callStudentTree(StudentRecord studentRecord) { 
    	 List<StudentRecord> records = new ArrayList<>();  
    	 /**
    	  * 初始化规则
    	  */
    	 //占比小于0.2 不合格
         StudentRecord ss0=new StudentRecord("<0.2","any",false);
         //占比大于等于0.8  合格
         StudentRecord ss1=new StudentRecord(">=0.8","any",true);
         //占比大于等于0.2且小于0.8， 如果分数小于60  不合格,如果分数大于等于60 合格  （二级推断）
         StudentRecord ss2=new StudentRecord(">=0.2&&<0.8","<60.0",false);
         StudentRecord ss3=new StudentRecord(">=0.2&&<0.8",">=60.0",true);
          records.add(ss0);  
          records.add(ss1);  
          records.add(ss2);  
          records.add(ss3); 
          Set<Field> fieldSet = new HashSet<Field>();  
          Field[] fields = StudentRecord.class.getDeclaredFields();  
          for (Field field : fields) {  
              if(field.getName().equals("decisionAttr")) continue;;  
              if(field.getName().equals("accountId")) continue;  
              if(field.getName().equals("advise")) continue;  
              fieldSet.add(field);  
          } 
          
          IAttrSelector<StudentRecord> selector = new BaseAttrSelector<>();  
          DecisionTree<StudentRecord> decisionTree = new DecisionTree<>(selector);  
          StudentTreeNode root = decisionTree.createStudentTree(records,fieldSet); 
          boolean b=false;
          if(null != root) {  
              b= root.studentRecordPrint(b,0,studentRecord);  
          } 
          return b;
          
    }
    /**
     * 调用教师课程决策树
     * @param studentRecord,需要决策的数据
     */
    public boolean callTeacherCourseTree(StudentRecord studentRecord) { 
    	List<StudentRecord> records = new ArrayList<>();  
    	/**
    	 * 初始化规则
    	 */
    	/*StudentRecord ss0=new StudentRecord("<0.2","不合格",false);
    	StudentRecord ss1=new StudentRecord(">=0.2&&<0.4","合格",true);
    	StudentRecord ss2=new StudentRecord(">=0.4&&<0.6","良",true);
    	StudentRecord ss3=new StudentRecord(">=0.6&&<0.8","优秀",true);
    	records.add(ss0);  
    	records.add(ss1);  
    	records.add(ss2);  
    	records.add(ss3);  */
    	//占比小于0.2 质量差
    	StudentRecord ss0=new StudentRecord("<0.2","any",false);
    	//占比大于等于0.2  教师教育优良
    	StudentRecord ss1=new StudentRecord(">=0.2","any",true);
    	records.add(ss0);  
    	records.add(ss1);  
    	Set<Field> fieldSet = new HashSet<Field>();  
    	Field[] fields = StudentRecord.class.getDeclaredFields();  
    	for (Field field : fields) {  
    		if(field.getName().equals("decisionAttr")) continue;;  
    		if(field.getName().equals("accountId")) continue;
    		if(field.getName().equals("advise")) continue;
    		fieldSet.add(field);  
    	} 
    	
    	IAttrSelector<StudentRecord> selector = new BaseAttrSelector<>();  
    	DecisionTree<StudentRecord> decisionTree = new DecisionTree<>(selector);  
    	StudentTreeNode root = decisionTree.createStudentTree(records,fieldSet); 
    	 boolean b=false;
         if(null != root) {  
             b= root.studentRecordPrint(b,0,studentRecord);  
         } 
         return b;
    	
    }
    /**创建
     *决策树*/  
    public StudentTreeNode createStudentTree(List<T> records, Set<Field> attrSet) {  
        if(null == records || records.size() < 1)  
            return null;  
        StudentTreeNode node = new StudentTreeNode();  
        //1.如果所有的记录分类属性值都相同，如果全部相同则直接返回分类属性值  
        if(isAllInSameClass(records)){  
           // node.setAttrName(String.valueOf(records.get(0).getDecisionAttr()));
            try {
				node.setResult( String.valueOf(records.get(0).getClass().getMethod("getDecisionAttr").invoke(records.get(0))));
				StudentRecord sr=(StudentRecord) records.get(0);
				node.setStudentRecord(sr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            return node;  
        }  
        //2.如果属性列表为空，统计记录集合中正负样例个数，正>负?true:false  
        if(null == attrSet || 0 == attrSet.size()){  
            //node.setAttrName(String.valueOf(getMostClass(records)));  
            node.setResult(String.valueOf(getMostClass(records)));  
            StudentRecord sr=(StudentRecord) records.get(0);
			node.setStudentRecord(sr);
            return node;  
        }  
        //3.选择出来增益最大的属性  
        Field bestField = selector.select(records,attrSet);  
        //4.根据最好属性的值分为多个分支  
        List<List<T>> splitValues = splitRecords(records, bestField); 
        List<StudentTreeNode> children = new ArrayList<StudentTreeNode>(splitValues.size());  
        attrSet.remove(bestField);  
        //5.遍历子节点  
        for (List<T> recordList : splitValues) {  
            children.add(createStudentTree(recordList, attrSet));  
        }  
        node.setStudentTreeNodeList(children);  
       // node.setAttrName(bestField.getName());  
        node.setResult(bestField.getName());  
    	StudentRecord sr=(StudentRecord) records.get(0);
    	//System.err.println(bestField.getName());
    	//sr.setDecisionAttr(Boolean.valueOf(bestField.getName()));
    	node.setStudentRecord(sr);
        return node;  
    }  
    /**创建
     *决策树*/  
    public StudentTreeNode createTeacherCourseTree(List<T> records, Set<Field> attrSet) {  
    	if(null == records || records.size() < 1)  
    		return null;  
    	StudentTreeNode node = new StudentTreeNode();  
    	//1.如果所有的记录分类属性值都相同，如果全部相同则直接返回分类属性值  
    	if(isAllInSameClass(records)){  
    		// node.setAttrName(String.valueOf(records.get(0).getDecisionAttr()));
    		try {
    			node.setResult( String.valueOf(records.get(0).getClass().getMethod("getDecisionAttr").invoke(records.get(0))));
    			StudentRecord sr=(StudentRecord) records.get(0);
    			node.setStudentRecord(sr);
    		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
    				| NoSuchMethodException | SecurityException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}  
    		return node;  
    	}  
    	//2.如果属性列表为空，统计记录集合中正负样例个数，正>负?true:false  
    	if(null == attrSet || 0 == attrSet.size()){  
    		//node.setAttrName(String.valueOf(getMostClass(records)));  
    		node.setResult(String.valueOf(getMostClass(records)));  
    		StudentRecord sr=(StudentRecord) records.get(0);
    		node.setStudentRecord(sr);
    		return node;  
    	}  
    	//3.选择出来增益最大的属性  
    	Field bestField = selector.select(records,attrSet);  
    	//4.根据最好属性的值分为多个分支  
    	List<List<T>> splitValues = splitRecords(records, bestField); 
    	List<StudentTreeNode> children = new ArrayList<StudentTreeNode>(splitValues.size());  
    	attrSet.remove(bestField);  
    	//5.遍历子节点  
    	for (List<T> recordList : splitValues) {  
    		children.add(createStudentTree(recordList, attrSet));  
    	}  
    	node.setStudentTreeNodeList(children);  
    	// node.setAttrName(bestField.getName());  
    	node.setResult(bestField.getName());  
    	StudentRecord sr=(StudentRecord) records.get(0);
    	//System.err.println(bestField.getName());
    	//sr.setDecisionAttr(Boolean.valueOf(bestField.getName()));
    	node.setStudentRecord(sr);
    	return node;  
    }  
  
    /**根据属性的值分不同列表*/  
    private List<List<T>> splitRecords(List<T> records, Field field) {  
        List<List<T>> result = new ArrayList<List<T>>();  
        try {  
            field.setAccessible(true);  
        outerLoop :  
            for(T record : records) {  
                Object value = field.get(record);  
                for(List<T> recordList : result) {  
                    if(field.get(recordList.get(0)).equals(value)) {  
                        recordList.add(record);  
                        continue outerLoop;  
                    }  
                }  
                List<T> recordList = new ArrayList<>();  
                recordList.add(record);  
                result.add(recordList);  
            }  
        } catch (Exception ex) {  
            System.out.println("method access exception");  
        }  
  
        return result;  
    }  
  
    /**根据列表中分类的正负样例个数决定叶子节点为true or false*/  
    private Boolean getMostClass(List<T> records) {  
        int positCount = 0;  
        int negatCount = 0;  
        for(T record : records) {  
           // if(record.getDecisionAttr())  
            try {
				if((boolean)(record.getClass().getMethod("getDecisionAttr").invoke(record)))  
				    ++positCount;  
				else  
				    ++negatCount;
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }  
        return positCount > negatCount ? true : false;  
    }  
  
    /**判断所有记录是否具有相同的分类值*/  
    private boolean isAllInSameClass(List<T> records) {  
        //Boolean buyComp = records.get(0).getDecisionAttr();  
        Boolean buyComp;
		try {
			buyComp = (boolean)(records.get(0).getClass().getMethod("getDecisionAttr").invoke(records.get(0)));
			for(T record : records) {  
				//if(!buyComp.equals(record.getDecisionAttr()))  
				if(!buyComp.equals((boolean)(record.getClass().getMethod("getDecisionAttr").invoke(record))))  
					return false;  
			}  
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return true;  
    }  
  
}  
