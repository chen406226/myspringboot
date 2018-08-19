package com.kfit.demo.mapper;

import java.util.List;

import com.kfit.demo.bean.Demo;

public interface DemoMapper {
	public int save(Demo demo);
	
	public int update(Demo demo);
	
	public int delete(int id);
	
	public List<Demo> selectAll();
	
	public Demo selectById(int id);
}
