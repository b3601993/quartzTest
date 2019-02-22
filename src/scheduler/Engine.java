package scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import job.HelloJob;
import job.MongodbTimestamp;
import listener.HelloJobListener;

public class Engine {

	public static void main(String[] args) throws SchedulerException {
		
		JobKey jobKey = new JobKey("yutao", "group1");
				
				
		//我要跑的job
		JobDetail job = JobBuilder.newJob(MongodbTimestamp.class).withIdentity(jobKey).build();
		
		//触发器：多久触发一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("yutaoTrigger", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		
		SchedulerFactory schedFact = new StdSchedulerFactory();
		
		
		Scheduler scheduler = schedFact.getScheduler();
//		scheduler.getListenerManager().addJobListener(new HelloJobListener(), KeyMatcher.keyEquals(jobKey));
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
}
