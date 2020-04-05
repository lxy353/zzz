package com.godliu;

public class TestObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Object obj;
		TestObject to = new TestObject();
		System.out.println(to.toString());
		Person2 p = new Person2("lxy",11);
		System.out.println(p.toString());
		
	}
	public String toString() {
		return "TestObject";
	}
}

class Person2{
	String name;
	int age;
	//@Override
	public String toString() {
		return "name:"+name +"age:" + age;
	}

public Person2(String name , int age) {
	this.name=name;
	this.age=age;
	
}
}
