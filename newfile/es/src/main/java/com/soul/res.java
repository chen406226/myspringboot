package com.soul;

public class res {
	private int code;
	private String msg;
	private Object object;
	
	public res() {
		// TODO Auto-generated constructor stub
	}
	
	public res(int c,String m,Object o) {
		this.code = c;
		this.msg = m;
		this.object = o;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
