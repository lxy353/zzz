package com.lxy.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lxy.test.bean.User;
@SuppressWarnings("all")
public class Demo06{
	public static void test01() {
		User user = new User();
		
		long startTime=System.currentTimeMillis();
		for (int i = 0; i < 1000000L; i++) {
			user.getUname();
			
		}
		long endTime=System.currentTimeMillis();
		System.out.println("普通方法调用耗时"+(endTime-startTime)+"ms");
	}
	public static void test02() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User user = new User();
		Class clazz = user.getClass();
		Method method = clazz.getDeclaredMethod("getUname", null);
		
		long startTime=System.currentTimeMillis();
		for (int i = 0; i < 1000000L; i++) {
			method.invoke(user, null);
			
		}
		long endTime=System.currentTimeMillis();
		System.out.println("放射动态方法调用耗时"+(endTime-startTime)+"ms");
	}
	public static void test03() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User user = new User();
		Class clazz = user.getClass();
		Method method = clazz.getDeclaredMethod("getUname", null);
		method.setAccessible(true);
		long startTime=System.currentTimeMillis();
		for (int i = 0; i < 1000000L; i++) {
			method.invoke(user, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("放射动态方法跳过安全调差调用耗时"+(endTime-startTime)+"ms");
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		test01();
		test02();
		test03();
	}
		
	
}