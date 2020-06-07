package com.lxy;
/**
 * Thread¡®s Priority 1-10
 * 1.NORM-Priority 5 draft
 * 2.MINI-Priority 1
 * 3.MAX-Priority 10
 * 
 * it is priority
 * @author lxz35
 *
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		MyPriority mPriority = new MyPriority();
		
		Thread thread = new Thread(mPriority,"lxy");
		Thread thread1 = new Thread(mPriority,"llxy");
		Thread thread2 = new Thread(mPriority,"lllxy");
		Thread thread3 = new Thread(mPriority,"llllxy");
		
		//set up Priority
		thread1.setPriority(Thread.MAX_PRIORITY ); //cant no be out of range
		thread2.setPriority(Thread.MIN_PRIORITY );
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}

class MyPriority implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		Thread.yield();
		
	}
	
}
