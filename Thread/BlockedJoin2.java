package com.lxy;
/**
 * join:�ϲ��̣߳����
 * @author lxz35
 *
 */

public class BlockedJoin2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("�ְֺͶ���ȥ����");
		new Thread(new Father()).start();
	}

}
class Father extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����̣�����û��");
		System.out.println("�ö���ȥ��");
		Thread thread = new Thread(new son());
		thread.start();
		try {
			thread.join();//father������
			System.out.println("�ϰ��ù���");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���Ӳ�����");
		}
		
		super.run();
	}
	
}

class son extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("��ȥ��");
		System.out.println("·���и���Ϸ��������10s");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"s��ȥ��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Ҫ������");
		System.out.println("����һ���л�");
		super.run();
	}
	
}

