package com.yayao.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义异常拦截器
 * @author 聂跃
 * @date 2018年4月21日
 */
public class MyExceptionInterceptor  extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.err.println(invocation);
		return invocation.invoke();
	}

}
