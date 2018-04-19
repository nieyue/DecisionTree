package com.yayao.dao;

import com.yayao.bean.Account;

/** 账户管理接口 */
public interface AccountDao extends BaseDao<Account,Integer> {

	/** 账户登录 */
	public Account accountLogin(String phone,String passwords);
}