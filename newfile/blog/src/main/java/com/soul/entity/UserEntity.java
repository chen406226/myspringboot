package com.soul.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -3258839839160856613L;
//	private Long id;
	private String name;
	private String speak;
	private String url;
	private Long date;
public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeak() {
		return speak;
	}
	public void setSpeak(String speak) {
		this.speak = speak;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
//		"id=" + id +
		return "UserEntity{" +
                ", name='" + name + '\'' +
                ", speak='" + speak + '\'' +
                ", url='" + url + '\'' +
                ", date='" + date + '\'' +
                '}';
	}
}
