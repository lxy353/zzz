package com.lxy;
/**
 * 创建线程方式一：
 * 1.创建：继承Thread 重写run
 * 2.启动：加上start
 * @author lxz35
 *
 */
public class StartThread extends Thread{
	/**
	 * 线程入口点
	 */
	@Override
		public void run() {
			// TODO Auto-generated method stub
		for (int i = 0; i <20; i++) {
			System.out.println("11");
			
		}
			super.run();
		}
	public static void main(String[] args) {
		//启动
		StartThread startThread = new StartThread();//创建子类对象
		//startThread.start(); //不保证立即调用cPU
		startThread.run();//普通方法调用
		for (int i = 0; i <20; i++) {
			System.out.println("22");
			
		}
		
		
	}

}
