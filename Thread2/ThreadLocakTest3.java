/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���أ��ֲ�����
 * getset initalvalue
 * ���Ĳ���Ӱ�������߳�
 * Thread local ; ����������
 * 1.������ ������þ�������
 * 2.run L���߳��Լ���
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
