package com.lxy;
/**
 * 共享资源,并发（线程安全）
 * @author lxz35
 *
 */
public class Web12306 implements Runnable {
	//票数
	private  int ticket=99;
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (ticket<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"::"+ticket--);
		}
	}
	public static void main(String[] args) {
		//一份资源
		Web12306 web12306= new Web12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web12306,"lxy").start();
		new Thread(web12306,"llx").start();
		new Thread(web12306,"lll").start();
	}


}
