package com.yayao.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yayao.bean.Account;
import com.yayao.dao.AccountDao;
import com.yayao.service.AccountService;


/** 系统用户管理接口实现 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account,Integer> implements AccountService{
	@Autowired
	AccountDao accountDao;
	/** 系统管理员登录 */
	public Account accountLogin(String phone, String password){
		Account account =accountDao.accountLogin(phone, password);
		if(account!=null){
			account.setLoginDate(new Date());
			accountDao.update(account);
		}
		return account;
	}

}