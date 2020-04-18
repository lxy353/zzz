import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {
	public static void main (String[] agrs) {
		
		test03();
	}
	public static void test01() {
         Collection<String> collection = new ArrayList<String>();
		
		System.out.println(collection.size());
		System.out.println(collection.isEmpty());
		
		collection.add("lll");
		collection.add("lxy");
		System.out.println(collection);
		
		collection.remove("lll");
		System.out.println(collection);
		
		System.out.println(collection.contains("lll"));
		
		Object[] objects =collection.toArray();
		System.out.println(objects);
		
		collection.clear();
		System.out.println(collection);
		
	}
	
	public static void test02() {
		List<String> list01 = new ArrayList<String>();
		list01.add("aa");
		list01.add("vv");
		list01.add("zz");
		
		List<String> list02 = new ArrayList<String>();
		list02.add("aa");
		list02.add("bb");
		list02.add("zz");
		System.out.println("list01"+list01);
		
		//list01.addAll(list02);
		//list01.removeAll(list02);
		list01.retainAll(list02);
		System.out.println(list01.contains(list02));
		System.out.println(list01);
		
	}
	public static void test03() {
		List<String>list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		System.out.println(list);
		list.add(2,"lxy");
		
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		list.set(2, "llxxyy");
		System.out.println(list);
		
		System.out.println(list.get(0));
		
		list.add("C");
		list.add("B");
		list.add("A");
		
		System.out.println(list);

		System.out.println(list.indexOf("B"));
		System.out.println(list.lastIndexOf("B"));
	}
}
