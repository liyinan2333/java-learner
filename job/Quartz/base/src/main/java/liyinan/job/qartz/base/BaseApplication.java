package liyinan.job.qartz.base;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseApplication {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        // 1.创建调度器 Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 2.创建JobDetail实例，并与MyJob类绑定(Job执行内容)
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        // 3.构建Trigger实例,每隔30s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        // 4.执行，开启调度器
        scheduler.scheduleJob(job, trigger);
        System.out.println(Thread.currentThread().getName() + "---调度器开启---" + new Date());
        scheduler.start();

        //主线程睡眠1分钟，然后关闭调度器
        TimeUnit.SECONDS.sleep(20);
        scheduler.shutdown();
        System.out.println(Thread.currentThread().getName() + "---调度器关闭---" + new Date());

    }

}
