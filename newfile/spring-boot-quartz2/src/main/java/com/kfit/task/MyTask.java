package com.kfit.task;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.job.HelloJob;

@Service
public class MyTask {
	
	@Autowired
	private Scheduler scheduler;
	@PostConstruct  //= init-method
	public void init(){
		//需要定义jobDetail - trigger - 
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
        //3 触发时间点每5s执行一次也可以使用cron表达式
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(schedBuilder).build();
        //4 将jobDetail和trigger交由scheduler触发
        
        try {
        	scheduler.scheduleJob(jobDetail,trigger);			
		} catch (SchedulerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
