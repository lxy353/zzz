package myCollection;
public class MyArrayList3<E> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	public MyArrayList3() {
		elementDate = new Object[DEFALT_CAPACITY];	
	}
	public MyArrayList3(int capacity) {
		elementDate=new Object[capacity];
	}
	public void add(E element) {
		if(size==elementDate.length) {
			Object[] newArrayObjects = new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, newArrayObjects, 0,elementDate.length);
			elementDate=newArrayObjects;
		}
		elementDate[size++]=element;		
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
		MyArrayList s1= new MyArrayList();
		for (int i = 0; i < 40; i++) {
			s1.add("aa"+i);			
		}		
		System.out.println(s1);	
	}
}