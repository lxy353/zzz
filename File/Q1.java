import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * ʹ��List��Map��Ŷ��ͼ����Ϣ�������������
 * ������Ʒ���ԣ���ţ����ƣ����ۣ�������;ʹ����Ʒ�����ΪMap�е�key��
 * ���Լ��ּ���storeMap02��������Goods��Ϊvalue����value�е�price����
 * @author lxy
 *
 */
public class Q1 {
	public static void main(String[] args) {
		System.out.println("Goods��Ϊkey����comparable��price��������");
		storeMap();
		System.out.println("������List��Collections������ʵ����price����");
		storeList();
		System.out.println("Goods��Ϊvalue����comparable��price����");
		storeMap02();
	}
	
	//��Map�洢��Map��ֵ��Ϊ<Goods,Integer>
	public static void storeMap() {
		Map<Goods01,Integer> m = new TreeMap<>();
		
		Goods01 goods1 = new Goods01(1003, "����", 49, "�廪��ѧ");
		Goods01 goods2 = new Goods01(1002, "��ѧ", 59, "�廪��ѧ");
		Goods01 goods3 = new Goods01(1004, "Ӣ��", 90, "�Ϻ���ͨ��ѧ");
		Goods01 goods4 = new Goods01(1001, "����", 30, "ͬ�ô�ѧ");
		Goods01 goods5 = new Goods01(1005, "��ѧ", 59, "������ѧ");
		
		m.put(goods1,goods1.getId());
		m.put(goods2,goods2.getId());
		m.put(goods3,goods3.getId());
		m.put(goods4,goods4.getId());
		m.put(goods5,goods5.getId());
		
		Set<Entry<Goods01, Integer>> s1 = m.entrySet();
		for(Iterator<Entry<Goods01, Integer>> iter=s1.iterator();iter.hasNext();) {
			Entry<Goods01, Integer> entry = iter.next();
			System.out.println(entry);
		}	
	}

	//��List�洢
	public static void storeList() {
		List<Goods01> list = new ArrayList<>();
		
		list.add(new Goods01(1003, "����", 49, "�廪��ѧ"));
		list.add(new Goods01(1002, "��ѧ", 59, "�廪��ѧ"));
		list.add(new Goods01(1004, "Ӣ��", 90, "�Ϻ���ͨ��ѧ"));
		list.add(new Goods01(1001, "����", 30, "ͬ�ô�ѧ"));
		list.add(new Goods01(1005, "��ѧ", 59, "������ѧ"));
		
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	//��Map�洢��Map��ֵ��Ϊ<Integer,Goods>
	public static void storeMap02() {
		final Map<Integer,Goods01> m = new TreeMap<>();
		
		Goods01 goods1 = new Goods01(1003, "����", 49, "�廪��ѧ");
		Goods01 goods2 = new Goods01(1002, "��ѧ", 59, "�廪��ѧ");
		Goods01 goods3 = new Goods01(1004, "Ӣ��", 90, "�Ϻ���ͨ��ѧ");
		Goods01 goods4 = new Goods01(1001, "����", 30, "ͬ�ô�ѧ");
		Goods01 goods5 = new Goods01(1005, "��ѧ", 59, "������ѧ");
		
		m.put(goods1.getId(), goods1);
		m.put(goods2.getId(), goods2);
		m.put(goods3.getId(), goods3);
		m.put(goods4.getId(), goods4);
		m.put(goods5.getId(), goods5);	
		//ʹ���������ڲ���ʵ��compare��������д
		Map<Integer,Goods01> m1 = new TreeMap<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(m.get(o1)!=m.get(o2)) {
					return m.get(o1).compareTo(m.get(o2));
				}else {
					return m.get(o1).compareTo(m.get(o2));
				}
			}			
		});
		
		m1.putAll(m);
		
		Set<Entry<Integer, Goods01>> ss = m1.entrySet();
		for(Iterator<Entry<Integer,Goods01>> iter=ss.iterator();iter.hasNext();) {
			Entry<Integer,Goods01> ee = iter.next();
			System.out.println(ee);
		}				
	}
}

class Goods01 implements Comparable<Goods01>{
	private int id;
	private String name;
	private int price;
	private String company;
	
	public Goods01(int id, String name, int price, String company) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.company = company;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Goods01() {
	}	
	//ʵ��comparable�ӿ��ȶԼ۸�������򣬼۸���ͬ�ٸ���ID����
	@Override
	public int compareTo(Goods01 o) {
		if(this.price<o.price) {
			return -1;
		}else if(this.price>o.price) {
			return 1;
		}else
			if(this.id<o.id) {
				return -1;
			}else if(this.id>o.id) {
				return 1;
			}else {
				return 0;
			}
	}
	
	@Override
	public String toString() {
		return "���:"+id+"�����ƣ�"+name+"�����ۣ�"+price+"�������磺"+company;
	}
}
