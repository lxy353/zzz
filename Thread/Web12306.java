package com.lxy;
/**
 * ������Դ,�������̰߳�ȫ��
 * @author lxz35
 *
 */
public class Web12306 implements Runnable {
	//Ʊ��
	private  int ticket=99;
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (ticket<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"::"+ticket--);
		}
	}
	public static void main(String[] args) {
		//һ����Դ
		Web12306 web12306= new Web12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web12306,"lxy").start();
		new Thread(web12306,"llx").start();
		new Thread(web12306,"lll").start();
	}


}
