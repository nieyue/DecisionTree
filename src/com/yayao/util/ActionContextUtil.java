package com.yayao.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;


/**
 * ActionContext获取类
 * @author yy
 *
 */
public class ActionContextUtil {
	
	public static Map<String,Object>  getApplication(){
	    ActionContext actionContext = ActionContext.getContext();
		Map<String,Object>  application = actionContext.getApplication();
		return application;
	}
	public static Map<String,Object>  getSession(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> session = actionContext.getSession();
		return session;
	}
	public static HttpServletRequest getRequest(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}
	public static HttpServletResponse getResponse(){
		HttpServletResponse response =  ServletActionContext.getResponse();
		return response;
	}
	
}
