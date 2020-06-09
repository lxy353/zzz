
/**
 * Thread unsafe: GET MONEY
 * @author lxz35
 *
 */
public class SynBlockTest3 {
	public static void main(String[] args) {
		SafeAccount account = new SafeAccount(100, "lxy");
		SafeDrawing youDrawing = new SafeDrawing(account, 80, "me");
		SafeDrawing wDrawing = new SafeDrawing(account, 90, "you");
		youDrawing.start();
		wDrawing.start();
	}
}

class SafeAccount{
	int money;
	String nameString;
	public SafeAccount(int money, String nameString) {
		super();
		this.money = money;
		this.nameString = nameString;
	}
}
//thread safe
class SafeDrawing extends Thread{
	SafeAccount account;
	int drawingMoney;
	int packetTotal;
	public SafeDrawing(SafeAccount account, int drawingMoney, String nameString) {
		super(nameString);
		this.account=account;
		this.drawingMoney = drawingMoney;
		this.packetTotal = packetTotal;
	}
	@Override
	public void run() {
		test();
	}
	// should synchronized account
	public synchronized void test() {
		synchronized (account) {
		if (account.money-drawingMoney<0) {
			return;	
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		packetTotal+= drawingMoney;
		System.out.println(this.getName()+"Account money:"+account.money);
		System.out.println(this.getName()+"Packet money:"+packetTotal);
		
		}
	}
}
