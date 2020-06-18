/**
 * 指令重排：代码执行舒徐与预期不一致
 * 目的：提高性能
 * @author lxz35
 *
 */
public class HappenBefore {
	private static int a = 0;
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			a=0;
			flag = false;
		Thread thread1 = new Thread(()-> {
			a=1;
			flag =true;
		});
		Thread thread2 = new Thread(()-> {
			if (flag) {
			a*=1;
		
			}
			if (a==0) {
				System.out.println("happen before a->"+a);
		
			}
		});
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
	
	}
}
