package com.lxy;
/**
 * Thread unsafe: it has negative number and same num
 * @author lxz35
 *
 */
public class UnSafeTest01 {
	public static class Web12306 implements Runnable {
		//Ʊ��
		private  int ticket=10;
		private boolean flag = true;
		public void run() {
			// TODO Auto-generated method stub
			while (flag) {
				test();
			}
		}
		public void test() {
			if (ticket<0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"::"+ticket--);
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
}
