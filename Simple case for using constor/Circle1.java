package com.lxy;

public class Circle1 {
	double r;
	public Circle1(double r) {
		this.r=r;
	}
	public double getArea() {
		
		return Math.PI*r*r;
	}
	public double getPerimeter() {
		
		return 2*Math.PI*r;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle1 c = new Circle1(3);
		System.out.println("Area"+c.getArea());
		System.out.println("Perimeter" +c.getPerimeter());
		
		
	}

}
