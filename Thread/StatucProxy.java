package com.lxy;
/**
 * ��̬����
 * �����ӿڣ�
 * 1.��ʵ�ӿ�
 * 2.����ӿ�
 * @author lxz35
 *
 */
public class StatucProxy {
	public static void main(String[] args) {
		new WeddingCompany(new Your()).happyMary();
		//new Thread(duixiang).start;
	}

}
interface Marry{
	void happyMarry();
}
class Your implements Marry{
	public void happyMarry() {
		// TODO Auto-generated method stub
	System.out.println("gongxi");	
	}
}
//�����ɫ
class WeddingCompany implements Marry{
	//��ʵ��ɫ
	private Marry targetMarry;
	public WeddingCompany(Marry targetMarry) {
		this.targetMarry=targetMarry;
		
	}
	public void happyMary() {
		ready();
		this.targetMarry.happyMarry();
		after();
		
	}
	private void ready() {
		System.out.println("start");
		
	}
	private void after() {
		// TODO Auto-generated method stub
		System.out.println("end");

	}
	public void happyMarry() {
		// TODO Auto-generated method stub
		
	}
}