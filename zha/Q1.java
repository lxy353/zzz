import java.util.Scanner;

public class Q1 {
	public static void  main (String[] args) throws IllegalScoreException {
		System.out.println("Give me a score");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
	    if (score< 0|| score >=100) {
	            throw new IllegalScoreException("No range");
	        }  
	    }
}
class IllegalScoreException extends Exception {
	  
	public IllegalScoreException() {
    }
   
    public IllegalScoreException(String message) {
        super(message);
    }
}
