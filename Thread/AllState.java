package com.lxy;

import java.lang.Thread.State;

public class AllState {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for (int i = 0; i < 10; i++) {}
			System.out.println(".....");
			
		});
		//¹Û²ì×´Ì¬
		State state = thread.getState();
		System.out.println(state);//new
		
		thread.start();
		state=thread.getState();
		System.out.println(state);//runnable
		
		/*while(state!=thread.getState().TERMINATED) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			state=thread.getState();//timed nated
			System.out.println(state);//
			
			
		}
		*/
		while(true) {
		int num = Thread.activeCount();
		System.out.println(num);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			state=thread.getState();//timed nated
			System.out.println(state);//
		}
		
		
	}
	

}
