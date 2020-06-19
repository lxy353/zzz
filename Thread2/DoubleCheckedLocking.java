/**
 * ����ģʽ������ֻ��һ�����󣨶��̣߳�
 * 1.������˽�л�----�����ⲿnew������
 * 2.�ṩ˽�еľ�̬����---�洢����ĵ�ַ
 * 3.�ṩ�����ľ�̬����---��ȡ����
 * @author lxz35
 *
 */
public class DoubleCheckedLocking {
	//2
	private static volatile DoubleCheckedLocking instance;
	//û��volatile ���ܷ���û�ж����
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
				//1.���ٿռ�
				//2.��ʼ��
				//3.���ص�ַ
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
				//1.���ٿռ�
				//2.��ʼ��
				//3.���ص�ַ
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
