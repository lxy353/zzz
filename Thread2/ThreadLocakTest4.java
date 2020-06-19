/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���أ��ֲ�����
 * getset initalvalue
 * ���Ĳ���Ӱ�������߳�
 * Thread local ; ����������
 * 1.������ ������þ�������
 * 2.run L���߳��Լ���
 * Inheritable Threadlocal : �̳�����wen ������ ,copy �������
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
