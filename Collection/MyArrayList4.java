package myCollection;
import java.util.ArrayList;
import javax.management.RuntimeErrorException;
public class MyArrayList4<E> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	public MyArrayList4() {
		elementDate = new Object[DEFALT_CAPACITY];	
	}
	public MyArrayList4(int capacity) {
		elementDate=new Object[capacity];
	}
	public void add(E element) {
		if(size==elementDate.length) {
			int oldCapacity = elementDate.length;
	        Object[] newCapacity = new Object[oldCapacity + (oldCapacity >> 1)];
			System.arraycopy(elementDate, 0, newCapacity, 0,elementDate.length);
			elementDate=newCapacity;
		}
		elementDate[size++]=element;		
	}
	
	public E get(int index) {
		checkRange(index);
		return (E)elementDate[index];		
	}
	
	public void set(E element,int index) {
		checkRange(index);
		elementDate[index]=element;
	}
	
	public  void  checkRange(int index ){
	
				if(index<0||index>size-1){
					
					throw  new RuntimeException("nogood index:"+index);
				}
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
		MyArrayList4 s1= new MyArrayList4();
		for (int i = 0; i < 40; i++) {
			s1.add("aa"+i);			
		}		
		System.out.println(s1);	
		System.out.println(s1.get(39));
	
	}
}