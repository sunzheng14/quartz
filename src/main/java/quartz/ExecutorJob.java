package quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExecutorJob implements Job {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		String name = jec.getJobDetail().getKey().getName();
		Date startDate = new Date();
		
		System.out.println(name + " start," + "执行时间：" + format.format(startDate) );
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + "end" + "执行开始时间：" + format.format(startDate));
	}
}
