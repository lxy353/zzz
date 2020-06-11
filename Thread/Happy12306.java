
public class Happy12306 {
	public static void main(String[] args) {
		Web123 cinema = new Web123(4, "happy cinema");
		new Passenger(cinema, "lxy",2).start();
		new Passenger(cinema, "lxy",1).start();
		
		
		
	}

}
class Passenger extends Thread{
	Cinema cinema;
	int seats;
	public Passenger( Runnable target,String name,int seats) {
		super(target,name);
		this.seats=seats;
		
	}
	
}
class Web123 implements Runnable{
	int available;
	String nameString;
	public Web123(int available, String nameString) {
		super();
		this.available = available;
		this.nameString = nameString;
	}
	public boolean bookTickets(int seats) {
		System.out.println("available seats :"+ available);
		if (seats>available) {
			return false;
			
		}
		available-=seats;
		return true;
		
	}

	@Override
	public void run() {

		Passenger passenger = (Passenger)Thread.currentThread();
		boolean flag = this.bookTickets(passenger.seats);
		if (flag) {
			System.out.println("u got it"+Thread.currentThread().getName()+"seat:"+passenger.seats);
		}else {
			System.out.println("gg"+Thread.currentThread().getName()+"Dont have seat");
		}
	}
		
	
		
	}
	

