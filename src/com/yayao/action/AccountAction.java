package com.yayao.action;
import java.util.Date;
import java.util.HashMap;
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
		Account a=accountService.accountLogin(account.getPhone(),shapwd);
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
			map.put("account", session.get("account"));
			result=ResultUtil.getSlefSRSuccessList(MyJSON.getJSONObject(map));
			return SUCCESS;
		}
		result=ResultUtil.getSlefSRFailList(MyJSON.getJSONObject(map));
		return ERROR;
	}

	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("roleId", account.getRoleId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("roleId", account.getRoleId());
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, eq, null, null, null, null, null, null, null);
	}
	
	/**
	 * 增加
	 */
	public String add()  {
		account.setCreateDate(new Date());
		account.setLoginDate(new Date());
		account.setPassword(MyDESutil.getMD5(account.getPassword()));
		return super.add(account);
	}
	/**
	* 更新
	*/
	public String update()  {
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