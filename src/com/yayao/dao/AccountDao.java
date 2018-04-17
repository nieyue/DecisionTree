package com.yayao.dao;

import java.util.List;

import com.yayao.bean.Account;

/** 账户管理接口 */
public interface AccountDao {

	/** 账户登录 */
	public Account accountLogin(String phone,String passwords);
	/** 新增账户 */	
	public boolean addAccount(Account account) ;	
	/** 删除账户 */	
	public boolean delAccount(Integer accountId) ;	
	/** 更新账户 */	
	public boolean updateAccount(Account account) ;	
	/** 装载账户 */	
	public Account loadAccount(Integer accountId) ;	
	/** 浏览账户 */
	public List<Account> browseAccount() ;	
}