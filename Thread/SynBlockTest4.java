

/**
 * Thread unSyn: GET MONEY
 * @author lxz35
 *
 */

public class SynBlockTest4{
	public static class SynTest01 {
		public static void main(String[] args) {
			//一份资源
			SynWeb12306 web12306= new SynWeb12306();
			System.out.println(Thread.currentThread().getName());
			//多个代理
			new Thread(web12306,"lxy").start();
			new Thread(web12306,"llx").start();
			new Thread(web12306,"lll").start();
		}

	}

		public static  class SynWeb12306 implements Runnable {
			//票数
			private  int ticket=10;
			private boolean flag = true;
			public void run() {
				// TODO Auto-generated method stub
				while (flag) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e){
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					test5();
				}
			}
			//thread Syn and synchronized
			public synchronized void test1() {
				if (ticket<0) {
					flag = false;
					return;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"::"+ticket--);
			}
			//synchronized part range too big, slower
			public void test2() {
				synchronized (this) {
				if (ticket<0) {
					flag = false;
					return;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"::"+ticket--);
			}
		}
			public void test3() {
				synchronized ((Integer)ticket) {//Thread unsafe , ticket have 10 different obj
				if (ticket<0) {
					flag = false;
					return;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"::"+ticket--);
			}
		}
			public void test4() {
				synchronized ((Integer)ticket) {//The range is too small , can't  be locked
				if (ticket<0) {
					flag = false;
					return;
				}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"::"+ticket--);
			}
			//We should locked the range as small as possible .(don't mean code , it means data)
			//double checking
			public void test5() {
				if (ticket<0) { //think about no ticket
					flag = false;
					return;
				}
				synchronized (this) {// think about the last ticket
					if (ticket<0) {
						flag = false;
						return;
					}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e){
				
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"::"+ticket--);
			}
		}
		
		
		

		}


	}




