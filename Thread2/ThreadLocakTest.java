/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���أ��ֲ�����
 * getset initalvalue
 * @author lxz35
 *
 */
public class ThreadLocakTest {
	//private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	//����
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initialValue() {
//			return 200;
//		}
//	};
	
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + ":"+ threadLocal.get());
		
		threadLocal.set(99);
		
		System.out.println(Thread.currentThread().getName() + ":"+ threadLocal.get());
		new Thread(new Myrun()).start();
	}
		
	public static class Myrun implements Runnable{
		@Override
		public void run() {
			threadLocal.set((int)Math.random()*99);
			System.out.println(Thread.currentThread().getName() + ":"+ threadLocal.get());
			
		}
	}
	

}
