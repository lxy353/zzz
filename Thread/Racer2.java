package com.lxy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Racer2 implements Callable<Integer>{
	private static String winnerString;
	public Integer call() throws Exception{
		// TODO Auto-generated method stub
		for(int steps =1; steps<=100; steps++) {
			//模拟休息
			if (Thread.currentThread().getName().equals("llx")) {
				Thread.sleep(10);
			}
			System.out.println(Thread.currentThread().getName() +":"+steps);
			//比赛是否结束
			boolean flag = gameOver(steps);
			if (flag) {
				return steps;
			}
			
		}
		return null;
	}
	private boolean gameOver(int steps) {
		if (winnerString!= null) {
			return true;
		}
		else {
			if (steps== 100) {
				winnerString = Thread.currentThread().getName();
				System.out.println("winner:"+winnerString);
				
				
				return true;
				
			}
		}
		return false;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Racer2 racer = new Racer2();
		//创建执行服务
				ExecutorService service = Executors.newFixedThreadPool(2);
				//提交执行
				Future<Integer> resultFuture1=service.submit(racer);
				Future<Integer> resultFuture2=service.submit(racer);
				
				//获取结果
				Integer r1 = resultFuture1.get();
				Integer r2 = resultFuture2.get();
				
				//关闭服务
				service.shutdown();
	}

}
