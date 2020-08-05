package com.lxy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.sun.jdi.Field;

/**
 * Ӧ�÷����API ��ȡ�����Ϣ������������Է�����������
 * @author jakel
 *
 */
@SuppressWarnings("all")
public class Demo02 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path="com.lxy.test.bean.User";
		
		try {
			Class<?> clazz=Class.forName(path);
			//��ȡ�������
			System.out.println(clazz.getName());//��ð���+����
			System.out.println(clazz.getSimpleName());//class
			
			//�������
			//java.lang.reflect.Field[] fields = clazz.getFields();//ֻ����public field
			java.lang.reflect.Field[] fields = clazz.getDeclaredFields();// get all field
			java.lang.reflect.Field field = clazz.getDeclaredField("age");
			System.out.println(fields.length);
			for (java.lang.reflect.Field tempField : fields) {
				System.out.println("���ԣ�"+tempField);
			}
			//��÷���
			Method[] method = clazz.getDeclaredMethods();
			Method method2 = clazz.getDeclaredMethod("getUname", null);
			System.out.println(method.length);
			for (Method Tempmethod : method) {
				System.out.println("����:"+Tempmethod);
			}
			//��ù�����Ϣ
			Constructor[] constructors= clazz.getConstructors();
			Constructor constructor =clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println(""+constructor);
			for (Constructor temConstructor : constructors) {
				System.out.println("��������"+temConstructor);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
