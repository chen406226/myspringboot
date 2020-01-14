package com.votes.schema;

import java.io.Serializable;

public class Votes implements Serializable{
	private static final long serialVersionUID = -134L;
	private int id;
	private int candidatesId;
	private String code;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private double money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCandidatesId() {
		return candidatesId;
	}
	public void setCandidatesId(int candidatesId) {
		this.candidatesId = candidatesId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
