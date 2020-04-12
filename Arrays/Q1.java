import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Search a world");
		Scanner scanner=new Scanner(System.in);
		String word="";
		word=scanner.nextLine();
		String []a = {"apple","dog","cat"};
		isExist(a,word);
	}
	 public static void isExist(String[] a,String word) { 
		boolean flag = true;
		for(int i = 0;i < a.length;i++) {
			if(a[i].equals(word)) {
				System.out.println("Yes");
				flag = false;
			}
		}
		if(flag) {
			System.out.println("No");
		}		
	}

}
