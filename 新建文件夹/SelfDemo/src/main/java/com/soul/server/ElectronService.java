package com.soul.server;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soul.domain.City;


public interface ElectronService {
	public List<City> findAllNote();
}
