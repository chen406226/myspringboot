package com.soul.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soul.entity.UserEntity;
import com.soul.server.UserServer;

@RestController
public class UserController {
	@Autowired
	private UserServer userServer;
	
	@RequestMapping("/save")
	public UserEntity save(String name,String speaking,String link) throws Exception{
        UserEntity user=new UserEntity();
//      user.setId(2l);
        user.setDate(new Date().getTime());
        user.setName(name);
        user.setSpeak(speaking);
        user.setUrl(link);
		
		UserEntity userEntity =userServer.testSaveUser(user);
		return userEntity;
	}
	
	@RequestMapping("/find")
	public List<UserEntity> find() throws Exception{
		List<UserEntity> users = userServer.find();
		System.out.println(users);
		return users;
	}
}
