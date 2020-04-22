
public class Test {
	public static void main(String[] args) {
		int h = 231313131;
		int length = 16;
		myHash(h,length);
	}
	private static int myHash(int h , int length) {
		System.out.println(h&(length-1));
		// TODO Auto-generated method stub
		System.out.println(h%length);
		return h&(length-1);

	}

}
