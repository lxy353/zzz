package com.lxy;
/**
 * yield 礼让线程，暂停线程 直接进入就绪
 * @author lxz35
 *
 */

public class YieldDemo2 {
	public static void main(String[] args) {
		new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lxy"+i);
				
			}
		}).start();
		for (int i = 0; i < 100; i++) {
			if (i%20==0) {
				Thread.yield();//礼让
			}
			System.out.println("main"+i);
			
		}
		
		
	}

}

