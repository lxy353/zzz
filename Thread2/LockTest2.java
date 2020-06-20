
/**
 *bu 可重入锁，bu可以重复利用
 * @author lxz35
 *
 */
public class LockTest2 {
	Lock lock = new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		b();
		lock.unlock();
		
	}
	public void b() throws InterruptedException {
		lock.lock();
		lock.unlock();
		
	}


	public static void main(String[] args) throws InterruptedException {
		LockTest2 test2 = new LockTest2();
		test2.a();
		test2.b();
		
	}

}
class Lock{
	
	private boolean isLocked= false;
	
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
		
	}
	public void unlock() {
		isLocked = false;
		notify();
		
	}
}
