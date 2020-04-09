package coop;

public class TestStaticInnerClass {
	
	public static void main(String[] args) {
		
		Outer2.Inner2 inner = new Outer2.Inner2();
		
		inner.show();
	}
}
class Outer2{
	static class Inner2{
		int age = 20;	
			public void show() {
				int age = 30;
				System.out.println("Outer class age:"+this.age);
				System.out.println("age:"+age);
		
	}
	}
}
