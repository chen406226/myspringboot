package com.soul.enums;

import com.soul.responseType.BaseResponseVo;

/*
 * 业务处理状态
 * */
public enum EnumResponse {
	NOT_LOGIN("999999","未登录"),
	ERROR("111111","未知错误"),
	SUCCESS("000000","处理成功");
	
	private String code;
	private String msg;
	
	EnumResponse(String code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    public void setRespParam(BaseResponseVo respParam){
		respParam.setResponseCode(this.getCode());//代码
		respParam.setResponseMessage(this.getMsg());//信息
	}
}
