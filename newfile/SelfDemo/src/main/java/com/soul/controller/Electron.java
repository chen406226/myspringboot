package com.soul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soul.server.ElectronService;

@RestController
public class Electron {
	@Autowired
	private ElectronService electronService;
	
	
	@RequestMapping("/api/login")
	public String log(){
		return "sdf";
	}
    //此借口可以测试过滤器
    @RequestMapping("/api/NoteLists")
    public List findAllNote() {
        return electronService.findAllNote();
    }
}
