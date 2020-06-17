
 


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
 * quartz ѧϰ
 * @author lxz35
 *
 */
public class SimpleExample {

  public void run() throws Exception {

    // First we must get a reference to a scheduler�� 1.����scheduler �Ĺ���
    SchedulerFactory sf = new StdSchedulerFactory();
    
    //2.�ӹ�����ȡ������
    Scheduler sched = sf.getScheduler();

    // define the job and tie it to our HelloJob class��3.���� ����jobdetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    
    // computer a time that is on the next round minute ʱ��
    Date runTime = evenMinuteDate(new Date());


    // Trigger the job to run on the next round minute��4. ������
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // Tell quartz to schedule the job using our trigger5��ע������ʹ�������
    sched.scheduleJob(job, trigger);


    // Start up the scheduler (nothing can actually run until the ����
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
