package com.lxy;
/**
 * yield �����̣߳���ͣ�߳� ֱ�ӽ������
 * @author lxz35
 *
 */

public class YieldDemo1 {
	public static void main(String[] args) {
		MyYield myYield = new MyYield();
		new Thread(myYield,"a").start();
		new Thread(myYield,"a").start();
		
	}

}
class MyYield implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println(Thread.currentThread().getName()+"start");
	Thread.yield();
	System.out.println(Thread.currentThread().getName()+"end");
	}
}
