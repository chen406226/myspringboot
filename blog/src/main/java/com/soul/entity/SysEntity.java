package com.soul.entity;

import java.io.Serializable;

public class SysEntity implements Serializable {
	private static final long serialVersionUID = -3258839839160856614L;
	private int count;
	private String msg;
	private int id;
	public SysEntity(int i, String msg) {
		this.id = i;
		this.count = i;
		this.msg = msg;
	}
	public SysEntity(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString(){
		return "SysEntity{"
				+ "id="+id
				+ ",count="+count
				+ ",msg="+msg
				+ "}";
	}
	
}
