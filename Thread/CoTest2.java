package com.LXY;

/**
 * model：consumer and productor
 * 协作模型：生产者消费者实现方式二：信号灯
 * 借助标志位
 * @author lxz35
 *
 */

public class CoTest2 {
	public static void main(String[] args) {
		TV TV= new TV();
		new Player(TV).start();
		new Watcher(TV).start();
		
	}
}
//生产者演员
class Player extends Thread{
	TV tv;
	
	public Player(TV tv) {
		super();
		this.tv = tv;
	}
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i%2==0) {
				this.tv.play("lyx");
			}else {
				this.tv.play("lxy");
			}
			
		}
	}
}
//消费者 观众
class Watcher extends Thread{
	TV tv;
	public Watcher(TV tv) {
		this.tv = tv;
	}
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.watch();	
			}		
		}
	}

//同一个资源 电视
class TV{
	String voice;
	// 信号灯
	//T 表示演员表演 观众等待
	//F 表示观众观看
	boolean flag =true;
	
	//表演
	public synchronized void play(String voice) {
		//演员等待
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("biao yan le :"+voice);
		this.voice=voice;
		//唤醒
		this.notifyAll();
		//切换标注
		this.flag=!this.flag;
		
	}
	//观看
	public synchronized void watch() {
		//观众等待
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//观看
		this.notifyAll();
		//切换标注
		this.flag=!this.flag;
		System.out.println("tingdao le :"+voice);
		
	}
	
}

