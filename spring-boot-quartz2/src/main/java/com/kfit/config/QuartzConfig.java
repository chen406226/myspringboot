package com.kfit.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/*1.SchedulerFactoryBean
 * 2.scheduler类
 * */

@Configuration
public class QuartzConfig {
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(){
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		return schedulerFactoryBean;
	}

	@Bean
	public Scheduler scheduler(){
		return schedulerFactoryBean().getScheduler();
	}

	
	
	
	
	
	
	
	
}









