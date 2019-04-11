package com.soul.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@RequestMapping("/book/booklist")
	@CrossOrigin
	public String book(){
		String db = "";
		try {
			db = new String(Files.readAllBytes(Paths.get("D:/book/booklist.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db; 
	}
	
	@RequestMapping("/book/bookname")
	@CrossOrigin
	public String bookname(String name,String cap){
		String db = "";
		try {
			db = new String(Files.readAllBytes(Paths.get("D:/book/"+name+"/"+cap+".json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}
}
