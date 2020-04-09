package coop;

public class TestAnonymousInnerClass {
	public static void test01(A a) {
		System.out.println("123");
		a.aa();
		
	}
	public static void main(String[] args) {
		TestAnonymousInnerClass.test01(new A() {
		
		public void aa() {
			System.out.println("11111111");
		}
			
		});
	}
}
interface A{
	void aa();
}

