package com.votes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
    public Respbody not(int productId){
		Map r = new HashMap<Object, Object>();
    	r.put("candidateList", candidateServer.findCandidates(productId));
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
	
	@RequestMapping("/dovotes")
    public Respbody dovotes(double money,String code,String name,int candidatesId,int productId){
		long n = candidateServer.AddVotes(money,code,name,candidatesId,productId);
		Map r = new HashMap<Object, Object>();
		if(n==1){
			r.put("mes", "success");			
		}
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
	
//    @RequestMapping("/codecheck")
//    public Respbody codecheck(String code,String name,int productId) throws IOException {
//    	String url = "http://rap2api.taobao.org/app/mock/16509/example/157291743976334?code="+code+"&name="+name+"&productId="+productId;
//        HttpMethod method =HttpMethod.GET;
//        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
//        String result = Http.HttpRestClient(url,method,params);
//        JSONObject obj = new JSONObject();
//        Map params1 = JSONObject.parseObject(result);
//        String code1 = (String) params1.get("code").toString(); //获得这个身份证是否有权
//        String money = (String) params1.get("number").toString();
//        Map r = new HashMap<Object, Object>();
//        Respbody respbody;
//        if(code1.equals("1")){
//        	System.out.print("code1=1");
//        	HashMap n = candidateServer.findCandidatesByCode(code,productId);
//        	//如果count=1说明已经投票了 =0说明没投票
//        	r.put("dovote", n);
//        	r.put("number", money);
//        	respbody = new Respbody<Map>(1,r);
//        }else{
//        	r.put("msg","错误");
//        	respbody = new Respbody<Map>(0,r);
//        }
//    	return respbody;
//    }
	
    
    
    @RequestMapping("/productlist")
    public Respbody productlist(){
		Map r = new HashMap<Object, Object>();
    	r.put("productList", candidateServer.findProductAll());
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }

    @RequestMapping("/votedetaillist")
    public Respbody votedetaillist(int productId,int candidateId){
		Map r = new HashMap<Object, Object>();
    	List productList = candidateServer.findVoteDetail(productId,candidateId);
    	if(productList!=null){
    		r.put("votedetailList", productList);	
    	}else{
    		r.put("votedetailList",new ArrayList<String>());
    	}
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
    
    @RequestMapping("/voteUser")
	public HashMap<String, Object> voteUser(String code,int productId) throws Exception {
//		String code = paramString("code");// 身份证号
		HashMap<String, Object> data = new HashMap<String, Object>();
		// 初始化默认值
		data.put("permission", 0);// 是否有权限
		data.put("money", 0);// 金额
		if (!StringUtils.isBlank(code)) {
			HashMap n = candidateServer.findObjByProperty(productId,code);
			if(n!=null){
				data.put("permission", 1);// 是否有权限
				data.put("money", n.get("bid"));// 金额
			}
		}
		return data;
	}
    
    @RequestMapping("/codecheck")
    public Respbody codecheck(String code,String name,int productId) throws Exception {
    	HashMap voteuser = voteUser(code, productId);//获得这个身份证是否有权
    	int code1 = (int) voteuser.get("permission");
    	Object money = voteuser.get("money");
        Map r = new HashMap<Object, Object>();
        Respbody respbody;
        if(code1==1){
        	HashMap n = candidateServer.findCandidatesByCode(code,productId);
        	//如果count=1说明已经投票了 =0说明没投票
        	r.put("dovote", n);
        	r.put("number", money);
        	respbody = new Respbody<Map>(1,r);
        }else{
        	r.put("msg","无权限");
        	respbody = new Respbody<Map>(0,r);
        }
    	return respbody;
    }

    
}
