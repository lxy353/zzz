/**
 * ThreadLocal:每个线程自身的存储本地，局部区域
 * getset initalvalue
 * 更改不会影响其他线程
 * Thread local ; 分析上下文
 * 1.构造器 那里调用就是那里
 * 2.run L本线程自己的
 * Inheritable Threadlocal : 继承上下wen 的数据 ,copy 起点数据
 * @author lxz35
 *
 */
public class ThreadLocakTest4 {	
	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
	public static void main(String[] args) {
		
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+":"+ threadLocal.get());
		
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+":"+ threadLocal.get());
		}).start();
	
	}
		
	
	

}
