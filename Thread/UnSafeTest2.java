package com.lxy;
/**
 * Thread unsafe: GET MONEY
 * @author lxz35
 *
 */
public class UnSafeTest2 {
	public static void main(String[] args) {
		Account account = new Account(100, "lxy");
		Drawing youDrawing = new Drawing(account, 80, "me");
		Drawing wDrawing = new Drawing(account, 90, "you");
		youDrawing.start();
		wDrawing.start();
	}
	
}

class Account{
	int money;
	String nameString;
	public Account(int money, String nameString) {
		super();
		this.money = money;
		this.nameString = nameString;
	}
}

class Drawing extends Thread{
	Account account;
	int drawingMoney;
	int packetTotal;
	public Drawing(Account account, int drawingMoney, String nameString) {
		super(nameString);
		this.drawingMoney = drawingMoney;
		this.packetTotal = packetTotal;
	}
	@Override
	public void run() {
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
