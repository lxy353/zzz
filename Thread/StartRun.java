package com.lxy;
/**
 * 创建线程方式二：
 * 1.创建：实现runnable 重写run
 * 2.启动：创建实现类对象+thread 对象 +start
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 * @author lxz35
 *
 */
public class StartRun implements Runnable{
	/**
	 * 线程入口点
	 */
	public void run() {
			// TODO Auto-generated method stub
		for (int i = 0; i <20; i++) {
			System.out.println("11");
			
		}
		
		}
	public static void main(String[] args) {
		/*//创建实现类对象
		StartRun startThread = new StartRun();
		//创建代理类对象
		Thread thread = new Thread(startThread);
		//启动
		//startThread.start(); //不保证立即调用cPU
		thread.run();//普通方法调用
		*/
		new Thread(new StartRun()).start();//代码是使用一次可以不用声明
		
		for (int i = 0; i <20; i++) {
			System.out.println("22");
			
		}
		
		
	}

}
