import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��java �ṹ
 * @author java ���еĸ��ֽṹ�����������ԣ������������ͣ�ӳ���һ������java����
 * 1.��ȡClass ����
 * ���ַ�ʽ��class for name��������·������
 * 2.���Զ�̬������
 * 
 * 
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//���ַ�ʽ
		//1.����
		iphone iphoe = new iphone();
		Class clzClass = new iphone().getClass();
		//2.�ࡣclass����
		clzClass = iphone.class;
		//3 class for name ("����������")
		clzClass = clzClass.forName("Server-study.iphone");
		//��������
		/*iphone iphone2= (iphone)clzClass.newInstance();
		System.out.println(iphone2);*/
		iphone iphone2= (iphone)clzClass.getConstructor().newInstance();
		System.out.println(iphone2);
	}
}
class iphone{
	public iphone() {
		
	}
}
