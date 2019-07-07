package com.ry.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: renyang
 * @Date: 2018/7/10 16:41
 * @Description:
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
      //创建一个JobDetail实例与Job绑定在一起，后面quartz会用反射的方式通过JobDetail调用Job
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob","group1").build();

        //创建Trigger实例，定义job立即执行，并且每个2秒重复执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger","group1").startNow().withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2)
                        .repeatForever()).build();

        //创建Scheduler实例
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataString = sf.format(date);
        System.out.println(dataString);
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
