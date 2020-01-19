package com.soul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@RequestMapping("/api/login")
	public res log(){
		Map o = new HashMap<>();
		return new res(1,"登录成功",o);
	}
	
	@RequestMapping("/api/NoteList")
	public res list(){
		Map oMap = new HashMap<>();
		Map row = new HashMap<>();
		row.put("date", "2018-09");
		row.put("con", "沙路口的附近；拉萨的金服；卡拉加水电费；离开静安寺；来看积分考拉；时间段飞；按时交电费；离开静安寺的；李开复即可拉伸大姐夫看见爱上的快乐发加速快乐；点击发来看见爱上；兑付了；卡萨丁； 发来看见爱上；李开复加；塑料袋看风景阿里；贷款纠纷；拉卡世纪东方；拉接收到飞；离开静安寺；离开的房间考拉；圣诞节福利；卡机是对方考虑；加上地方了科技撒打开了；附件卡死；点击放开了；爱神的箭飞离开静安寺的发来看见爱上的开了房加快了；束带结发了；卡世纪东方；离开静安寺的；浪费空间as；了肯定交罚款；来得及发阿喀琉斯；的减肥看");
		List l = new ArrayList<>();
		l.add(row);
		l.add(row);
		l.add(row);
		l.add(row);
		l.add(row);
		l.add(row);
		l.add(row);
		l.add(row);
		oMap.put("list", l);
		return new res(1,"处理成功",oMap);
	}
	@RequestMapping("/api/NoteWrite")
	public res write(){
		Map oMap = new HashMap<>();
		return new res(1,"编辑成功",oMap);
	}
}
