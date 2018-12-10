package com.soul.server;

import java.util.List;

import com.soul.domain.City;

public interface CityService {
	List<City> findAllCity();
	City findCityById(Long id);
	Long saveCity(City city);
	Long updateCity(City city);
	Long deleteCity(Long id);
}
