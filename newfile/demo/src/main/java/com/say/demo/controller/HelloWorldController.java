package com.say.demo.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.say.demo.controller.HttpUtil;

@RestController
public class HelloWorldController {
	
	@Autowired
    RestTemplate restTemplate;
    @RequestMapping("/heldo")
    public String index() {
        return "Hello Spring Boot 1.w5!";
    }
    
    @RequestMapping("/bai")
    public String inddex() throws IOException {
    	System.out.println("sdfsd");
    	String url = "https://passport.baidu.com/v2/?regphonecheck&token=2fb6aa71e1c6faf298a8fa329ebb67bb&tpl=mn&apiver=v3&tt=1547541191546&phone=18914869992&moonshad=7ade06dodb539f4a920505cb102a5c04de&countrycode=&gid=32B9F46-64B4-4606-B82E-22F4C0E89763&exchange=0&isexchangeable=1&action=reg&traceid=&callback=bd__cbs__7z4bxe";
        //post请求
        HttpMethod method =HttpMethod.GET;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        //发送http请求并返回结果
        String result = HttpUtil.HttpRestClient(url,method,params);
        System.out.println(result);
    	return result;
    }
    @CrossOrigin
    @RequestMapping("/gethello/{id}/{hs}/{mt}")
    public String getHello(@PathVariable("id") String id,@PathVariable("hs") String hs,@PathVariable("mt") String mt) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://passport.baidu.com/v2/?regphonecheck&token=80c2df40a87228bbae106d8bb5dd3bb8&tpl=mn&apiver=v3&tt=1547561009043&phone="+id+"&moonshad="+hs+"&countrycode=&gid="+mt+"&exchange=0&isexchangeable=1&action=reg&traceid=&callback=bd__cbs__vop928", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
//        return result.toString();
        int first = body.indexOf("errInfo");
        String bb = body.substring(first, first+40);
//        return body;
        return id+bb;
    }
}