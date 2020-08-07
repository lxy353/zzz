package com.lxy.test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import com.lxy.test.bean.User;
import com.sun.jdi.Type;


public class Demo04 {
	public void test01(Map<String, User>map,List<User> list) {
		System.out.println("Demo04.test01()");
	}
	public Map<Integer, User> test02(){
		System.out.println("Demo04.test02()");
		return null;
	}
	public static void main(String[] args) {
		try {
			//获得指定方法参数泛型信息
			Method method = Demo04.class.getMethod("test01", Map.class,List.class);
			java.lang.reflect.Type[] type = method.getGenericExceptionTypes();
			for (java.lang.reflect.Type type2 : type) {
				System.out.println("#"+type2);
				if (type2 instanceof ParameterizedType) {
					java.lang.reflect.Type[] genericTypes=((ParameterizedType) type2).getActualTypeArguments();
					for (java.lang.reflect.Type genericType : genericTypes) {
						System.out.println("泛型"+genericType);
						
					}
				}
				
			}
			//获得指定方法返回泛型信息
			Method method2 = Demo04.class.getMethod("test02", null);
			java.lang.reflect.Type returnTypes = method2.getGenericReturnType();
			if (returnTypes instanceof ParameterizedType) {
				java.lang.reflect.Type[] geneicTypes = ((ParameterizedType) returnTypes).getActualTypeArguments();
				for (java.lang.reflect.Type geneicType : geneicTypes) {
					System.out.println("返回值，泛型类型"+geneicType);
					
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}

}
