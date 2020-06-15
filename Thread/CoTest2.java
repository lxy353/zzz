package com.LXY;

/**
 * model��consumer and productor
 * Э��ģ�ͣ�������������ʵ�ַ�ʽ�����źŵ�
 * ������־λ
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
//��������Ա
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
//������ ����
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

//ͬһ����Դ ����
class TV{
	String voice;
	// �źŵ�
	//T ��ʾ��Ա���� ���ڵȴ�
	//F ��ʾ���ڹۿ�
	boolean flag =true;
	
	//����
	public synchronized void play(String voice) {
		//��Ա�ȴ�
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
		//����
		this.notifyAll();
		//�л���ע
		this.flag=!this.flag;
		
	}
	//�ۿ�
	public synchronized void watch() {
		//���ڵȴ�
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//�ۿ�
		this.notifyAll();
		//�л���ע
		this.flag=!this.flag;
		System.out.println("tingdao le :"+voice);
		
	}
	
}

