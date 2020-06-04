package com.lxy;
/**
 * sleep模拟网络延时，放大了发生问题的可能性
 * @author lxz35
 *
 */

 class BlockedSleep implements Runnable {
	
	public static void main(String[] args) {
		//一份资源
		Web12306 web12306= new Web12306();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web12306,"lxy").start();
		new Thread(web12306,"llx").start();
		new Thread(web12306,"lll").start();
	}
	//票数
		private  int ticket=99;
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (ticket<0) {
				break;
			}
			//模拟网络延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"::"+ticket--);
		}
	}
	


}
