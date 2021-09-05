package array;

import java.util.Arrays;

public class APlusBEqualsCTriplet {

	public static void main(String[] args) {
		
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0, 12 };
		findTriplets(num, num.length);
	}

	private static void findTriplets(int[] num, int length) {
		Arrays.sort(num);
		for(int i = num.length - 1; i > 0; i--) {
			int start = i - 1;
			int end = 0;
			int c = num[i];
			while(start > end) {
				int a = num[start];
				int b = num[end];
				int sum = a + b;
				if(c == sum) {
					System.out.println("Numbers are " + c + " = " + a + " + " + b);
					start--;
					end++;
				}
				if(c > sum)
					end++;
				else
					start--;
			}
		}
	}
}
