package com.godliu;

public class TestExtends {
	public static void main(String[]args) {
		Student s = new Student(null, 0, null);
		s.height=111;
		s.name="xxx";
		s.rest();
		s.study();
		
		Student s1 = new Student("xx",11,"cs");
		System.out.println(s.height);
	}
}


class Person{
	String name;
	int height;
	
	public void rest() {
		System.out.println("taking a rest");
	}
}
class Student extends Person{
	String major;
	
	public void study() {
		System.out.println("studu");
	}
	public Student(String name, int height, String major) {
		this.major=major;
		this.height=height;
		this.name= name;
	}

}


