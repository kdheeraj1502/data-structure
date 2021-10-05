package array;

import java.util.Arrays;

public class SmallestSubArraySumToANum {

	public static int findSmallestSubarrayLen(int[] num, int k) {

		int sum = 0;
		int len = Integer.MAX_VALUE;
		int left = 0;

		int result[] = new int[2];
		int currMin = 0;
		int min = Integer.MAX_VALUE;
		for (int right = 0; right < num.length; right++) {
			sum += num[right];

			while (sum > k && left <= right) {
				currMin = sum;
				//if (min > currMin) {
					//min = currMin;
					len = Math.min(len, (right - left + 1));
					result[0] = left;
					result[1] = right;
			//	}
				sum -= num[left++];
			}
		}
		if (len == Integer.MAX_VALUE)
			return 0;
		return len;
	}

	public static void main(String[] args) {
		int[] A = { 6, 3, 4, 5, 4, 3, 7, 9 };
		int k = 16;
		int len = findSmallestSubarrayLen(A, k);

		System.out.println((len));

		if (len != Integer.MAX_VALUE) {
			System.out.print("The smallest subarray length is " + len);
		} else {
			System.out.print("No subarray exists");
		}

	}
}
