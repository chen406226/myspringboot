package com.soul.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.soul.enums.EnumResponse;
import com.soul.responseType.BaseResponseVo;


@Component
public class LoginInterceptor implements HandlerInterceptor{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	//在请求处理之前进行调用(controller方法调用之前)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException
			{
		// TODO Auto-generated method stub		
		EnumResponse enumResponse = EnumResponse.SUCCESS;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String token = request.getParameter("token");
		String url = request.getRequestURI();
		
		try {
			//检验是否需要拦截
			for (String strurl : NotInterceptor.NOT_INTERCEPT_URL_LIST) {
				System.out.println();
				if (url.contains(strurl)) {
					return true;
				}
			}
			//token校验
			
			if (StringUtils.isNotBlank(token)) {
				boolean hasKey = redisTemplate.hasKey(token);
				if (hasKey) {
					return true;					
				}
			}
			System.out.println(token);
			
//			if (NotInterceptor.NOT_INTERCEPT_URL_LIST.contains(url)) return true;
			//未登录接口
			this.returnJson(response, ajaxJSONResponse(EnumResponse.NOT_LOGIN.getCode(), EnumResponse.NOT_LOGIN.getMsg()
					, null));
			return false;
		}catch (Exception e) {
			// TODO: handle exceptionn
			enumResponse.setMsg(e.toString());
		}
		BaseResponseVo resp = new BaseResponseVo();
		enumResponse.setRespParam(resp);
		response.getWriter().write(resp.toJson());
		return false;
	}
	
	//请求处理之后调用,但在视图被渲染之前(controller方法调用之后)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
        System.out.println("postHandle被调用\n");
	}
	//在整个请求结束之后被调用,dispatcherServiet渲染了对应的视图之后执行(主要用于资源清理工作)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
        System.out.println("afterCompletion被调用\n");
	}
	
	
	
	private String ajaxJSONResponse(String responseCode,String responseMessage,Object obj) {
		BaseResponseVo baseResponseVo = new BaseResponseVo(responseCode,responseMessage,obj);
		return JSON.toJSONString(baseResponseVo);
	}
	
	private void returnJson(HttpServletResponse response,String json) throws Exception{
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(json);
		} catch (IOException e) {
			// TODO: handle exception
			LOGGER.error("response error",e);
		}finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}





















