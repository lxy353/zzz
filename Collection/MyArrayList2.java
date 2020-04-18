package myCollection;

public class MyArrayList2<E> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	
	public MyArrayList2 () {
		elementDate = new Object[DEFALT_CAPACITY];	
	}
	public MyArrayList2(int capacity) {
		elementDate=new Object[capacity];
	}
	public void add(E object) {
		elementDate[size++]=object;
		
	}
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
	    stringBuilder.append("[");
	    for (int i = 0; i < size; i++) {
			stringBuilder.append(elementDate[i]+",");
	    }
	  
	   stringBuilder.setCharAt(stringBuilder.length()-1, ']');
			return stringBuilder.toString();
		}
		
		
	
	public static void main  (String[] args) {
		MyArrayList s1= new MyArrayList(20);
		s1.add("aa");
		s1.add("bb");
		System.out.println(s1);
		
	}

}
