import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCollection<String> myCollection = new MyCollection<String>();
		
		myCollection.set("lxy", 0);
	
		
		String b = myCollection.get(0);
		
		List list = new ArrayList();
		Map map = new HashMap();
	}
}

class MyCollection<E>{
	Object[] objects = new Object[5];
	public void set(E e, int index) {
		objects[index]=e;	
	}
	public E get(int index) {
		return (E)objects[index];
		
	} 
		
}