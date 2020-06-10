
public class HappyCinema {
	/**
	 * 
	 */
	public static void main(String[] args) {
		Cinema cinema = new Cinema(2, "happy cinema");
		new Thread(new Customer(cinema, 2),"lxy").start();
		new Thread(new Customer(cinema, 1),"lyx").start();
		
		
	}

}
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	public void run() {
		synchronized (cinema) {
		boolean flag = cinema.bookTickets(seats);
		if (flag) {
			System.out.println("u got it"+Thread.currentThread().getName()+"seat:"+seats);
		}else {
			System.out.println("gg"+Thread.currentThread().getName()+"Dont have seat");
		}
	}
		
	}
}

class Cinema{
	int available;
	String nameString;
	public Cinema(int available, String nameString) {
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
	
}
