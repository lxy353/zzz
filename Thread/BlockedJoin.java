package com.lxy;
/**
 * join:�ϲ��̣߳����
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
				thread.join();//��� mian ��������
			}
			System.out.println("main"+i);
			
		}
		
		
	
		
	}

}
