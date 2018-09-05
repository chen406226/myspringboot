package com.soul.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;
import com.soul.dao.SysDao;
import com.soul.entity.SysEntity;

@Component
public class SysDaoImpl implements SysDao{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveSys(SysEntity sys) {
		mongoTemplate.save(sys);		
	}

	@Override
	public SysEntity findById(int id) {
		Query query = new Query(Criteria.where("id").is(id));
		SysEntity sys = mongoTemplate.findOne(query, SysEntity.class);
		return sys;
	}

	@Override
	public int updateSys(SysEntity sys) {
		Query query = new Query(Criteria.where("id").is(sys.getId()));
		Update update;
//		if (sys.getMsg()!=null&&sys.getMsg()!=""&&sys.getCount()!=0&&sys.getCount()!=1) {
//			update = new Update().set("count", sys.getCount()).set("msg", sys.getMsg());
//		}else if (sys.getMsg()==null||sys.getMsg()=="") {
//			update = new Update().set("count", sys.getCount());
//		}else{
//			update = new Update().set("msg", sys.getMsg());			
//		}
		if (sys.getMsg()!=""&&sys.getMsg()!=null) {
			update = new Update().set("count", sys.getCount()).set("msg", sys.getMsg());
		}else{
			update = new Update().set("count", sys.getCount());
		}
		WriteResult result = mongoTemplate.updateFirst(query, update, SysEntity.class);
		return 1;
	}
	
}
















