package com.lxy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lxy.test.bean.User;

/**
 * ͨ������API��̬������������ ���� ������
 * @author jakel
 *
 */
public class Demo03 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
String path="com.lxy.test.bean.User";
		
		try {
			Class<?> clazz=Class.forName(path);
			
			//ͨ����̬���ù��췽�� �������
			User user = (User)clazz.newInstance(); //��ʵ�ǵ���User ���޲ι��췽��
			System.out.println(user);
			//ͨ��api
			User user2 = (User) clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(user2, "lxy");
			System.out.println(user2.getUname());
			//ͨ������API
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
