package com.kfit.task;

import java.beans.Expression;
import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*再class上添加注释@EnableScheduling
 * 让我们的class实现接口SchedudingConfigurer
 * 实现SchedudingConfigurer中的方法
 * */

@RestController
@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer{
	//秒，分，小时、、、
	private String expression = "0/5 * * * * *";//每5S执行
	@RequestMapping("/changeExpression")
	public String changeExpression() {
		expression = "0/10 * * * * *";
		return "changeExpression";
	}
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("configureTasks.run"+new Date());
				// TODO Auto-generated method stub
				
			}
		};
		Trigger trigger = new Trigger() {
			
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				// TODO Auto-generated method stub
				CronTrigger cronTrigger = new CronTrigger(expression);
				return cronTrigger.nextExecutionTime(triggerContext);
			}
		};
		taskRegistrar.addTriggerTask(task, trigger);
	}
	
}









