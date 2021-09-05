package array;

import java.util.Arrays;

public class SumClosestToZero {

	public static void findMinSum(int[] arr, int n) {
		int sum, min_sum = Integer.MAX_VALUE;
		int start = 0, end = n - 1;
		int min_l = start, min_r = n - 1;
		if (n < 2) {
			System.out.println("Invalid Input");
			return;
		}
		Arrays.sort(arr, start, end);
		//   [-87, -80, -10, 1, 60, 70, 90, 85]
		while (start < end) {
			sum = arr[start] + arr[end];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				min_l = start;
				min_r = end;
			}
			if (sum < 0)
				start++;
			else
				end--;
		}

		System.out.println(" The two elements whose " + arr[min_l] + " and " + arr[min_r]);
	}

	public static void main(String[] args) {
		int[] arr = { 90, -87, 1, 60, -10, 70, -80, 85 };
		int n = arr.length;
		findMinSum(arr, n);
	}
}
