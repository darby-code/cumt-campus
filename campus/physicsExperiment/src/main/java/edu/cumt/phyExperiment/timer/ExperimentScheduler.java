package edu.cumt.phyExperiment.timer;

import edu.cumt.phyExperiment.entity.Experiment;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class ExperimentScheduler {

//    public ExperimentScheduler() throws SchedulerException {
//        // 1. 创建调度器Scheduler
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = schedulerFactory.getScheduler();
//        // 2. 创建JobDetail实例，并与Job任务绑定
//        JobDetail jobDetail = JobBuilder.newJob(ScheduleCheckAllowStateJob.class)
//                .withIdentity("experiment", "experimentAllow").build();
//        // 3. 构建触发器Trigger
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("experimentTrigger", "experimentAllowTrigger")
//                .startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInSeconds(10)  //每隔10S执行一次
//                        .repeatForever()).build();  //系统运行时就一直执行
//
//        // 4. 执行任务
//        scheduler.scheduleJob(jobDetail, trigger);
//        scheduler.start();
//
//    }
}
