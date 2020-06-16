package com.LXY;

/**
 * model：consumer and productor
 * 协作模型：生产者消费者实现方式一：管程法
 * @author lxz35
 *
 */

public class CoTest1 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}

//生产者 productor
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("生产-->"+i+"：mantou");
			container.push(new Steamedbun(i));	
		}
		
	}	
}

//消费者 consumer
class Consumer extends Thread{
	SynContainer container;	
	public Consumer(SynContainer container) {
		this.container = container;
	}
	@Override
	public synchronized void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("消费-->"+container.pop().id+"：mantou");
					
		}
	}	
}

//缓存区 buff
class SynContainer{
	Steamedbun[] buns = new Steamedbun[10];
	int count=0;
	//存储 生产 save and produce
	public synchronized void push(Steamedbun bun) {
		//什么时候可以生产，容器存在空间
		//不能生产
		if (count == buns.length) {
			try {
				this.wait();// 线程阻塞，生产者通知消费接触
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		buns[count] = bun;
		count++;		
	}
	//get获取
	public synchronized Steamedbun pop() {
		//何时消费 容器是否存在数据
		//没有数据只可以等待
		if (count == 0) {
			try {
				this.wait();//线程阻塞。生产者通知消费
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//存在数据可以消费
		count --;
		Steamedbun bun = buns[count];
		this.notifyAll();//存在空间了，可以唤醒对方了
		return bun;		
	}	
}

//馒头 steamedbun
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		super();
		this.id = id;
	}	
}