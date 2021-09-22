package binary.search;

import java.util.Arrays;

public class AbPlusCTriplet {

	public static void ABPlusC(int num[]) {
		Arrays.sort(num);
		int start;
		int end = num.length - 1;
		for(int i = num.length - 1; i > 1; i--) {
			start = 0;
			end = i - 1;
			int c = num[i];
			while(start < end) {
				int sum = num[start] + num[end];
				if(sum == c) {
					System.out.println(num[i] + " = " + num[start] + " + " +  num[end]);
					start++;
					end--;
				}
				else if(sum > c) {
					end--;
				}
				else
					start++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int num[] = { -15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82 };
		ABPlusC(num);
	}
}
