package com.lxy;

public class Person1 {
	int age;
	String name;
	
	public Person1( String name, int age){
		this.age=age;
		this.name=name;
	}
	public void display() {
		System.out.println("name "+name+" age"+age);
		
	}
	public static void main(String[] args){
			Person1 person1=new Person1("lxy",21);	
			person1.display();
		}
		
	}


