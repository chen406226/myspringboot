package com.soul.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.soul.entity.UserEntity;

public interface UserDao<T> {
	public void saveUser(UserEntity user);
	public UserEntity findUserByUserName(String user);
	public List<UserEntity> find();
//	public UserEntity find();
//	public int updateUser(UserEntity user);
//	public void deleteUserById(Long id);
//	List<UserEntity> find(Query query);
}
