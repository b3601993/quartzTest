package job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobA implements Job{

	@Override
	public void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
		System.out.println("Job A is runing // every 5 seconds");
	}

}
