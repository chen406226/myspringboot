package com.soul.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soul.domain.City;
import com.soul.domain.ManagerInfo;
import com.soul.server.ManagerInfoService;
import com.soul.util.JWTUtil;

@RestController
public class LoginController {

//	@Resource
	@Autowired
	private ManagerInfoService managerInfoService;

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired(required = false)
	public void setRedisTemplate(RedisTemplate redisTemplate) {
	    RedisSerializer stringSerializer = new StringRedisSerializer();
	    redisTemplate.setKeySerializer(stringSerializer);
//	    redisTemplate.setValueSerializer(stringSerializer);
	    redisTemplate.setHashKeySerializer(stringSerializer);
//	    redisTemplate.setHashValueSerializer(stringSerializer);
	    this.redisTemplate = redisTemplate;
	}
	private static final Logger _logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")
//	@ResponseBody
	public BaseResponse login(String username,String password) {
//		public BaseResponse login(@RequestParam("username") String username,@RequestParam("password") String password) {
		ManagerInfo user = managerInfoService.findByUsername(username);
		//盐(用户名+随机数)
		String salt = user.getSalt();
		System.out.println(user.toString());
		//原密码 应该用md5或hash混淆算法
		String encodePassword = salt+password;
//		if (user.getPassword().equals(encodePassword)) {
		if(password.equals(user.getPassword())) {
			System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttt");
//			String token = JWTUtil.sign(username, encodePassword);
			String token = UUID.randomUUID().toString();
			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			operations.set(token, username,1000,TimeUnit.SECONDS);
			return new BaseResponse(true,"login success",token);
		}else {
			
			System.out.println("ttdfffffffffffffffffffffffffffffffffffffffffffffffffffff");
			throw new UnauthorizedException();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
