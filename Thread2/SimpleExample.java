
 


import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * quartz 学习
 * @author lxz35
 *
 */
public class SimpleExample {

  public void run() throws Exception {

    // First we must get a reference to a scheduler。 1.创建scheduler 的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    
    //2.从工厂获取调度器
    Scheduler sched = sf.getScheduler();

    // define the job and tie it to our HelloJob class。3.任务 传教jobdetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    
    // computer a time that is on the next round minute 时间
    Date runTime = evenMinuteDate(new Date());


    // Trigger the job to run on the next round minute。4. 触发器
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // Tell quartz to schedule the job using our trigger5，注册任务和触发条件
    sched.scheduleJob(job, trigger);


    // Start up the scheduler (nothing can actually run until the 启动
    // scheduler has been started)
    sched.start();

    try {
      // wait 5 seconds to show job
      Thread.sleep(5L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }
    // shut down the scheduler

    sched.shutdown(true);

  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}
