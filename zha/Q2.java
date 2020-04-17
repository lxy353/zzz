import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
	System.out.println("give me a int a");
	Scanner scanner1 = new Scanner(System.in);
	int a = scanner1.nextInt();
	System.out.println("give me a int b");
	Scanner scanner2 = new Scanner(System.in);
	int b = scanner2.nextInt();
	System.out.println("give me a int b");
	Scanner scanner3 = new Scanner(System.in);
	int c = scanner3.nextInt();
	isTriangle(a,b,c);
	}
	static void isTriangle(int a,int b,int c) {
		if((a^2)!=(b^2)+(c^2)||(b^2)!=(a^2)+(c^2)||(c^2)!=(a^2)+(b^2));
		throw new IllegalArgumentException("They cant make triangle");
	}

}
