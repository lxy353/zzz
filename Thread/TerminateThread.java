package com.lxy;
/**
 * ��ֹ�߳�
 * 1.�߳�����ִ�����---����
 * 2.�ⲿ����--�����ʶ
 * ��Ҫʹ��stop destroy
 * @author lxz35
 *
 */

public class TerminateThread  implements Runnable {
	//1.�����ʶ ����߳����Ƿ��������
	private boolean flag = true;
	private String name;
	
	public TerminateThread(String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
		public void run() {
		int i=0;
			// TODO Auto-generated method stub
		//2. ������ʶ �� true ����
		while (flag) {
			System.out.println( name+":"+i++);
		}
			
		}
	// �����ṩ����
	public void terminate() {
		this.flag=false;
		
	}
	public static void main(String[] args) {
		TerminateThread ttTerminateThread = new TerminateThread("lxy");
		new Thread(ttTerminateThread).start();
		for (int i = 0; i < 99; i++) {
			if (i==22) {
				ttTerminateThread.terminate();//�߳���ֹ
				System.out.println("gg");
				
			}
			System.out.println("main"+i);
			
		}
		
	}

}
