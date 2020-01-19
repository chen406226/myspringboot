package com.soul.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soul.domain.City;
import com.soul.mapper.CityMapper;
import com.soul.server.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	
	
	@Autowired
	private CityMapper citymapper;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public List<City> findAllCity(){
		String key = "cityall";
		ValueOperations<String, List<City>> operations = redisTemplate.opsForValue();
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			LOGGER.info("所有城市缓存获得");
			return (List<City>) operations.get(key);
		}
		List<City> citys = citymapper.findAllCity();
//		operations.set("cityall", (List<City>) citys,1000,TimeUnit.SECONDS);
		return citys;
//		return citymapper.findAllCity();
	}
	public List findAllNote(){
		return citymapper.findAllNote();
	}
	public Long addNote(String name,String content,String date){
		return citymapper.addNote(name,content,date);
	}
	public City findCityById(Long id) {
		//从缓存中获得城市信息
		String key = "city_" + id;
		ValueOperations<String, City> operations = redisTemplate.opsForValue();
		//缓存存在
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			City city = operations.get(key);
			LOGGER.info("CityServiceImpl.findCityById():城市插入缓存>>"+city.toString());
			return city;
		}
		
		//从db中获得信息
		City city = citymapper.findById(id);
		//插入缓存
		operations.set(key, city,1000,TimeUnit.SECONDS);
		LOGGER.info("cityserviceImpl.findcitybyid():城市插入数据>>"+ city.toString());
		return city;
//		return citymapper.findById(id);
	}
	
	public Long saveCity(City city) {
		return citymapper.saveCity(city);
	}
	
	public Long updateCity(City city) {
		Long ret = citymapper.updateCity(city);
		//缓存存在删除缓存
		String key = "city_"+ city.getId();
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			redisTemplate.delete(key);
			LOGGER.info("cityserviceimpl.updatecity():从缓存中删除>>"+city.toString());
		}
		System.out.println("ret返回值"+ret);
		return ret;
//		return citymapper.updateCity(city);
	}
	
	public Long deleteCity(Long id) {
		Long ret = citymapper.deleteCity(id);
		//缓存存在,删除缓存
		String key = "city_"+id;
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			redisTemplate.delete(key);
			LOGGER.info("cityserviceImpl.deletecity():从缓存中删除城市>> ID== "+id);
		}
		
		return ret;
//		return citymapper.deleteCity(id);
	}
}
