package com.soul.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Criteria;

import com.mongodb.WriteResult;
import com.soul.dao.UserDao;
import com.soul.entity.UserEntity;

@Component
public class UserDaoImpl implements UserDao{
	@Autowired
	private MongoTemplate  mongoTemplate;
	
	@Override
	public void saveUser(UserEntity user){
		mongoTemplate.save(user);
	}
	
	@Override
	public UserEntity findUserByUserName(String name){
		Query query = new Query(Criteria.where("name").is(name));
		UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
		return user;
	}
	
	@Override
    public List<UserEntity> find(){
		Sort sort = new Sort(new Order(Direction.DESC, "date")); 
        Query query = new Query();
		query.with(sort).limit(100);
        return mongoTemplate.find(query, UserEntity.class);
    }
//	@Override
//	public int updateUser(UserEntity user){
//		Query query = new Query(Criteria.where("id").is(user.getId()));
//		Update update = new Update().set("name", user.getName()).set("speak", user.getSpeak());
//		WriteResult result = mongoTemplate.updateFirst(query, update, UserEntity.class);
//		//更新查询返回结果第一条
//		//mongoTemplate.updateMulti(query,update,UserEntity.class);更新查询返回结果集的所有
//		if (result!=null) {
//			return result.getN();
//		}else {
//			return 0;
//		}
//	}
//	
//	@Override
//	public void deleteUserById(Long id){
//		Query query = new Query(Criteria.where("id").is(id));
//		mongoTemplate.remove(query,UserEntity.class);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
