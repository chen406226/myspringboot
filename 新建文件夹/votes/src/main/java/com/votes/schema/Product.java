package com.votes.schema;

public class Product {
	private int id;
	private int status;
	private String name;
	private int timeover;
	public int getTimeover() {
		return timeover;
	}
	public void setTimeover(int timeover) {
		this.timeover = timeover;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
