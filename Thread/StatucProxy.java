package com.lxy;
/**
 * 静态代理
 * 公共接口：
 * 1.真实接口
 * 2.代理接口
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
//代理角色
class WeddingCompany implements Marry{
	//真实角色
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