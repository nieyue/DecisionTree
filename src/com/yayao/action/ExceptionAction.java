package com.yayao.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yayao.util.ResultUtil;
import com.yayao.util.StateResultList;

import net.sf.json.JSONObject;
/**
 * 异常返回
 * @author 聂跃
 * @date 2018年4月21日
 */
public class ExceptionAction extends ActionSupport {
	protected StateResultList<JSONObject> result;//返回数据
	public StateResultList<JSONObject> getResult() {
		return result;
	}

	public void setResult(StateResultList<JSONObject> result) {
		this.result = result;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() {
		result=ResultUtil.getSlefSRList("50000", "系统异常", null);
		return SUCCESS;
	}
	/*public String exceptionAction() {
		result=ResultUtil.getSlefSRList("50000", "系统异常", null);
		return SUCCESS;
	}*/
}
