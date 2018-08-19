package com.kfit;

import java.util.concurrent.TimeUnit;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.kfit.job.HelloJob;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws SchedulerException, InterruptedException{
        System.out.println( "Hello World!" );
        /*获取到Scheduler实例并且启动定时任务
         * 创建具体的Jobdetail
         * 创建触发时间点trigger
         * 将jobdetail和trigger交由scheduler安排触发
         * 睡眠20S关闭定时任务调度
         * */
        //1.
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start(); //启动
        
        System.out.println(scheduler.getSchedulerName());
        //2
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
        //3 触发时间点每5s执行一次也可以使用cron表达式
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(schedBuilder).build();
        //4 将jobDetail和trigger交由scheduler触发
        scheduler.scheduleJob(jobDetail,trigger);
        //5睡眠20S关闭定时任务调度器
        TimeUnit.SECONDS.sleep(20);
        scheduler.shutdown();
        System.out.println("scheduler.shutdown");
    }
    
}







/*1.首先需要一个任务类，hellojob,改类集成job类，然后添加execute(jobexecutioncontext context方法这个方法是具体任务执行的地方
 *2.在在哪定义？什么时候执行任务？需要Scheduler，此类创建方式使用Quartz提供的工厂类stdSchedulerFactory.getDefaultScheduler()进行创建
 *3.如何出发，scheduler.schedulejob(jobDetail,trigger)；进行出发定时任务在这里需要两个参数,jobDetail可以通过jobBuilder.newjob创建
 *在这里需要钉子一个job类，就是第一步创建的hellojob，trigger类的话,可以通过TriggerBuilder.newTrigger进行创建
 * 
 * 
 */

/*quartz.properties配置文件说明=
 */