package com.soul.controller;

import java.util.List;

import com.soul.entity.UserEntity;

public class Respos {
	private List<UserEntity> list;
	private String status;
	public List<UserEntity> getList() {
		return list;
	}

	public void setList(List<UserEntity> list) {
		this.list = list;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
