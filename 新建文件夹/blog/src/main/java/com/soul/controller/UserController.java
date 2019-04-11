package com.soul.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soul.entity.UserEntity;
import com.soul.server.UserServer;


@RestController
public class UserController {
	private static final int UserEntity = 0;
	private static final int List = 0;
	private static final int Map = 0;
	@Autowired
	private UserServer userServer;
	
	@CrossOrigin
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
	
	@CrossOrigin
	@RequestMapping("/find")
	public Respos find() throws Exception{
		List<UserEntity> users = userServer.find();
//		Map<UserEntity , List<UserEntity>> maps = new HashMap<UserEntity , List<UserEntity>>();
//		maps.put("list", users);
		System.out.println(users);
//		users.toString();
		Respos respos = new Respos();
		respos.setStatus("success");
		respos.setList(users);
		return respos;
	}
}
