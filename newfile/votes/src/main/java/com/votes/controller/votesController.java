package com.votes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.votes.schema.Product;
import com.votes.server.CandidateServer;

@RestController

public class votesController {
	@Autowired
	private CandidateServer candidateServer;
	

	@CrossOrigin
	@RequestMapping("/candidatelist")
    public Respbody not(int productId){
		Map r = new HashMap<Object, Object>();
    	r.put("candidateList", candidateServer.findCandidates(productId));
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
	
	@CrossOrigin
	@RequestMapping("/dovotes")
    public Respbody dovotes(double money,String code,String name,int candidatesId,int productId){
		Map r = new HashMap<Object, Object>();
		List productlist = candidateServer.findProductAll();
		for(Product pro : (List<Product>)productlist){
			if(pro.getId()==productId&&pro.getTimeover()==1){
				r.put("mes", "不在时间范围内");
				return new Respbody<Map>(1,r);
			}
		}
		long n = candidateServer.AddVotes(money,code,name,candidatesId,productId);
		if(n==1){
			r.put("mes", "success");			
		}
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
    
	@CrossOrigin
    @RequestMapping("/productlist")
    public Respbody productlist(){
		Map r = new HashMap<Object, Object>();
    	r.put("productList", candidateServer.findProductAll());
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
    @CrossOrigin
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
    @CrossOrigin
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
    
    @CrossOrigin
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
    @RequestMapping("/codetest")
    public Respbody codetest() throws Exception {
    	Map r = new HashMap<Object, Object>();
    	PageHelper.startPage(1, 2);
    	List pp = candidateServer.findProductAll();
    	PageInfo<Object> pageInfo = new PageInfo<Object>(pp);
    	long total = pageInfo.getTotal();
    	r.put("productList", pp);
    	r.put("total", total);
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
    
    @CrossOrigin
    @RequestMapping("/twitter")
    public Respbody twitter(int pageNum,int pageSize) throws Exception {
    	Map r = new HashMap<Object, Object>();
    	PageHelper.startPage(pageNum, pageSize);
    	List pp = candidateServer.findTwitterAll();
    	PageInfo<Object> pageInfo = new PageInfo<Object>(pp);
    	long total = pageInfo.getTotal();
    	r.put("twitterList", pp);
    	r.put("total", total);
        Respbody respbody = new Respbody<Map>(1,r);
    	return respbody;
    }
}
