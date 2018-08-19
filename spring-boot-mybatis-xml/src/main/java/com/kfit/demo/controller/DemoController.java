package com.kfit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.demo.bean.Demo;
import com.kfit.demo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/save")
	public Demo save(Demo demo){
		int rs = demoService.save(demo);
		System.out.println("rs"+rs);
		return demo;
	}
	
	@RequestMapping("/update")
	public Demo update(Demo demo){
		int rs = demoService.update(demo);
		System.out.println("rs"+rs);
		return demo;
	}
	
	@RequestMapping("/delete")
	public int delete(int id){
		int rs = demoService.delete(id);
		System.out.println("rs"+rs);
		return rs;
	}
	
	@RequestMapping("/selectAll")
	public List<Demo> selectAll(){
		return demoService.selectAll();
	}
	
	@RequestMapping("/selectById")
	public Demo selectById(int id){
		Demo demo = demoService.selectById(id);
		//没有找到处理 实际需要抛出异常的
		if (demo == null) {
			demo = new Demo();
			demo.setId(0);
			demo.setName("no found");
		}
		return demo;
	}
}
