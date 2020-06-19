/**
 * ThreadLocal:每个线程自身的存储本地，局部区域
 * getset initalvalue
 * 更改不会影响其他线程
 * Thread local ; 分析上下文
 * 1.构造器 那里调用就是那里
 * 2.run L本线程自己的
 * @author lxz35
 *
 */
public class ThreadLocakTest3 {	
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
	public static void main(String[] args) {
		new Thread(new Myrun()).start();
		new Thread(new Myrun()).start();
	
	}
		
	public static class Myrun implements Runnable{
		public Myrun() {
			threadLocal.set(100);
			System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());	
		}
		public void run() {
			System.out.println(Thread.currentThread().getName()+"we still have:"+threadLocal.get());
			
		}
	}
	

}
