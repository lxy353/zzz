package ���������ȫ����;

public class Demo01 {
	public static void main(String[] args) {
		
	A a = new A();
	System.out.println(A.width);
	
	}

}
class A{
	public static int width=100;
	static {
		System.out.println("��̬��ʼ����A");
		width =300;
	}
	public A(){
		System.out.println("����A�����");
	}
}
