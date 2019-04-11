package com.kfit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {
	@Autowired
	private DemoMapper demoMapper;
	public List<Demo> likeName(String name){
		return demoMapper.likeName(name);
	}
	
	public void save(Demo demo){
		demoMapper.save(demo);
	}
	
	@Transactional
	public int update(Demo demo){
		return demoMapper.update(demo);
	}
	
	@Transactional
	public int delete(int id){
		return demoMapper.delete(id);
	}
	
	public List<Demo> selectAll() {
		return demoMapper.selectAll();
	}
	public Demo selectById(int id){
		return demoMapper.selectById(id);
	}
	
	public List<Demo> select1(String name,String email) {
		return demoMapper.select1(name, email);
	}
	
}
