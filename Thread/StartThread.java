package com.lxy;
/**
 * �����̷߳�ʽһ��
 * 1.�������̳�Thread ��дrun
 * 2.����������start
 * @author lxz35
 *
 */
public class StartThread extends Thread{
	/**
	 * �߳���ڵ�
	 */
	@Override
		public void run() {
			// TODO Auto-generated method stub
		for (int i = 0; i <20; i++) {
			System.out.println("11");
			
		}
			super.run();
		}
	public static void main(String[] args) {
		//����
		StartThread startThread = new StartThread();//�����������
		//startThread.start(); //����֤��������cPU
		startThread.run();//��ͨ��������
		for (int i = 0; i <20; i++) {
			System.out.println("22");
			
		}
		
		
	}

}
