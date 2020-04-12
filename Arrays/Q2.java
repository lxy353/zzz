import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[50];
		int count=0;
		int n = 0;
		System.out.println("give me a range");
		Scanner scanner = new Scanner(System.in);
		n=scanner.nextInt();
		
		for (int i = 1; i < 50; i++) {
			int num=(int)(n*Math.random());
		int number = 0;
		a[i]=+num;
		if(a[i] >= 60) {
			count++;
			}
	}
		 Arrays.sort(a);
		 System.out.println(Arrays.toString(a));
         System.out.println("min:"+a[1]);
         System.out.println("max:"+a[49]);
		 System.out.println("count:" +count);
	}

}
