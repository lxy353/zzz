/*
 * test java.util.Arrays  tool class
 */
import java.util.Arrays;
public class TestArrays {
	public static void main (String[] args) {
		int[]a = {10,20,30};
		System.out.println(a);
		
		System.out.println(Arrays.toString(a));
		
//		 int[] a = {1,2,323,23,543,12,59};
//	     System.out.println(Arrays.toString(a));
//	     Arrays.sort(a);
//       System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 30));
//		
	}

}
