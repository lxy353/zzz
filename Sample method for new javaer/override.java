package com.godliu;

public class override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse h  = new Horse();
			h.run();
	}
}
class Vehicle{
	public void run() {
		System.out.println("run");
	}
	
	public void stop() {
		System.out.println("stop");
	}
}
class Horse extends Vehicle{
	public void run() {
		System.out.println("111");
	}
}

