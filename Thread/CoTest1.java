package com.LXY;

/**
 * model��consumer and productor
 * Э��ģ�ͣ�������������ʵ�ַ�ʽһ���̷ܳ�
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

//������ productor
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		this.container = container;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("����-->"+i+"��mantou");
			container.push(new Steamedbun(i));	
		}
		
	}	
}

//������ consumer
class Consumer extends Thread{
	SynContainer container;	
	public Consumer(SynContainer container) {
		this.container = container;
	}
	@Override
	public synchronized void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("����-->"+container.pop().id+"��mantou");
					
		}
	}	
}

//������ buff
class SynContainer{
	Steamedbun[] buns = new Steamedbun[10];
	int count=0;
	//�洢 ���� save and produce
	public synchronized void push(Steamedbun bun) {
		//ʲôʱ������������������ڿռ�
		//��������
		if (count == buns.length) {
			try {
				this.wait();// �߳�������������֪ͨ���ѽӴ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		buns[count] = bun;
		count++;		
	}
	//get��ȡ
	public synchronized Steamedbun pop() {
		//��ʱ���� �����Ƿ��������
		//û������ֻ���Եȴ�
		if (count == 0) {
			try {
				this.wait();//�߳�������������֪ͨ����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//�������ݿ�������
		count --;
		Steamedbun bun = buns[count];
		this.notifyAll();//���ڿռ��ˣ����Ի��ѶԷ���
		return bun;		
	}	
}

//��ͷ steamedbun
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		super();
		this.id = id;
	}	
}