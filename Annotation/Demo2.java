package com.lxy.test.Annotation;

import java.lang.annotation.*;

import com.sun.jdi.Field;

/**
 * 使用放射读取注解信息，摸你处理注解信息的流程
 * @author jakel
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.lxy.test.Annotation.Student");
			//获取类的所有注解
			Annotation[] annotations = c.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			//获得类指定注解
			Table sTable =(Table)c.getAnnotation(Table.class);
			System.out.println(sTable.value());
			
			//获得类的属性的注解
			java.lang.reflect.Field field = c.getDeclaredField("studentName");
			Filed filed =field.getAnnotation(Field.class);
			System.out.println(Filed.columeName()+"--"+Filed.type()+"--"+Filed.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
