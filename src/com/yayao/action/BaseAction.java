package com.yayao.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yayao.service.BaseService;
import com.yayao.util.MyJSON;
import com.yayao.util.ResultUtil;
import com.yayao.util.StateResultList;

import net.sf.json.JSONObject;


/**
 * 基础action
 * @author yy
 *
 */
public abstract class BaseAction<T,ID> extends ActionSupport implements ModelDriven<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	protected BaseService<T,ID> baseService;
	protected StateResultList<JSONObject> result;//返回数据
	protected int pageNum;	//当前数 
	protected int pageSize;	//每页个数
	protected String orderName;	//排序名称
	protected String orderWay;	//desc降序，asc升序
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderWay() {
		return orderWay;
	}
	public void setOrderWay(String orderWay) {
		this.orderWay = orderWay;
	}
	public StateResultList<JSONObject> getResult() {
		return result;
	}

	public void setResult(StateResultList<JSONObject> result) {
		this.result = result;
	}

	/**
	 * 获取类型名。再首字母转小写
	 */
	String getName(T t){
		String s=t.getClass().getSimpleName();
		String s1 = s.substring(0, 1); 
		 String s2 = s.substring(1); 
		 String s3 = s1.toLowerCase();  
		 String s4 = s3.concat(s2);  
		return s4;
	}
	/**
	 * 增加
	 */
	public String add(T t)  {
		Map<String,T> map=new HashMap<>();
		boolean b=baseService.add(t);
		if(b){
			map.put(getName(t), t);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRFailList(
				MyJSON.getJSONObject(map));
		return ERROR;
	}
	/**
	* 更新
	*/
	public String update(T t)  {
		Map<String,T> map=new HashMap<>();
		boolean b=baseService.update(t);
		if(b){
			map.put(getName(t), t);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRFailList(
				MyJSON.getJSONObject(map));
		return ERROR;
	}
	/**
	 * 删除
	 */
	public String delete(Integer ID)  {
		Map<String,T> map=new HashMap<>();
		boolean b=baseService.delete(ID);
		if(b){
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRFailList(
				MyJSON.getJSONObject(map));
		return ERROR;
	}
	/**
	*加载
	*/
	public String load(Integer id)  {
		Map<String,T> map=new HashMap<String,T>();
		try {
			T t=baseService.load(id);
				map.put(getName(t), t);
				result=ResultUtil.getSlefSRSuccessList(
						MyJSON.getJSONObject(map));
			return SUCCESS;
		} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(
					MyJSON.getJSONObject(map));
			return ERROR;
		}
	}

	/**
	 * 数量
	 */
	public String countAll(
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in)  {
		Map<String,Integer> map=new HashMap<>();
		try {
			
			int total=baseService.countAll(eq, gt, ge, lt, le, between, like, in);
			map.put("total", total);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(
					MyJSON.getJSONObject(map));
			return ERROR;
		}
	}
	/**
	 * 查询
	 */
	public String list(
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay,
			Map<String, Object> eq,
			Map<String, Object> gt,
			Map<String, Object> ge,
			Map<String, Object> lt,
			Map<String, Object> le,
			Map<String, List<Object>> between,
			Map<String, Object> like,
			Map<String, List<Object>> in)  {
		Map<String,List<T> > map=new HashMap<>();
		try {
			List<T> rl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			map.put("list", rl);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(
					MyJSON.getJSONObject(map));
			return ERROR;
		}
	}

	
}