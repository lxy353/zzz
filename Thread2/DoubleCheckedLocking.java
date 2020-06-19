/**
 * 单例模式：对外只有一个对象（多线程）
 * 1.构造器私有化----避免外部new构造器
 * 2.提供私有的静态属性---存储对象的地址
 * 3.提供公共的静态方法---获取属性
 * @author lxz35
 *
 */
public class DoubleCheckedLocking {
	//2
	private static volatile DoubleCheckedLocking instance;
	//没有volatile 可能访问没有对象的
	//1
	private DoubleCheckedLocking() {
		
	}
	//3 
	public static DoubleCheckedLocking getInstance() {
		//double checking
		if (null!=instance) {
			return instance;
		}
		synchronized (DoubleCheckedLocking.class) {
			if (null== instance) {
				instance = new DoubleCheckedLocking();	
				//1.开辟空间
				//2.初始化
				//3.返回地址
			}
		}
		return instance;
	}

	public static DoubleCheckedLocking getInstance1(long time) {
			if (null== instance) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();	
				//1.开辟空间
				//2.初始化
				//3.返回地址
			}
			return instance;
		}

	

	public static void main(String[] args) {
		Thread thread = new Thread (()->{
			System.out.println(DoubleCheckedLocking.getInstance1(200));
			
		});
		thread.start();
		System.out.println(DoubleCheckedLocking.getInstance1(400));
		
	}

}
