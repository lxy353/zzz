import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main  (String[] args) {
		Map<Integer, String>treeMap1 = new TreeMap<>();
		treeMap1.put(20, "aa");
		treeMap1.put(2, "bb");
		for (Integer key : treeMap1.keySet()) {
			System.out.println(""+treeMap1.get(key));
			
		}
		
	}

}
class Emp  implements Comparable<Emp>  {
	int id;
	String name;
	double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return  "id:"+id+",name:"+name+",salary:"+salary;
	}
	
	@Override
	public int compareTo(Emp o) {		//负数：小于，0：等于，正数：大于
		
		if(this.salary>o.salary){
			return 1;
		}else if(this.salary<o.salary){
			return -1;
		}else{
			if(this.id>o.id){
				return 1;
			}else if(this.id<o.id){
				return -1;
			}else{
				return 0;
			}
		}
		
	}
	
}
