package com.soul.dao;

import com.soul.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by summer on 2017/5/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

//    @Test
//    public void testSaveUser() throws Exception {
//        UserEntity user=new UserEntity();
//        user.setId(2l);
//        user.setName("小明");
//        user.setSpeak("讲得真好");
//        user.setUrl("www.geogle.com");
//        userDao.saveUser(user);
//        System.out.println(user);
//        System.out.println(user.toString());
//    }

//    @Test
//    public void find(){
//    	UserEntity user= userDao.find();
//    	System.out.println("user is "+user);
//    }
    
//    @Test
//    public void findUserByUserName(){
//       UserEntity user= userDao.findUserByUserName("小明");
//       System.out.println("user is "+user);
//    }
//
//    @Test
//    public void updateUser(){
//        UserEntity user=new UserEntity();
//        user.setId(2l);
//        user.setUserName("天空");
//        user.setPassWord("fffxxxx");
//        userDao.updateUser(user);
//    }
//
//    @Test
//    public void deleteUserById(){
//        userDao.deleteUserById(1l);
//    }

}
