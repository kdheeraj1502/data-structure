package binary.search;

import java.util.Arrays;

public class ZeroSumTriplets {

	public static void zeroTriplets(int num[]) {
		Arrays.sort(num);
		int start = 0;
		int end = num.length - 1;

		for (int i = 0; i < num.length - 2; i++) {
			start = i + 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if(sum == 0) {
					System.out.println(num[i] + " + " + num[start]+ " + " + num[end] + " = " + sum);
					//break;
					start++;
					end--;
				}
				else if(sum > 0) {
					end--;
				}
				else
					start++;
			}
		}

	}

	public static void main(String[] args) {
		int num[] = { -15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82 };
		zeroTriplets(num);
	}
}
