package com.lxy;

public class User {
	String name;
	String password;
	String email;
	
public User(String name,String password,String email) {
	this.name=name;
	this.password=password;
	this.email=email;
}
public User(String name,String password) {
	this.name=name;
	this.password=password;
	this.email=name+"@gameschool.com";
}
public void display() {
	System.out.println("name:"+name);
	System.out.println("PassWord:"+password);
	System.out.println("Email:"+email);
}

public static void main(String[] args) {
	User u =new User("XinyuLiu","12345");
	u.display();
	
}

}
