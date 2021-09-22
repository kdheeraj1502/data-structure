package binary.search;

import java.util.Arrays;

public class TwoEleSumToZero {

	public static int[] minAbsSumPair(int num[], int n) {
		int currSum, min_sum = Integer.MAX_VALUE;
		int start = 0, end = n - 1;
		int minLeft = start, minRight = n - 1;
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		int result[] = new int[2];
		while (start < end) {
			currSum = num[start] + num[end];
			if (Math.abs(currSum) < Math.abs(min_sum)) {
				min_sum = currSum;
				minLeft = start;
				minRight = end;
			}
			if (currSum > 0)
				end--;
			else
				start++;
		}
		result[0] = num[minLeft];
		result[1] = num[minRight];
		return result;
	}

	public static void main(String[] args) {
		int num[] = { -15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82 };
		System.out.println(Arrays.toString(minAbsSumPair(num, num.length)));
	}
}
