package array;

import java.util.Arrays;

public class SumOfPairIsEqualToRestOfArray {

	public static int[] findPair(int num[]) {
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}
		int rest = total / 2;
		int start = 0;
		int end = num.length - 1;
		int curr = 0;
		int result[] = new int[2];
		while (start < end) {
			curr = num[start] + num[end];
			if (curr == rest) {
				result[0] = num[start];
				result[1] = num[end];
			}
			if (curr > rest) {
				end--;
			} else
				start++;
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 2, 3, 4, 7, 7, 9 };
		System.out.println(Arrays.toString(findPair(num)));
	}
}
