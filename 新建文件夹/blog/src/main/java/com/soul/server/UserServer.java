package com.soul.server;

import com.soul.entity.UserEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.soul.dao.UserDao;

@Service
public class UserServer {
	@Autowired
    private UserDao userDao;
	
    public UserEntity testSaveUser(UserEntity user) throws Exception {
//        UserEntity user=new UserEntity();
//        user.setId(2l);
//        user.setName("小明");
//        user.setSpeak("讲得真好");
//        user.setUrl("www.geogle.com");
        userDao.saveUser(user);
        System.out.println(user);
        return user;
    }
    @SuppressWarnings("unchecked")
	public List<UserEntity> find(){
        return userDao.find();
    }
}
