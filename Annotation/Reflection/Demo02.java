package com.lxy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.sun.jdi.Field;

/**
 * 应用反射的API 获取类的信息（类的名字属性方法构造器）
 * @author jakel
 *
 */
@SuppressWarnings("all")
public class Demo02 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path="com.lxy.test.bean.User";
		
		try {
			Class<?> clazz=Class.forName(path);
			//获取类的名字
			System.out.println(clazz.getName());//获得包名+类名
			System.out.println(clazz.getSimpleName());//class
			
			//获得属性
			//java.lang.reflect.Field[] fields = clazz.getFields();//只可以public field
			java.lang.reflect.Field[] fields = clazz.getDeclaredFields();// get all field
			java.lang.reflect.Field field = clazz.getDeclaredField("age");
			System.out.println(fields.length);
			for (java.lang.reflect.Field tempField : fields) {
				System.out.println("属性："+tempField);
			}
			//获得方法
			Method[] method = clazz.getDeclaredMethods();
			Method method2 = clazz.getDeclaredMethod("getUname", null);
			System.out.println(method.length);
			for (Method Tempmethod : method) {
				System.out.println("方法:"+Tempmethod);
			}
			//获得构造信息
			Constructor[] constructors= clazz.getConstructors();
			Constructor constructor =clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println(""+constructor);
			for (Constructor temConstructor : constructors) {
				System.out.println("构造器："+temConstructor);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
