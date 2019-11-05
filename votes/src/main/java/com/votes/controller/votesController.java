package com.votes.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.votes.server.CandidateServer;

@RestController
public class votesController {
	@Autowired
	private CandidateServer candidateServer;
	

	@RequestMapping("/candidatelist")
    public Respbody not(){
		Map r = new HashMap<Object, Object>();
    	r.put("candidateList", candidateServer.findCandidates());
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
	
	@RequestMapping("/dovotes")
    public Respbody dovotes(double money,String code,int candidatesId){
		long n = candidateServer.AddVotes(money,code,candidatesId);
		Map r = new HashMap<Object, Object>();
		if(n==1){
			r.put("mes", "success");			
		}
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
	
    @RequestMapping("/codecheck")
    public Respbody codecheck(String code,String name) throws IOException {
    	String url = "http://rap2api.taobao.org/app/mock/16509/example/157291743976334?code="+code+"&name="+name;
    	System.out.println(url);
        HttpMethod method =HttpMethod.GET;
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        String result = Http.HttpRestClient(url,method,params);
        JSONObject obj = new JSONObject();
        Map params1 = JSONObject.parseObject(result);
        String code1 = (String) params1.get("code").toString(); //获得这个身份证是否有权
        String money = (String) params1.get("number").toString();
        Map r = new HashMap<Object, Object>();
        Respbody respbody;
        if(code1.equals("1")){
        	System.out.print("code1=1");
        	HashMap n = candidateServer.findCandidatesByCode(code);
        	//如果count=1说明已经投票了 =0说明没投票
        	r.put("dovote", n);
        	r.put("number", money);
        	respbody = new Respbody<Map>(1,r);
        }else{
        	r.put("msg","错误");
        	respbody = new Respbody<Map>(0,r);
        }
    	return respbody;
    }
	

}
