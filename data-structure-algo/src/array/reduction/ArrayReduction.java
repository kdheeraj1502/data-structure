package array.reduction;

import java.util.Arrays;

public class ArrayReduction {

	public static void arrayReduction(int num[]) {
		Arrays.sort(num);
		int reduction = num[0];
		int count = 1;
		for(int i = 0; i < num.length; i++) {
			if(num[i] - reduction > 0) {
				System.out.println(num.length - i);
				reduction = num[i];
				count += 1;
			}
		}
		System.out.println("Reduction count " + count);
	}
	
	public static void arrayReductionBook(int num[]) {
		int size = num.length;
		Arrays.sort(num);
		int count = 1;
		int reduction = num[0];
		
		for(int i = 0; i < num.length; i++) {
			if(num[i] - reduction > 0) {
				System.out.println(size - i);
				reduction = num[i];
				count += 1;
			}
		}
		System.out.println("Total num of reduction " + count);
	}
}
