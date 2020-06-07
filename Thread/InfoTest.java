package com.lxy;
/**
 * another ways
 * @author lxz35
 *
 */

public class InfoTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		//set up name : real name + stand for name
		MyInfo info = new MyInfo("lol");
		Thread thread = new Thread(info);
		thread.setName("lxy");
		thread.start();
		thread.sleep(1000);
		System.out.println(thread.isAlive());
		
	}

}
class MyInfo implements Runnable{
	private String name;
	
	public MyInfo(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->"+name);
		
	}
}
