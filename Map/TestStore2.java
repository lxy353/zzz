import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestStore2 {
	public static void main(String[] args) {
		User user1 = new User(1001,"lxy",2000,"2020");
		User user2 = new User(1002,"lxy",2000,"2020");
		User user3 = new User(1003,"lxy",2000,"2020");
		
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		for(User u:list) {
			System.out.println(u);
		}
		
		Map<Integer, User> map = new HashMap<Integer, User>();
		Set<Integer> keySet=map.keySet();
		map.put(1001, user1);
		map.put(1002, user2);
		map.put(1003, user3);
		
		for(Integer key:keySet) {
			System.out.println(key+"===="+map.get(key));
		}
		
	}

}

class User{
	private int id;
	private String nameString;
	private double slary;
	private String date;
	
	public User(int id, String nameString, int slary, String date) {
		
	}
	public User() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getSlary() {
		return slary;
	}
	public void setSlary(double slary) {
		this.slary = slary;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id"+id+",name"+",salary:"+slary+"data"+date;
	}
	
}