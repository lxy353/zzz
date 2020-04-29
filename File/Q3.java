import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 实现List和Map数据的转换。具体要求如下：
    功能1：定义方法public void listToMap( ){ }将List中Student元素封装到Map中
         1) 使用构造方法Student(int id,String name,int age,String sex )创建多个学生信息并加入List;
          2) 遍历List，输出每个Student信息;
          3) 将List中数据放入Map，使用Student的id属性作为key，使用Student对象信息作为value;
      功能2：定义方法public void mapToList( ){ }将Map中Student映射信息封装到List
         1) 创建实体类StudentEntry，可以存储Map中每个Entry的信息;
          2) 使用构造方法Student(int id,String name,int age,String sex )创建多个学生信息，并使用Student的id属性作为key，存入Map;
          3) 创建List对象，每个元素类型是StudentEntry;
          4) 将Map中每个Entry信息放入List对象。
    功能3：说明Comparable接口的作用，并通过分数来对学生进行排序。
 * @author 皮
 *
 */
public class Q3 {
	public static void main(String[] args) {
		Q3 ft = new Q3();
		ft.listToMap();
		ft.mapToList();
			
	}
	public void listToMap() {
		List<Student01> list = new ArrayList<>();
		
		Student01 stu1 = new Student01(1001, "科比", 41, "男");
		Student01 stu2 = new Student01(1002, "詹姆斯", 36, "男");
		Student01 stu3 = new Student01(1003, "奥尼尔", 48, "男");
		Student01 stu4 = new Student01(1004, "乔丹", 57, "男");
		
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		
		System.out.println("List遍历的结果为：");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		Map<Integer,Student01> m = new HashMap<>();
		//用于获得List元素（即Student01对象）的id作为Map的key
		int result;
		
		for(int i=0;i<list.size();i++) {
			result = list.get(i).getId();
			m.put(result, list.get(i));
		}
		
		Set<Integer> keySet = m.keySet();
		System.out.println("List转换为Map结果为：");
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext();) {
			Integer key = iter.next();
			System.out.println(key+"="+m.get(key));
		}
	}
	
	public void mapToList() {
		Map<Integer,StudentEntry> m = new HashMap<>();
		
		StudentEntry se1 = new StudentEntry(1001, "科比", 41, "男");
		StudentEntry se2 = new StudentEntry(1002, "詹姆斯", 36, "男");
		StudentEntry se3 = new StudentEntry(1003, "奥尼尔", 48, "男");
		StudentEntry se4 = new StudentEntry(1004, "乔丹", 57, "男");
		
		m.put(se1.getId(), se1);
		m.put(se2.getId(), se2);
		m.put(se3.getId(), se3);
		m.put(se4.getId(), se4);
		
		List<StudentEntry> list = new ArrayList<>();
		
		Set<Entry<Integer, StudentEntry>> entrySet = m.entrySet();
		for(Entry<Integer,StudentEntry> e:entrySet) {
			list.add(e.getValue());
			
		}
		System.out.println("Map转换为List的结果为：");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
class Student01{
	private int id;
	private String name;
	private int age;
	private String sex;
	
	public Student01() {
	}
	
	public Student01(int id, String name, int age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
		public String toString() {
			return "学号："+id+"，姓名："+name+"，年龄："+age+"，性别："+sex;
		}
}
//继承了Student01类，就拥有了Student01类的成员属性
class StudentEntry extends Student01{

	public StudentEntry() {
		super();
	}
	//父类的构造方法不能继承，所以要重新写
	public StudentEntry(int id, String name, int age, String sex) {
		super(id, name, age, sex);
		// TODO Auto-generated constructor stub
	}				
}
