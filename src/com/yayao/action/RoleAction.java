package com.yayao.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.yayao.bean.Role;
import com.yayao.service.RoleService;

import net.sf.json.JSONObject;


/**
 * 角色
 * @author yy
 *
 */
public class RoleAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private RoleService roleService;
	private JSONObject result;//返回数据
	private Role role;//角色模型
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 增加
	 */
	public String add()  {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Role> list=new ArrayList<>();
		try {
			
			boolean b=roleService.add(role);
			if(b){
				map.put("code", 200);
				map.put("msg", "成功");
				list.add(role);
				map.put("data", list);
				result=JSONObject.fromObject(map);
			}
			return SUCCESS;
		} catch (Exception e) {
			map.put("code", 4000);
			map.put("msg", "失败");
			result=JSONObject.fromObject(map);
			return ERROR;
		}
	}
	/**
	* 更新
	*/
	public String update()  {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Role> list=new ArrayList<>();
		try {
			
			boolean b=roleService.update(role);
			if(b){
				map.put("code", 200);
				map.put("msg", "成功");
				list.add(role);
				map.put("data", list);
				result=JSONObject.fromObject(map);
			}
			return SUCCESS;
		} catch (Exception e) {
			map.put("code", 4000);
			map.put("msg", "失败");
			result=JSONObject.fromObject(map);
			return ERROR;
		}
	}
	/**
	 * 删除
	 */
	public String delete()  {
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			
			boolean b=roleService.delete(role.getRoleId());
			if(b){
				map.put("code", 200);
				map.put("msg", "成功");
				result=JSONObject.fromObject(map);
			}
			return SUCCESS;
		} catch (Exception e) {
			map.put("code", 4000);
			map.put("msg", "失败");
			result=JSONObject.fromObject(map);
			return ERROR;
		}
	}
	/**
	* 数量
	*/
	public String countAll()  {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Integer> list=new ArrayList<>();
		try {
			
			int number=roleService.countAll(null, null, null, null, null, null, null, null);
				map.put("code", 200);
				map.put("msg", "成功");
				list.add(number);
				map.put("data", list);
				result=JSONObject.fromObject(map);
			return SUCCESS;
		} catch (Exception e) {
			map.put("code", 4000);
			map.put("msg", "失败");
			result=JSONObject.fromObject(map);
			return ERROR;
		}
	}
	/**
	 * 数量
	 */
	public String browse()  {
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			
			List<Role> rl=roleService.browse(1,10,"role_id",null,null, null, null, null, null, null, null, null);
			map.put("code", 200);
			map.put("msg", "成功");
			map.put("data", rl);
			result=JSONObject.fromObject(map);
			return SUCCESS;
		} catch (Exception e) {
			map.put("code", 4000);
			map.put("msg", "失败");
			result=JSONObject.fromObject(map);
			return ERROR;
		}
	}

	
}