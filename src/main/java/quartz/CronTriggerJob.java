package quartz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerJob {
	public static void main(String[] args) {
		JobDetail jobDetail = JobBuilder.newJob(ExecutorJob.class)
				.withIdentity("job2", "group1")
				.build();
		
		Trigger cronTrigger = TriggerBuilder.newTrigger().
				withIdentity("trigger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
				.build();
		
		try {
			Properties p= new Properties();
			FileInputStream fin = new FileInputStream("/Users/sunzheng/code/quartz/src/main/resources/quartz.properties");
			
			p.load(fin);
			
			StdSchedulerFactory schedulerFactory = new StdSchedulerFactory(p);
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
