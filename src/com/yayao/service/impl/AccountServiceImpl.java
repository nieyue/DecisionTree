package com.yayao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yayao.bean.Account;
import com.yayao.dao.AccountDao;
import com.yayao.service.AccountService;
import com.yayao.util.ActionContextUtil;


/** 系统用户管理接口实现 */
@Service
public class AccountServiceImpl  implements AccountService{
	@Resource
	private AccountDao accountDao;
	/** 系统管理员登录 */
	public Account AccountLogin(String phone, String password){
		Account account = accountDao.accountLogin(phone, password);
		return account;
	}

	/** 新增管理员 */	
	
	public boolean addAccount(Account account){
			return  accountDao.addAccount(account);
	}

	/** 浏览所有管理员信息 */
	public List<Account> browseAccount(){
			
			//浏览所有管理人信息
			List<Account> list=accountDao.browseAccount();
			ActionContextUtil.getSession().remove("accountList");
			//存储当前管理人信息
			ActionContextUtil.getSession().put("accountList", list);
			return list;
	}

	/** 删除指定的管理员 */
	public boolean deleteAccount(Integer accountId) {
		return accountDao.delAccount(accountId);
	}

	/** 装载指定的管理员 */
	public Account loadAccount(Integer accountId)  {
		Account account=accountDao.loadAccount(accountId);
		return account;
	}

	/** 更新管理员 */	
	public boolean updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public Account accountLogin(String phone, String passwords) {
		Account a=accountDao.accountLogin(phone, passwords);
		return a;
	}
}