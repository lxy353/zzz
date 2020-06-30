import java.io.Serializable;

class Employee implements Serializable{
	private transient double income;//该数据不序列化
	
	int age;
	public Employee(double income, int age) {
		super();
		this.income = income;
		this.age = age;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
