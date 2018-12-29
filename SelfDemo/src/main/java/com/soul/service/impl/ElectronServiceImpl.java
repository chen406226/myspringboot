package com.soul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soul.domain.City;
import com.soul.mapper.ElectronMapper;
import com.soul.server.ElectronService;

@Service
@Transactional
@Component
public class ElectronServiceImpl implements ElectronService{
	
	@Autowired
	private ElectronMapper electronMapper;
	
	public List<City> findAllNote(){
		List<City> citys = electronMapper.findAllNote();
//		operations.set("cityall", (List<City>) citys,1000,TimeUnit.SECONDS);
		return citys;
//		return citymapper.findAllCity();
	}
}
