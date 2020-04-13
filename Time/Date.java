

public class Date {
	public static void main(String[] args) {
        java.util.Date date = new java.util.Date(200);
		System.out.println(date);
		
		System.out.println(date.getTime());
		java.util.Date date1 = new java.util.Date();
		System.out.println(date1.getTime());
		
		System.out.println(date1.after(date));
		
		
	
		
	}

}
