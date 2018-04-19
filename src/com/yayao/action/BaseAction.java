package com.yayao.action;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
	public StateResultList<JSONObject> getResult() {
		return result;
	}

	public void setResult(StateResultList<JSONObject> result) {
		this.result = result;
	}


	/**
	 * 增加
	 */
	public String add(T t)  {
		Map<String,Object> map=new HashMap<String,Object>();
		List<T> list=new ArrayList<>();
		boolean b=baseService.add(t);
		if(b){
			list.add(t);
			map.put("data", list);
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
		Map<String,Object> map=new HashMap<String,Object>();
		List<T> list=new ArrayList<>();
		boolean b=baseService.update(t);
		if(b){
			list.add(t);
			map.put("data", list);
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
		Map<String,Object> map=new HashMap<String,Object>();
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
		Map<String,Object> map=new HashMap<String,Object>();
		List<T> list=new ArrayList<>();
		try {
			T t=baseService.load(id);
				list.add(t);
				map.put("data", list);
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
		Map<String,Object> map=new HashMap<String,Object>();
		List<Integer> list=new ArrayList<>();
		try {
			
			int number=baseService.countAll(eq, gt, ge, lt, le, between, like, in);
			list.add(number);
			map.put("data", list);
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
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			
			List<T> rl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			map.put("data", rl);
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