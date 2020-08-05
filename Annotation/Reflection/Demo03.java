package com.lxy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lxy.test.bean.User;

/**
 * 通过放射API动态操作：构造器 方法 构造器
 * @author jakel
 *
 */
public class Demo03 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
String path="com.lxy.test.bean.User";
		
		try {
			Class<?> clazz=Class.forName(path);
			
			//通过动态调用构造方法 构造对象
			User user = (User)clazz.newInstance(); //其实是调用User 的无参构造方法
			System.out.println(user);
			//通过api
			User user2 = (User) clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(user2, "lxy");
			System.out.println(user2.getUname());
			//通过反射API
			User user3 = (User) clazz.newInstance();
			Field field = clazz.getDeclaredField("uname");
			field.setAccessible(true);
			field.set(user3, "lxy1");
			System.out.println(user3.getUname());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
