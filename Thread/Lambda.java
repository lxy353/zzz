package com.lxy;
/**
 * Lambda���ʽ ���̣߳���һ�Σ���ʹ��
 * @author lxz35
 *
 */
public class Lambda {
	//��̬�ڲ���
	static class Test implements Runnable{
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("����");
			}
		}
		
	}
	public static void main(String[] args) {
		//new Thread(new Test()).start();
		
		//�ֲ��ڲ���
		class Test2 implements Runnable{
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("����");
				}
			}
			
		}
		new Thread(new Test2()).start();
		
	}

}
