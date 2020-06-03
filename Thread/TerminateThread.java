package com.lxy;
/**
 * 终止线程
 * 1.线程正常执行完成---次数
 * 2.外部干涉--加入标识
 * 不要使用stop destroy
 * @author lxz35
 *
 */

public class TerminateThread  implements Runnable {
	//1.加入标识 标记线程提是否可以运行
	private boolean flag = true;
	private String name;
	
	public TerminateThread(String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
		public void run() {
		int i=0;
			// TODO Auto-generated method stub
		//2. 关联标识 ， true 运行
		while (flag) {
			System.out.println( name+":"+i++);
		}
			
		}
	// 对外提供方法
	public void terminate() {
		this.flag=false;
		
	}
	public static void main(String[] args) {
		TerminateThread ttTerminateThread = new TerminateThread("lxy");
		new Thread(ttTerminateThread).start();
		for (int i = 0; i < 99; i++) {
			if (i==22) {
				ttTerminateThread.terminate();//线程终止
				System.out.println("gg");
				
			}
			System.out.println("main"+i);
			
		}
		
	}

}
