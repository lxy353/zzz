import java.util.Arrays;

public class Q3 {

	public static void main(String[] args) {
		int[] randomNum = new int[10];					
		for(int i = 0;i < randomNum.length;i++) {
			randomNum[i] = (int)(30 * Math.random());
		}
		
		System.out.println(Arrays.toString(randomNum));
		
		int temp = 0;
		for(int i = 0;i < randomNum.length / 2;i++) {		
			temp = randomNum[i];
			randomNum[i] = randomNum[randomNum.length - 1 - i];
			randomNum[randomNum.length - 1 - i] = temp;
			System.out.println(Arrays.toString(randomNum));		
		}
		System.out.println(Arrays.toString(randomNum));		
		
		
	}
}

	



