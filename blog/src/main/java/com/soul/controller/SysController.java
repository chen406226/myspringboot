package com.soul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soul.entity.SysEntity;
import com.soul.server.SysServer;

@RestController
public class SysController {
	@Autowired
	private SysServer sysServer;
	
	@CrossOrigin
	@RequestMapping("/sys/info")
	public SysEntity sysinfo(){
		SysEntity sys = sysServer.findById(1);
		return sys;
	}
	
	@CrossOrigin
	@RequestMapping("/sys/update")
	public SysEntity sysupdate(String msg){
		System.out.println(msg);
		SysEntity sys = sysServer.findById(1);
		sys.setCount(sys.getCount()+1);
		//无参进来null
		if (msg!=""&&msg!=null) {
			sys.setMsg(msg);
		}
		sysServer.updateSys(sys);
		return sys;
	}
	
}
