package com.soul.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.stereotype.Service;

import com.soul.domain.City;

//@Mapper
public interface CityMapper {
	public List<City> findAllCity();
	public City findById(@Param("id") Long id);
	public long saveCity(City city);
	public long updateCity(City city);
	public long deleteCity(Long id);
}
