package coop;

public class TestInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create inner  class obj
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
	}
}
	// test static and no static inner class
class Outer{
	private int age = 10;
		
	class Inner{
		int age =20;
		public void show() {
			int age = 30;
			System.out.println("Outer class age:"+Outer.this.age);
			System.out.println("inner class age:"+this.age);
			System.out.println("age:"+age);
		}		
	}
}
