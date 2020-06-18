/**
 * 用于保证数据的同步
 * @author lxz35
 *
 */
public class VolatileTest {
	private static int number = 0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()-> {
			while (number==0) {
				
			}
		}).start();
		
		Thread.sleep(1000);
		number =1;
	}

}
