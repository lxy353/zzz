package com.lxy;
/**
 * �����̷߳�ʽ����
 * 1.������ʵ��runnable ��дrun
 * 2.����������ʵ�������+thread ���� +start
 * �Ƽ������ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 * @author lxz35
 *
 */
public class StartRun implements Runnable{
	/**
	 * �߳���ڵ�
	 */
	public void run() {
			// TODO Auto-generated method stub
		for (int i = 0; i <20; i++) {
			System.out.println("11");
			
		}
		
		}
	public static void main(String[] args) {
		/*//����ʵ�������
		StartRun startThread = new StartRun();
		//�������������
		Thread thread = new Thread(startThread);
		//����
		//startThread.start(); //����֤��������cPU
		thread.run();//��ͨ��������
		*/
		new Thread(new StartRun()).start();//������ʹ��һ�ο��Բ�������
		
		for (int i = 0; i <20; i++) {
			System.out.println("22");
			
		}
		
		
	}

}
