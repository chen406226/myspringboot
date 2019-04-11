package com.soul.responseType;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

import ognl.ObjectElementsAccessor;

/*信息返回*/

public class BaseResponseVo implements Serializable{

	private static final long serialVersionUID = -2371163055421043552L;
	
	private String responseCode;
	private String responseMessage;
	private Object obj;
	
	public BaseResponseVo() {
		// TODO Auto-generated constructor stub
	}
	public BaseResponseVo(String responseCode,String responseMessage,Object obj) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.obj = obj;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
	
	
}
