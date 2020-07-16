import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java 结构
 * @author java 类中的各种结构（方法，属性，构造器，类型）映射成一个个的java对象
 * 1.获取Class 对象
 * 三种方式：class for name（“完整路径”）
 * 2.可以动态创建了
 * 
 * 
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//三种方式
		//1.对象
		iphone iphoe = new iphone();
		Class clzClass = new iphone().getClass();
		//2.类。class（）
		clzClass = iphone.class;
		//3 class for name ("包名。类名")
		clzClass = clzClass.forName("Server-study.iphone");
		//创建对象
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
