import java.util.HashMap;
import java.util.Map;

public class TestMap2 {
	public static void main(String[] args) {
	Employee e1 = new Employee(1001,"lxy",10000);
	Employee e2 = new Employee(1002,"l",10001);
	Employee e3 = new Employee(1003,"ly",10002);
	Employee e4 = new Employee(1004,"lx",10003);
	
	Map<Integer, Employee> map = new HashMap<>();
	map.put(1001, e1);
	map.put(1002, e2);
	map.put(1003, e3);
	map.put(1004, e4);
	
	Employee employee = map.get(1002);
	System.out.println(employee.getEnameString());
	}

}
class Employee{
	private int id;
	private String enameString;
	private  double salary;
	public Employee(int i, String string, int j) {
		super();
		this.id=id;
		this.enameString=enameString;
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnameString() {
		return enameString;
	}
	public void setEnameString(String enameString) {
		this.enameString = enameString;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
