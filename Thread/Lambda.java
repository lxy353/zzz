package com.lxy;
/**
 * Lambda表达式 简化线程（用一次）的使用
 * @author lxz35
 *
 */
public class Lambda {
	//静态内部类
	static class Test implements Runnable{
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("听歌");
			}
		}
		
	}
	public static void main(String[] args) {
		//new Thread(new Test()).start();
		
		//局部内部类
		class Test2 implements Runnable{
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("听歌");
				}
			}
			
		}
		new Thread(new Test2()).start();
		
	}

}
