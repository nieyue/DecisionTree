package com.yayao.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.yayao.bean.Account;
import com.yayao.dao.AccountDao;


/** 
 * 账户接口实现
 */
@Repository
public class AccountDaoImpl  implements AccountDao{
	@Resource
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	}
	
	
	/** 
	 * 账户登录
	 */
	public Account accountLogin(String phone, String password)  {
			
		    Criteria c = getSession().createCriteria(Account.class);
			c.add(Restrictions.eq("phone", phone));
			c.add(Restrictions.eq("password",password));
			Account Account = (Account) c.uniqueResult();
			return Account;
	}

	/** 新增管理员 */	
	
	public boolean addAccount(Account account) {
		 try{
			 getSession().save(account);
			 getSession().close();
		     return true;
		    }catch(Exception e){
		     getSession().close();
		     return false;
		    }
	}

	/** 浏览管理员 */
	public List<Account> browseAccount() {
//			Criteria c = getSession().createCriteria(Account.class);		
//			c.addOrder(Order.desc("id"));
//			List Accounts=c.list();
			Query hql = getSession()
					.createQuery("from Account order by acccountId desc");
			@SuppressWarnings("unchecked")
			List<Account> list = hql.list();
		return list;
	}

	/** 删除指定的管理员 
	 * @throws Exception */
	public boolean delAccount(Integer accountId)  {
		
			//Account Account = (Account)getSession().get(Account.class, id);
			//Criteria c = getSession().createCriteria(Account.class);
			//c.add(Restrictions.eq("id", id));
			//Account Account = (Account) c.uniqueResult();
			//getSession().delete(Account);
			
			
			//Query q = getSession().createSQLQuery(" delete from Account_tb  where id=:id ");
			
//			Query hql = getSession().createQuery(" delete from Account as a  where a.id=:id");
//			hql.setInteger("id", id);
//			hql.executeUpdate();
		Account account = (Account)getSession()
				.get(Account.class, accountId);
		 try{
			 getSession().delete(account);
			 getSession().close();
		        return true;
		    }catch(Exception e){
		    	getSession().close();
		        return false;
		    }
	}
	/** 装载指定的管理员 */
	public Account loadAccount(Integer accountId){
		Account Account = (Account)getSession().get(Account.class, accountId);
		return Account;
	}

	/** 更新管理员 */	
	public boolean updateAccount(Account account) {
			/*Query q = getSession().createSQLQuery(
					" UPDATE Account_tb "+ 
                    " SET AccountType=?, "+ 
                    " AccountName=?, "+
                    " LoginName=?, "+ 
                    " LoginPwd =? "+ 
                    " WHERE ID=? ");
			q.setInteger(0, Account.getAccountType());
			q.setString(1, Account.getAccountName());
			q.setString(2, Account.getLoginName());
			q.setString(3, Account.getLoginPwd());
			q.setInteger(4, Account.getId());
			*/
//			Query hql= getSession().createQuery("update Account a set a.AccountType=?,a.AccountName=?,a.loginName=?,a.loginPwd=? where a.id=? ");
//			hql.setInteger(0, Account.getAccountType());
//			hql.setString(1, Account.getAccountName());
//			hql.setString(2, Account.getLoginName());
//			hql.setString(3, Account.getLoginPwd());
//			hql.setInteger(4, Account.getId());
//			hql.executeUpdate();
		 try{
			 getSession().merge(account);
			 getSession().close();
		        return true;
		    }catch(Exception e){
		    	getSession().close();
		        return false;
		    }
	}



}