package com.yayao.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.yayao.bean.Role;
import com.yayao.service.RoleService;


/**
 * 角色
 * @author yy
 *
 */
public class RoleAction extends BaseAction<Role,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleService roleService;
	private Role role=new Role();//角色模型


/*	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}*/
	@Override
	public Role getModel() {
		return role;
	}
	/**
	 * 增加
	 */
	public String add()  {
		role.setUpdateDate(new Date());
		return super.add(role);
	}
	/**
	* 更新
	*/
	public String update()  {
		role.setUpdateDate(new Date());
		return super.update(role);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(role.getRoleId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(role.getRoleId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		return super.countAll(null, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, null, null, null, null, null, null, null, null);
	}

	
}