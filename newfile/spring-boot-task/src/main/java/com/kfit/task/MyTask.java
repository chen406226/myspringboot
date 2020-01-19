package com.kfit.task;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyTask {
	//每10S打印一次
	/*cron定时任务表达式
	 * 指定s,分钟，小时，日期，,月，星期，年（可选）*任意
	 * 根据当前服务器是时间来的
	 * */
	@Scheduled(cron="0/10 * * * * *")
	//@Scheduled(cron="0/10 * * * * ?") -区间*统配？不想设置那个字段
	public void task1(){
		System.out.println("mytask.task1"+new Date());
	}
	//每分钟
	@Scheduled(cron="0 0/1 * * * *")
	private void task2() {
		System.out.println("mytask.task2");
	}
	
	
	/*CRON表达式含义
	 * 秒	0-59	,-* \/
	 * 分	0-59	,-* \/
	 * 小时	0-23	,-* \/
	 * 日期	1-31	,-*?LWC \/
	 * 月	1-12 | JAN-DEC	,-* \/
	 * 星期	1-7 | SUN-SAT   ,-*?LC# \/
	 * 年（可选）   留空| 1970-2099   ,- \/
	 * 
	 * "0 0 12 * * ?"每天中午12点
	 * "0 15 10 ? * *"每天早晨10点15
	 * "0 15 10 * * ?"每天10点15
	 * "0 15 10 * * ? *"每天10点15
	 * "0 15 10 * * ? 2005" 2005年的每天10点15
	 * "0 * 14 * * ?"每天下午2点 14点开始到14点59分每分钟一次
	 * "0 0/5 14 * * ?"每天下午2点 14点开始到14点55分每5分钟一次
	 * "0 0/5 14,18 * * ?"每天下午2点 14点开始到14点55分和18点到18点55分每5分钟一次
	 * "0 0-5 14 * * ?"每天中午14点到14：05每分钟
	 * "0 10,44 14 ? 3 WED ?" 3月每周3的14:10和a4:44茶法
	 * "0 15 10 ? * MON-FRI"每周一到周五的10:15出发
	 * 
	 * */
}
