package listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class HelloJobListener implements JobListener{

	@Override
	public String getName() {
		return "测试hello";
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("猜猜看，什么时候跑");//当job被拒绝执行时，就执行这个
	}
	//执行之前执行
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("jobToBeExecuted");
		System.out.println("Job:" + jobName + " is going to start...");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

		System.out.println("jobWasExecuted");
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("Job : " + jobName + "is finished...");
		
		if(!jobException.getMessage().equals("")){
			System.out.println("Exception thrown by:" + jobName + " Exception:" + jobException.getMessage());
		}
	}

}
