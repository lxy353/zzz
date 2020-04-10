
public class TestArrayCopy {
	public static void main(String[] args) {
		String[] s= {"阿里","尚学堂","京东","搜狐","网易"};
		
//		removeElement(s,1);
		
	}
	public static void testBasicCopy() {
		String[] s1 = {"aa","bb","cc","dd","ee"};
		String[]s2= new String[10];
		System.arraycopy(s1, 2, s2, 6, 3);
		for (int i = 0; i < s2.length; i++) {
		System.out.println(i+":"+s2[i]);
		}
	}
	public static void  testBasicCopu2() {
		String[] s1 = {"aa","bb","cc","dd","ee"};
		
		System.arraycopy(s1, 3, s1, 3-1, s1.length-3);
		s1[s1.length-1]=null;
		for (int i = 0; i < s1.length; i++) {
			System.out.println(i+":"+s1[i]);
			
		}
		
	}
	public static String[] removeElement(String[]s,int index) {
		System.arraycopy(s, index, s, index-1, s.length-index);
		s[s.length-1]=null;
		for (int i = 0; i < s.length; i++) {
			System.out.println(i+":"+s[i]);
		}
		return s;
		
	}
	public static String[] extendRange() {
		String[] s1 = {"aa","bb","cc"};
		String[] s2 = new String[s1.length+10];
		System.arraycopy(s1, 0, s2, 0, s1.length);
		for(String temp:s2) {
			System.out.println(temp);
		}
		return s2;
	}
	public static String[] addElement() {
		String[] s1 = {"aa","bb","cc"};
		String[] s2 = new String[s1.length+10];
		System.arraycopy(s1, 0, s2, 1, 1);
		for(String temp:s2) {
			System.out.println(temp);
		}
		return s2;
	}
	
	
	
}