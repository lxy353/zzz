package com.lxy.test.Annotation;
@Table("tb-student")
public class Student {
	
	@Filed(columeName = "id",type = "int",length = 10)
	private int id;
	@Filed(columeName = "studentName",type = "lxy",length = 10)
	private String studentName;
	@Filed(columeName = "age",type = "int",length = 3)
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
