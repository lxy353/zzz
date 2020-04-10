
public class TestString {
	public static void main(String[] args) {
		String str="acc";
		String str2 = new String("def");
		String str3 = "adc"+"def";
		String str4 = 18+"18";
		System.out.println("str3:"+str3);
		
		System.out.println("#########################");
		
		String str10 ="lxy";
		String str11 ="lxy";
		String str12 = new String("lxy");
		
		
		System.out.println(str10 =str11);
		System.out.println(str11= str12);
		
		
		// in general , we use equals to compare the value for string
		
		System.out.println(str11.equals(str12));
		
		
	}

}
