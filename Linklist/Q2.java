import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * ��HashSet��TreeSet�洢�����Ʒ��Ϣ�����������;������Ʒ���ԣ���ţ����ƣ����ۣ�������;
 * Ҫ����������Ӷ����ͬ����Ʒ����֤������Ԫ�ص�Ψһ�ԡ�
    ��ʾ����HashSet������Զ�����Ķ�����Ϣ����Ҫ��дhashCode��equals( )��
��TreeSet������Զ�����Ķ�����Ϣ����Ҫʵ��Comparable�ӿڣ�ָ���Ƚ� ����
 * @author Ƥ
 *
 */
public class Q2 {
	public static void main(String[] args) {
		storeTreeSet();
		System.out.println("###############################");
		storeHashSet();
	}
	
	public static void storeTreeSet() {		
		Set<Goods02> set = new TreeSet<>(new Comparator<Goods02>() {
			@Override
			public int compare(Goods02 o1, Goods02 o2) {
				//ֱ���������ڲ��࣬��id����������ظ��Ķ���
				return ((Integer)o1.getId()).compareTo((Integer)o2.getId());
			}			
		});
		
		Goods02 goods1 = new Goods02(1003, "����", 49, "�廪��ѧ");
		Goods02 goods2 = new Goods02(1002, "��ѧ", 59, "�廪��ѧ");
		Goods02 goods3 = new Goods02(1004, "Ӣ��", 90, "�Ϻ���ͨ��ѧ");
		Goods02 goods4 = new Goods02(1001, "����", 30, "ͬ�ô�ѧ");
		Goods02 goods5 = new Goods02(1005, "��ѧ", 59, "������ѧ");
		Goods02 goods6 = new Goods02(1000, "��ѧ", 59, "������ѧ");//�����Ϳ�����ӣ���Ϊ���û�ظ�
		
		//�������Ͳ�����ӽ�ȥ
		Goods02 goods7 = new Goods02(1005, "��ѧ", 59, "������ѧ");
		Goods02 goods8 = new Goods02(1005, "��ѧ", 59, "������ѧ");
		
		set.add(goods1);
		set.add(goods2);
		set.add(goods3);
		set.add(goods4);
		set.add(goods5);
		set.add(goods6);
		set.add(goods7);
		set.add(goods8);
		
		for(Iterator<Goods02> iter=set.iterator();iter.hasNext();) {
			Goods02 goods = iter.next();
			System.out.println(goods);
		}				
	}
	public static void storeHashSet() {
		Set<Goods02> set = new HashSet<>();
		
		Goods02 goods1 = new Goods02(1003, "����", 49, "�廪��ѧ");
		Goods02 goods2 = new Goods02(1002, "��ѧ", 59, "�廪��ѧ");
		Goods02 goods3 = new Goods02(1004, "Ӣ��", 90, "�Ϻ���ͨ��ѧ");
		Goods02 goods4 = new Goods02(1001, "����", 30, "ͬ�ô�ѧ");
		Goods02 goods5 = new Goods02(1005, "��ѧ", 59, "������ѧ");
		Goods02 goods6 = new Goods02(1000, "��ѧ", 59, "������ѧ");//�����Ϳ�����ӣ���Ϊ���û�ظ�
		
		//�������Ͳ�����ӽ�ȥ
		Goods02 goods7 = new Goods02(1005, "��ѧ", 59, "������ѧ");
		Goods02 goods8 = new Goods02(1005, "��ѧ", 59, "������ѧ");
		
		set.add(goods1);
		set.add(goods2);
		set.add(goods3);
		set.add(goods4);
		set.add(goods5);
		set.add(goods6);
		set.add(goods7);
		set.add(goods8);
		//�õ���������Set
		for(Iterator<Goods02> iter=set.iterator();iter.hasNext();) {
			Goods02 good = iter.next();
			System.out.println(good);
		}		
	}
}

class Goods02 {
	private int id;
	private String name;
	private int price;
	private String producer;	
	//�޲ι���
	public Goods02() {
		super();
	}
	
	public Goods02(int id, String name, int price, String producer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.producer = producer;
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
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	@Override
	public String toString() {
		return "��ţ�"+id+"�����ƣ�"+name+"�����ۣ�"+price+"�������磺"+producer;
	}
	//��дequals������ͬʱ����Ҳ��дhashCode��������Ϊ���뱣֤hashCode��equals��ʹ�õĹ淶��
	@Override
	public boolean equals(Object obj) {
		//�жϸö����ǲ������ǵ�Goods02����
		if(obj instanceof Goods02) {
			//������ֱ�ӽ��ö���ǿ��ת��ΪGoods02���󣬲���һ�ж϶����ÿһ���ַ��Ƿ����
			Goods02 newGoods = (Goods02) obj;
			if(newGoods.getId()!=this.getId()) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		//hashCode�������ص���int���ͣ����ұ�֤����ֵҪ��Goods02����������й�
		return this.getId();
	}	
}
