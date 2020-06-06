package com.lxy;
/**
 * join:合并线程，插队
 * @author lxz35
 *
 */

public class BlockedJoin2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("爸爸和儿子去买烟");
		new Thread(new Father()).start();
	}

}
class Father extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("想抽烟，发现没了");
		System.out.println("让儿子去买");
		Thread thread = new Thread(new son());
		thread.start();
		try {
			thread.join();//father被阻塞
			System.out.println("老爸拿过烟");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("儿子不见了");
		}
		
		super.run();
	}
	
}

class son extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("出去了");
		System.out.println("路边有个游戏厅，玩了10s");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"s过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("要买烟了");
		System.out.println("手拿一包中华");
		super.run();
	}
	
}

