package com.kfit.config;

import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.kfit.task.ScheduledTasks;

@Configuration
public class scheduledConfiguration {
	/*1定义jobDetail*/
	
	@Bean
	public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTasks scheduledTasks){
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		//设置对应的job对象
		bean.setTargetObject(scheduledTasks);
		//设置scheduledtasks对应的方法名
		bean.setTargetMethod("excute");
		return bean;
	}
	//2定义trigger
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail){
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression("0/5 * * ? * *");//每5s执行1次
		return trigger;
	}
	
	/*3定义scheduler*/
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
		return schedulerFactoryBean;
	}
}











