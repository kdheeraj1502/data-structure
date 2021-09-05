package array;

import java.util.Arrays;

public class SumPairRestArray {

	public static boolean findSum(int[] num) {
		int result[] = new int[2];
		Arrays.sort(num);
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}
		int value = total / 2;
		int start = 0;
		int end = num.length - 1;
		while (start < end) {
			int curr = num[start] + num[end];
			if (value == curr) {
				result[0] = num[start];
				result[1] = num[end];
				System.out.println(Arrays.toString(result));
				return true;
			} else if (curr < value)
				start++;
			else
				end--;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int num[] = { 87, 33, 27, 12, 9, 23, 27, 10};
		System.out.println(findSum(num));
	}
}
