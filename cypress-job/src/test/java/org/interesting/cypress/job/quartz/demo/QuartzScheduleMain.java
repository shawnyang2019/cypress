package org.interesting.cypress.job.quartz.demo;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1. 暂停耽搁的job会在恢复后一次性执行
 * 
 * @author vv
 * @since 2017/8/13.
 */
public class QuartzScheduleMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzScheduleMain.class);

    /**
     *
     * 演示调度API的基本使用
     * 
     * @throws Exception
     */
    public void run() throws Exception {

        Scheduler scheduler = QuartzScheduleMgr.getInstanceScheduler();

        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // 下一个整数分钟 08:13:54 --> 08:14:00
        Date runTime = DateBuilder.evenMinuteDate(new Date());
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();

        scheduler.scheduleJob(job, trigger2);
        LOGGER.info("---------- " + job.getKey() + " will run at: " + runTime);
        // 启动调度任务
        scheduler.start();

        // executing...
        Thread.sleep(30 * 1000L);

        // 暂停耽搁的job会在恢复后一次性执行
        LOGGER.info("------- pauseJob 25 s -------------");
        scheduler.pauseJob(job.getKey());
        scheduler.pauseTrigger(trigger2.getKey());
        Thread.sleep(25 * 1000L);

        // 暂停耽搁的job会在恢复后一次性执行
        LOGGER.info("------- resumeJob... -------------");
        scheduler.resumeJob(job.getKey());

        // wait long enough so that the scheduler as an opportunity to
        // run the job!
        LOGGER.info("------- Waiting 20 seconds... -------------");
        // executing...
        Thread.sleep(20 * 1000L);

        // shut down the scheduler
        LOGGER.info("------- Shutting Down ---------------------");
        scheduler.shutdown(true);
        LOGGER.info("------- Shutdown Complete -----------------");
    }

    public static void main(String[] args) throws Exception {

        QuartzScheduleMain example = new QuartzScheduleMain();
        example.run();

    }
}
