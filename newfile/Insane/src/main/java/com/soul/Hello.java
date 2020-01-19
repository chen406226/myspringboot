package com.soul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@CrossOrigin
	@RequestMapping("/hello")
	@ResponseBody
	public String index() throws IOException{
		String hel = new String(Files.readAllBytes(Paths.get("G:\\db.json")));
		
//		return hel;
		return "hello world";
	}
	public String json(String str){
		return str;
	}
	@RequestMapping("/test")
	public void dd(String ss){
		System.out.println(ss);
	}
}
