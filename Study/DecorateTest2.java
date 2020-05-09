/*
 * ģ�⿧��
 * �����������Ҫװ�εĳ������ һ���ǽӿڻ������
 * ������� ��Ҫװ�εĶ���
 * ����װ���� �����˶Գ��������Ӧ���Լ�װ���Ź��еķ���
 * ����װ���౻װ�εĶ���
 */
public class DecorateTest2 {
	public static void main(String[] args) {
		Drink coffeeDrink= new Coffee();
		Drink milkDrink = new Milk(coffeeDrink);
		System.out.println("cost:"+milkDrink.cost());
		System.out.println("name:"+milkDrink.info());
		
	}
}
//�������
interface Drink{
	double cost();
	String info();
}
//������� 
class Coffee implements Drink{
	private String nameString= "coffee";
	public double cost() {
		return 10;
	}
	public String info() {
		return nameString;
	}
}

//����װ����
abstract class Decorate implements Drink{
	//�Գ������������
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

//����װ���౻װ�εĶ���
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
