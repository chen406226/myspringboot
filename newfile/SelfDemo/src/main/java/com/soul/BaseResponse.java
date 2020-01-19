package com.soul;

public class BaseResponse<T> {
	private boolean success;
	private String msg;
	private T data;
	public BaseResponse() {
		
	}
	public BaseResponse(boolean success,String msg,T data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}
}
