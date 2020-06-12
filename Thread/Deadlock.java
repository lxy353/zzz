/**
 * deadlock£ºtoo much syn may cause dont Free up resources
 * waiting for each other
 * @author lxz35
 *
 */
public class Deadlock {
	public static void main(String[] args) {
		Markup grilMarkup= new Markup(1, "lxy");
		Markup grilMarkup2= new Markup(2, "lyx");
		grilMarkup.start();
		grilMarkup2.start();
		
	}

	
}
class Lipstick{
	
}
class Mirror{
	
}
class Markup extends Thread{
	static Lipstick lipstick =new Lipstick();
	static Mirror mirror = new Mirror();
	
	int choice;
	String girmaString;
	public Markup(int choice,String girmString) {
		this.choice=choice;
		this.girmaString=girmString;
	}
	public void run() {
	
		super.run();
	}
	//lock each other
	private void makeup() {
		if (choice ==0) {
			synchronized (lipstick) {//lock for lipstick
				System.out.println(this.girmaString+"get lipstick");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*synchronized (mirror) {
					System.out.println(this.girmaString+"Mirror");
					
				}*/
				
			}
			synchronized (mirror) {
				System.out.println(this.girmaString+"Mirror");
				
			}
		}else {	
			synchronized (mirror) {//lock for mirror
				System.out.println(this.girmaString+"Mirror");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*synchronized (lipstick) {
					System.out.println(this.girmaString+"get lipstick");
					
				}*/	
			}
			synchronized (lipstick) {
				System.out.println(this.girmaString+"get lipstick");
				
			}
			
		}
		
	
}
}
