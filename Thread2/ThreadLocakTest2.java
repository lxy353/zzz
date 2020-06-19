/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���أ��ֲ�����
 * getset initalvalue
 * ���Ĳ���Ӱ�������߳�
 * @author lxz35
 *
 */
public class ThreadLocakTest2 {	
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Myrun()).start();
			
		}
		
	
	}
		
	public static class Myrun implements Runnable{
		@Override
		public void run() {
			Integer leftInteger = threadLocal .get();
			System.out.println(Thread.currentThread().getName() + "we get:"+ leftInteger);
			threadLocal.set(leftInteger-1);
			System.out.println(Thread.currentThread().getName()+"we still have:"+threadLocal.get());
			
		}
	}
	

}
