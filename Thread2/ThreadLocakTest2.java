/**
 * ThreadLocal:每个线程自身的存储本地，局部区域
 * getset initalvalue
 * 更改不会影响其他线程
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
