package com.yayao.action;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.yayao.bean.Account;
import com.yayao.service.AccountService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.SHAutil;

import net.sf.json.JSONObject;


/**
 * 管理员登录、退出
 * @author yy
 *
 */
public class AccountAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private AccountService accountService;
	private JSONObject result;//返回数据
	
	private String phone;//登陆账号
	private String password;//登陆密码
	private String validate;	//验证码

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 */
	public String login()  {
		Map<String,Object> session = ActionContextUtil.getSession();
		String shapwd;
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			shapwd = SHAutil.getSHA(password);
			map.put("code", 200);
			map.put("msg", "成功");
			map.put("data", shapwd);
			 result=JSONObject.fromObject(map);
			//result=json.toString();
			return SUCCESS;
		} catch (Exception e) {
			map.put("code", 4000);
			map.put("msg", "失败");
			result=JSONObject.fromObject(map);
			return ERROR;
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
				map.put("code", 200);
				map.put("msg", "成功");
				result=JSONObject.fromObject(map);
				return SUCCESS;
			}else{
				map.put("code", 40000);
				map.put("msg", "失败");
				result=JSONObject.fromObject(map);
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
			map.put("code", 200);
			map.put("msg", "成功");
			result=JSONObject.fromObject(map);
			return SUCCESS;
		}
		map.put("code", 40000);
		map.put("msg", "失败");
		result=JSONObject.fromObject(map);
		return ERROR;
	}
	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}

	
}