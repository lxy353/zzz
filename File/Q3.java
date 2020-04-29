import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ʵ��List��Map���ݵ�ת��������Ҫ�����£�
    ����1�����巽��public void listToMap( ){ }��List��StudentԪ�ط�װ��Map��
         1) ʹ�ù��췽��Student(int id,String name,int age,String sex )�������ѧ����Ϣ������List;
          2) ����List�����ÿ��Student��Ϣ;
          3) ��List�����ݷ���Map��ʹ��Student��id������Ϊkey��ʹ��Student������Ϣ��Ϊvalue;
      ����2�����巽��public void mapToList( ){ }��Map��Studentӳ����Ϣ��װ��List
         1) ����ʵ����StudentEntry�����Դ洢Map��ÿ��Entry����Ϣ;
          2) ʹ�ù��췽��Student(int id,String name,int age,String sex )�������ѧ����Ϣ����ʹ��Student��id������Ϊkey������Map;
          3) ����List����ÿ��Ԫ��������StudentEntry;
          4) ��Map��ÿ��Entry��Ϣ����List����
    ����3��˵��Comparable�ӿڵ����ã���ͨ����������ѧ����������
 * @author Ƥ
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
		
		Student01 stu1 = new Student01(1001, "�Ʊ�", 41, "��");
		Student01 stu2 = new Student01(1002, "ղķ˹", 36, "��");
		Student01 stu3 = new Student01(1003, "�����", 48, "��");
		Student01 stu4 = new Student01(1004, "�ǵ�", 57, "��");
		
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		
		System.out.println("List�����Ľ��Ϊ��");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		Map<Integer,Student01> m = new HashMap<>();
		//���ڻ��ListԪ�أ���Student01���󣩵�id��ΪMap��key
		int result;
		
		for(int i=0;i<list.size();i++) {
			result = list.get(i).getId();
			m.put(result, list.get(i));
		}
		
		Set<Integer> keySet = m.keySet();
		System.out.println("Listת��ΪMap���Ϊ��");
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext();) {
			Integer key = iter.next();
			System.out.println(key+"="+m.get(key));
		}
	}
	
	public void mapToList() {
		Map<Integer,StudentEntry> m = new HashMap<>();
		
		StudentEntry se1 = new StudentEntry(1001, "�Ʊ�", 41, "��");
		StudentEntry se2 = new StudentEntry(1002, "ղķ˹", 36, "��");
		StudentEntry se3 = new StudentEntry(1003, "�����", 48, "��");
		StudentEntry se4 = new StudentEntry(1004, "�ǵ�", 57, "��");
		
		m.put(se1.getId(), se1);
		m.put(se2.getId(), se2);
		m.put(se3.getId(), se3);
		m.put(se4.getId(), se4);
		
		List<StudentEntry> list = new ArrayList<>();
		
		Set<Entry<Integer, StudentEntry>> entrySet = m.entrySet();
		for(Entry<Integer,StudentEntry> e:entrySet) {
			list.add(e.getValue());
			
		}
		System.out.println("Mapת��ΪList�Ľ��Ϊ��");
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
			return "ѧ�ţ�"+id+"��������"+name+"�����䣺"+age+"���Ա�"+sex;
		}
}
//�̳���Student01�࣬��ӵ����Student01��ĳ�Ա����
class StudentEntry extends Student01{

	public StudentEntry() {
		super();
	}
	//����Ĺ��췽�����ܼ̳У�����Ҫ����д
	public StudentEntry(int id, String name, int age, String sex) {
		super(id, name, age, sex);
		// TODO Auto-generated constructor stub
	}				
}
