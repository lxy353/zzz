package com.lxy.test;
/**
 * ���� �������͵Ķ�Ӧ  class interface enum annotation primitive java.lang.class����Ļ�ȡ��ʽ
 * @author jakel
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	
	public static void main(String[] args) {
		String path="com.lxy.test.bean.User";
		
		try {
			Class<?> clazz=Class.forName(path);
			//�����Ǳ�ʾ���װһЩ���ݣ�һ���౻���غ�JVM�ᴴ��һ����Ӧ�����class ������������ṹ��ϵ�ᱻ���ڶ��ڵ�class�����С�
			//class�������һ�澵��һ����ͨ�����澵���ҿ��Կ�����Ӧ��ȫ����Ϣ
			System.out.println(clazz.hashCode());
			
			Class clazz2= Class.forName(path);//һ�����ѽһ��class����
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
