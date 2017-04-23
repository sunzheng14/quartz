package quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class StartJob {

	public static void main(String[] args) {
		//创建任务
		JobDetail jobDetail = JobBuilder.newJob(ExecutorJob.class).withIdentity("job1", "group1").build();
		//触发时间点
		SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever();
		
		Trigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
				.startNow().withSchedule(simpleScheduleBuilder).build();
		
		Scheduler scheduler;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			scheduler.scheduleJob(jobDetail, simpleTrigger);
			
			scheduler.start();
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
