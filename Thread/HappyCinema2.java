import java.util.ArrayList;
import java.util.List;

public class HappyCinema2 {
	/**
	 * 
	 */
	public static void main(String[] args) {
		List<Integer>available = new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(4);
		available.add(5);
		available.add(6);
		available.add(7);
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(4);
		seats2.add(5);
		seats2.add(6);
		
		LXYCinema cinema = new LXYCinema(available, "happy cinema");
		new Thread(new HappyCustomer(cinema, seats1),"lxy").start();
		new Thread(new HappyCustomer(cinema, seats2),"lyx").start();
		
		
	}

}
class HappyCustomer implements Runnable{
	LXYCinema cinema;
	List<Integer> seats;
	public HappyCustomer(LXYCinema cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	public void run() {
		synchronized (cinema) {
		boolean flag = cinema.bookTickets(seats);
		if (flag) {
			System.out.println("u got it."+Thread.currentThread().getName()+"seat:"+seats);
		}else {
			System.out.println("gg."+Thread.currentThread().getName()+".Dont have seat");
		}
	}
		
	}
}

class LXYCinema{
	List<Integer> available;
	String nameString;
	public LXYCinema(List<Integer> available, String nameString) {
		super();
		this.available = available;
		this.nameString = nameString;
	}
	
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("wecome"+this.nameString+",available seats :"+ available);
		List<Integer> copyIntegers= new ArrayList<Integer>();
		copyIntegers.addAll(available);
		copyIntegers.removeAll(seats);
		if (available.size()-copyIntegers.size()==seats.size()) {
			return false;
		}
		available = copyIntegers;
		return true;
		
	}
	
}
