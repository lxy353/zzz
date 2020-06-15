package com.LXY;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度类
 * @author lxz35
 *
 */

public class MyTimerTest01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//执行任务一次
		//timer.schedule(new MyTask(), 1000);
		timer.schedule(new MyTask(), 1000,200);
		
	}

}
//任务类
class MyTask extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("11");
		}
		System.out.println("end");
	}
}