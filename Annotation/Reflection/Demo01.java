package com.lxy.test;
/**
 * 测试 各种类型的对应  class interface enum annotation primitive java.lang.class对象的获取方式
 * @author jakel
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	
	public static void main(String[] args) {
		String path="com.lxy.test.bean.User";
		
		try {
			Class<?> clazz=Class.forName(path);
			//对象是表示或封装一些数据，一个类被加载后，JVM会创建一个对应该类的class 对象，类的整个结构星系会被放在对于的class对象中。
			//class对象就是一面镜子一样，通过这面镜子我可以看到对应的全部信息
			System.out.println(clazz.hashCode());
			
			Class clazz2= Class.forName(path);//一个类对呀一个class对象
			System.out.println(clazz2.hashCode());
			
			Class strclassClass = String.class;
			Class strclassClass2 = path.getClass();
			System.out.println(strclassClass ==strclassClass2);
			
			Class intClass = int.class;
			
			int[] a = new int[10];
			int[] a2 = new int[30];
			int[][] a3 = new int[30][3];
			
			System.out.println(a.getClass().hashCode());
			System.out.println(a2.getClass().hashCode());
			System.out.println(a3.getClass().hashCode());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
