/*
 * 模拟咖啡
 * 抽象组件：需要装饰的抽象对象 一般是接口或抽象父类
 * 具体组件 需要装饰的对象
 * 抽象装饰类 包含了对抽象组件的应用以及装饰着共有的方法
 * 具体装饰类被装饰的对象
 */
public class DecorateTest2 {
	public static void main(String[] args) {
		Drink coffeeDrink= new Coffee();
		Drink milkDrink = new Milk(coffeeDrink);
		System.out.println("cost:"+milkDrink.cost());
		System.out.println("name:"+milkDrink.info());
		
	}
}
//抽象组件
interface Drink{
	double cost();
	String info();
}
//具体组件 
class Coffee implements Drink{
	private String nameString= "coffee";
	public double cost() {
		return 10;
	}
	public String info() {
		return nameString;
	}
}

//抽象装饰类
abstract class Decorate implements Drink{
	//对抽象组件的引用
	private Drink drink;
	public Decorate(Drink drink) {
		this.drink=drink;
	}
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}
	public String info() {
			return this.drink.info();
		}
	}

//具体装饰类被装饰的对象
class Milk extends Decorate{
	public Milk (Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"add milk";
	}
	
}
