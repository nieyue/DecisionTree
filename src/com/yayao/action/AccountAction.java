package com.yayao.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.yayao.bean.Account;
import com.yayao.service.AccountService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.MyDESutil;
import com.yayao.util.MyJSON;
import com.yayao.util.ResultUtil;


/**
 * 管理员登录、退出
 * @author yy
 *
 */
public class AccountAction extends BaseAction<Account,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private AccountService accountService;

	private String validate;	//验证码 
	private Account account=new Account();

	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	@Override
	public Account getModel() {
		return account;
	}
	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 */
	public String login()  {
		Map<String,Object> session = ActionContextUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		String shapwd = MyDESutil.getMD5(account.getPassword());
		Account a=accountService.accountLogin(account.getAccountId(),shapwd);
		//Account a=accountService.accountLogin(account.getPhone(),shapwd);
		if(a==null){
			map.put("account", a);
			result=ResultUtil.getSlefSRList("40000", "账户或密码错误", MyJSON.getJSONObject(map));
			return ERROR;
		}else{
			session.put("account", a);
			map.put("account", a);
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
	}
	/**
	 *退出
	 * @return
	 * @throws Exception
	 */
	   @SkipValidation
		public String loginout(){
			Map<String,Object>  session = ActionContextUtil.getSession();
			Account a = (Account) session.get("account");
			Map<String,Object> map=new HashMap<String,Object>();
			if(a!=null){
				session.remove("account");
				session.clear();
				result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
				return SUCCESS;
			}else{
				result=ResultUtil.getSlefSRFailList(MyJSON.getJSONObject(map));
				return ERROR;
			}
			
		}
	/**
	 * 验证码
	 */
	@SkipValidation
	public String valid(){
		Map<String,Object>  session = ActionContextUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		if(session.get("random").equals(validate)) {
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRFailList(MyJSON.getJSONObject(map));
		return ERROR;
	}
	/**
	 * 是否登录
	 */
	public String islogin(){
		Map<String,Object>  session = ActionContextUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		if(session.get("account")!=null) {
			map.put("account", accountService.load(((Account)session.get("account")).getAccountId()));
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRList("50000", "账户未登录", MyJSON.getJSONObject(map));
		return ERROR;
	}

	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("roleId", account.getRoleId());
		eq.put("accountId", account.getAccountId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("roleId", account.getRoleId());
		eq.put("accountId", account.getAccountId());
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, eq, null, null, null, null, null, null, null);
	}
	
	/**
	 * 增加
	 */
	public String add()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("phone", account.getPhone());
		List<Account> al=accountService.list(1,10, null, null, eq, null, null, null, null, null, null, null);
		if(al.size()>0){
			if(al.get(0).getPhone().equals(account.getPhone())){
				Map<String,Account> map=new HashMap<>();
				result=ResultUtil.getSlefSRList("50000", "手机号已存在", MyJSON.getJSONObject(map));
				return ERROR;
			}
		}
		account.setCreateDate(new Date());
		account.setLoginDate(new Date());
		account.setPassword(MyDESutil.getMD5(account.getPassword()));
		return super.add(account);
	}
	/**
	* 更新
	*/
	public String update()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("phone", account.getPhone());
		List<Account> al=accountService.list(1,10, null, null, eq, null, null, null, null, null, null, null);
		if(al.size()>0){
			if(al.get(0).getPhone().equals(account.getPhone())
					&&!al.get(0).getAccountId().equals(account.getAccountId())){
				Map<String,Account> map=new HashMap<>();
					result=ResultUtil.getSlefSRList("50000", "手机号已存在", MyJSON.getJSONObject(map));
				return ERROR;
			}
			if(!al.get(0).getPassword().equals(account.getPassword())){
				account.setPassword(MyDESutil.getMD5(account.getPassword()));			
			}
			
		}
		Map<String,Object>  session = ActionContextUtil.getSession();
		return super.update(account);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(account.getAccountId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(account.getAccountId());
	}
	
}