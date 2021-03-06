package com.lxy.test.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	String studengName() default"";
	int age() default 0;
	int id() default -1;//string indexof("abc") 
	
	String[]schools() default{"lxy"};
}
