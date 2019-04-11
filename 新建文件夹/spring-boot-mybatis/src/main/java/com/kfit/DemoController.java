package com.kfit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/likename")
	public List<Demo> likeName(String name){
		//用page是才加这句 和config里面的类
		PageHelper.startPage(2, 2);  //分页
		return demoService.likeName(name);
	}
	@RequestMapping("/save")
	public Demo save(){
		Demo demo = new Demo();
		demo.setName("大拿");
		demoService.save(demo);
		return demo;
	}
	///update?id=23&name=lucy
	@GetMapping("/update")
	public int update(Demo demo){
		return demoService.update(demo);
	}
	@GetMapping("/delete")
	public int delete(int id){
		return demoService.delete(id);
	}
	
	@GetMapping("/selectAll")
	public List<Demo> selectAll(){
		return demoService.selectAll();
	}
	
	@GetMapping("/selectById")
	public Demo selectById(int id){
		return demoService.selectById(id);
	}
	
	@GetMapping("/select1")
	public List<Demo> select1(String name,String email){
		return demoService.select1(name, email);
	}
	
	
	
}
