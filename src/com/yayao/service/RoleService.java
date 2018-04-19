package com.yayao.service;

import com.yayao.bean.Role;

/** 角色管理接口 */
public interface RoleService extends BaseService<Role, Integer>{

/*	*//** 新增角色*//*	
	public boolean addRole(Role role) ;	
	*//** 删除角色*//*	
	public boolean deleteRole(Integer roleId) ;	
	*//** 更新角色*//*	
	public boolean updateRole(Role role) ;	
	*//** 装载角色*//*	
	public Role loadRole(Integer roleId) ;	
	*//** 角色数量*//*	
	public int countAll(
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in
			) ;	
	*//** 浏览角色*//*
	public List<Role> browseRole(
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay,
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in
			);*/	
}