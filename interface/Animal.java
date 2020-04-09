package coop;

public abstract class Animal {
	// 没有实现，子类必须实现。父类没有实现
	abstract public void shout(); 
	public void run(){
		System.out.println("run");
	}
}
class Dog extends Animal{
	
	public void shout() {
		System.out.println("wangwang");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Dog();
		Integer i;
	}

}
