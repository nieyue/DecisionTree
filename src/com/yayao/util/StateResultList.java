package com.yayao.util;

/**
 * 返回状态List Bean
 * @author yy
 *
 */
public class StateResultList<Data> {
	private Integer code;
	private String msg;
	private Data data;
	public StateResultList() {
		super();
	}

	
	
	public StateResultList(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}



	public StateResultList(Integer code, String msg, Data data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}



	public Integer getCode() {
		return code;
	}



	public void setCode(Integer code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Data getData() {
		return data;
	}



	public void setData(Data data) {
		this.data = data;
	}

}
