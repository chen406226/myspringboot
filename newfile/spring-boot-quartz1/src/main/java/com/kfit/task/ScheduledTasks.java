package com.kfit.task;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class ScheduledTasks {
	public void excute(){
		System.out.println("excute"+new Date());
	}
}
