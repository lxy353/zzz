import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * 用HashSet和TreeSet存储多个商品信息，遍历并输出;其中商品属性：编号，名称，单价，出版社;
 * 要求向其中添加多个相同的商品，验证集合中元素的唯一性。
    提示：向HashSet中添加自定义类的对象信息，需要重写hashCode和equals( )。
向TreeSet中添加自定义类的对象信息，需要实现Comparable接口，指定比较 规则。
 * @author 皮
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
				//直接用匿名内部类，用id来处理插入重复的东西
				return ((Integer)o1.getId()).compareTo((Integer)o2.getId());
			}			
		});
		
		Goods02 goods1 = new Goods02(1003, "语文", 49, "清华大学");
		Goods02 goods2 = new Goods02(1002, "数学", 59, "清华大学");
		Goods02 goods3 = new Goods02(1004, "英语", 90, "上海交通大学");
		Goods02 goods4 = new Goods02(1001, "物理", 30, "同济大学");
		Goods02 goods5 = new Goods02(1005, "化学", 59, "北京大学");
		Goods02 goods6 = new Goods02(1000, "化学", 59, "北京大学");//该条就可以添加，因为编号没重复
		
		//这两条就不能添加进去
		Goods02 goods7 = new Goods02(1005, "化学", 59, "北京大学");
		Goods02 goods8 = new Goods02(1005, "化学", 59, "北京大学");
		
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
		
		Goods02 goods1 = new Goods02(1003, "语文", 49, "清华大学");
		Goods02 goods2 = new Goods02(1002, "数学", 59, "清华大学");
		Goods02 goods3 = new Goods02(1004, "英语", 90, "上海交通大学");
		Goods02 goods4 = new Goods02(1001, "物理", 30, "同济大学");
		Goods02 goods5 = new Goods02(1005, "化学", 59, "北京大学");
		Goods02 goods6 = new Goods02(1000, "化学", 59, "北京大学");//该条就可以添加，因为编号没重复
		
		//这两条就不能添加进去
		Goods02 goods7 = new Goods02(1005, "化学", 59, "北京大学");
		Goods02 goods8 = new Goods02(1005, "化学", 59, "北京大学");
		
		set.add(goods1);
		set.add(goods2);
		set.add(goods3);
		set.add(goods4);
		set.add(goods5);
		set.add(goods6);
		set.add(goods7);
		set.add(goods8);
		//用迭代器遍历Set
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
	//无参构造
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
		return "编号："+id+"，名称："+name+"，单价："+price+"，出版社："+producer;
	}
	//重写equals方法的同时必须也重写hashCode方法，因为必须保证hashCode和equals的使用的规范性
	@Override
	public boolean equals(Object obj) {
		//判断该对象是不是咱们的Goods02对象
		if(obj instanceof Goods02) {
			//若是则直接将该对象强制转换为Goods02对象，并逐一判断对象的每一个字符是否相等
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
		//hashCode方法返回的是int类型，并且保证返回值要与Goods02对象的属性有关
		return this.getId();
	}	
}
