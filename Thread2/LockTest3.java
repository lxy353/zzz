
/**
 *可重入锁，可以重复利用
 * @author lxz35
 *
 */
public class LockTest3 {
	ReLock lock = new ReLock();
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
		LockTest3 test3 = new LockTest3();
		test3.a();
		test3.b();
		
	}

}
class ReLock{
	
	private boolean isLocked= false;
	Thread lockedByThread= null;
	private int count = 0;
	public synchronized void lock() throws InterruptedException {
		Thread thread = Thread.currentThread();
		while (isLocked&&lockedByThread != thread) {
			wait();
		}
		isLocked = true;
		lockedByThread = thread;
		count++;
		
	}
	public void unlock() {
		if (Thread.currentThread() == lockedByThread) {
			count--;
			if (count==0) {
				isLocked = false;
				notify();
				lockedByThread = null;
			}
			
		}
		
		
	}
}
