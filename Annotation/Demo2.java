package com.lxy.test.Annotation;

import java.lang.annotation.*;

import com.sun.jdi.Field;

/**
 * ʹ�÷����ȡע����Ϣ�����㴦��ע����Ϣ������
 * @author jakel
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.lxy.test.Annotation.Student");
			//��ȡ�������ע��
			Annotation[] annotations = c.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			//�����ָ��ע��
			Table sTable =(Table)c.getAnnotation(Table.class);
			System.out.println(sTable.value());
			
			//���������Ե�ע��
			java.lang.reflect.Field field = c.getDeclaredField("studentName");
			Filed filed =field.getAnnotation(Field.class);
			System.out.println(Filed.columeName()+"--"+Filed.type()+"--"+Filed.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
