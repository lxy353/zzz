package com.lxy;
/*
 * Thread safe and keep right and faster
 * Synchronized
 * method
 */
import com.lxy.UnSafeTest01.Web12306;

public class SynTest01 {

	public static class SafeWeb12306 implements Runnable {
		//票数
		private  int ticket=10;
		private boolean flag = true;
		public void run() {
			// TODO Auto-generated method stub
			while (flag) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test();
			}
		}
		//thread safe and synchronized
		public synchronized void test() {
			if (ticket<0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"::"+ticket--);
		}
	public static void main(String[] args) {
			//一份资源
			SafeWeb12306 web12306= new SafeWeb12306();
			System.out.println(Thread.currentThread().getName());
			//多个代理
			new Thread(web12306,"lxy").start();
			new Thread(web12306,"llx").start();
			new Thread(web12306,"lll").start();
		}


	}


}
