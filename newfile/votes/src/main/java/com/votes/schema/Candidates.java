package com.votes.schema;

public class Candidates {
	private int id;
	private String name;
	private double countmoney;
	
	public double getCountmoney() {
		return countmoney;
	}
	public void setCountmoney(double countmoney) {
		this.countmoney = countmoney;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	private String info;
}
