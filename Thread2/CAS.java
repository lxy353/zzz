import java.util.concurrent.atomic.AtomicInteger;

/**
 * compare and swap
 * @author lxz35
 *
 */
public class CAS {
	//¿â´æ
	
	private static AtomicInteger stockAtomicInteger= new AtomicInteger(6);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(()-> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer lefeInteger=stockAtomicInteger.decrementAndGet();
				if (lefeInteger<1) {
					System.out.println("nothing");
					return;
					
				}
				System.out.println(Thread.currentThread().getName()+"u get.");
				System.out.println("left:" +lefeInteger);
				
			}).start();
			
		}
		
	}

}
