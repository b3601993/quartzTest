package job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobB implements Job {

	@Override
	public void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
		System.out.println("Job B is runing");
	}

}
