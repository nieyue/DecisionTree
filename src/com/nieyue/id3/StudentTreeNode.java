package com.nieyue.id3;
import java.util.List;  
  
/** 
 * 学生记录多叉树 
 */  
public class StudentTreeNode {  
	/**
	 * 属性值
	 */
	private String result;
    /**节点数据
     */
    private StudentRecord studentRecord;
    /**
     * 节点列表
     */
    private List<StudentTreeNode> studentTreeNodeList;  
  
    public StudentTreeNode(){}  
  
  
	@Override
	public String toString() {
		return "StudentTreeNode [result=" + result + ", studentRecord=" + studentRecord + ", studentTreeNodeList="
				+ studentTreeNodeList + "]";
	}


	public StudentTreeNode(String result, StudentRecord studentRecord, List<StudentTreeNode> studentTreeNodeList) {
		super();
		this.result = result;
		this.studentRecord = studentRecord;
		this.studentTreeNodeList = studentTreeNodeList;
	}





	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}

	public StudentRecord getStudentRecord() {
		return studentRecord;
	}


	public void setStudentRecord(StudentRecord studentRecord) {
		this.studentRecord = studentRecord;
	}



	public List<StudentTreeNode> getStudentTreeNodeList() {
		return studentTreeNodeList;
	}



	public void setStudentTreeNodeList(List<StudentTreeNode> studentTreeNodeList) {
		this.studentTreeNodeList = studentTreeNodeList;
	}



	public void print(int level) {  
        if(null == this)  
            return;  
        for (int i=0; i<level;++i)  
            System.out.print("-");  
        System.out.println(this.studentRecord.getDecisionAttr());  
        ++level;  
        if (null != this.getStudentTreeNodeList())  
            for (StudentTreeNode node : this.getStudentTreeNodeList()) {  
            	//System.out.print("("+node.getAttrName()+")");  
                node.print(level);  
            }  
    }  
    public void studentRecordPrint(int level,StudentRecord sr) {  
    	if(null == this)  
    		return;  
    	for (int i=0; i<level;i++)  
    		System.out.print("-");  
    	System.out.println(this.getResult());  
    	level++;  
    	if (null != this.getStudentTreeNodeList())  
    		for (StudentTreeNode node : this.getStudentTreeNodeList()) {  
    			if(node.getStudentRecord().getAvgscore().equals(sr.getAvgscore())
    					&&node.getStudentRecord().getScore().equals(sr.getScore())){
    				System.err.println("("+node.getStudentRecord().getAvgscore()+"--"+node.getStudentRecord().getScore()+"--"+node.getStudentRecord().getDecisionAttr()+")");
    			}
    			//System.err.print("("+node.getAttrName()+")");  
    			//System.err.print("("+node.getStudentRecord().getAvgscore()+"--"+node.getStudentRecord().getScore()+"--"+node.getStudentRecord().getDecisionAttr()+")");  
    			node.studentRecordPrint(level,sr);  
    		}  
    }  
    public static void main(String[] args) {
		System.out.println(2);
		//new TreeNode<T>().print(EmIncome.HIGH.getLevel());
		
	}


}  