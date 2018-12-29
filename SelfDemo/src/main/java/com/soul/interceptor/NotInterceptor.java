package com.soul.interceptor;

import java.util.ArrayList;
import java.util.List;

/*
 * 不需要拦截url
 * @author
 * @date
 * */
public class NotInterceptor {
	public final static List<String> NOT_INTERCEPT_URL_LIST = new ArrayList<>();
	
	static {
		addNotInterceptor("/api/city");
		addNotInterceptor("/login");
		addNotInterceptor("/api/NoteList");
		addNotInterceptor("/api/NoteWrite");
		addNotInterceptor("/api/NoteWrites");
	}
	/*
	 * 添加不用拦截的url
	 * @param url
	 * */

	private static void addNotInterceptor(String url) {
		// TODO Auto-generated method stub
		NOT_INTERCEPT_URL_LIST.add(url);
	}
	
}
