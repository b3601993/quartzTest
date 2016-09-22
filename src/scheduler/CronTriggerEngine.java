package scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import job.JobA;
import job.JobB;
import job.JobC;

public class CronTriggerEngine {

	public static void main(String[] args) throws SchedulerException {
		JobKey jobKeyA = new JobKey("jobA", "group1");
		JobDetail jobA = JobBuilder.newJob(JobA.class).withIdentity(jobKeyA).build();
		
		JobKey jobKeyB = new JobKey("jobA", "group2");
		JobDetail jobB = JobBuilder.newJob(JobB.class).withIdentity(jobKeyB).build();
		
		JobKey jobKeyC = new JobKey("jobC", "group1");
		JobDetail jobC = JobBuilder.newJob(JobC.class).withIdentity(jobKeyC).build();
		
		TriggerKey triggerA = new TriggerKey("triggerA", "group1");
		
		Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity(triggerA)
							.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
							.build();
		
		Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("triggerB", "group1")
							.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
							.build();
		
		Trigger trigger3 = TriggerBuilder.newTrigger().withIdentity("triggerC", "group1")
							.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
							.build();
		
		//创建调度程序
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobA, trigger1);
		scheduler.scheduleJob(jobB, trigger2);
		scheduler.scheduleJob(jobC, trigger3);
		
	}
}
