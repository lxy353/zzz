package com.lxy;
/**
 * join:合并线程，插队
 * @author lxz35
 *
 */

public class BlockedJoin {
	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lxy"+i);
				
			}
		});
		thread.start();
		for (int i = 0; i < 100; i++) {
			if (i==20) {
				thread.join();//插队 mian 被堵塞了
			}
			System.out.println("main"+i);
			
		}
		
		
	
		
	}

}
