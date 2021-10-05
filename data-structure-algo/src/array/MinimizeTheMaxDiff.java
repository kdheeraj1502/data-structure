package array;

import java.util.*;

public class MinimizeTheMaxDiff {

	public static int getMinDiff(int num[], int n, int k) {
		Arrays.sort(num);
		int min, max;
		//[1, 4, 4, 5, 5, 6, 7, 7, 8, 9]
		int r = Math.abs(num[0] - num[n - 1]);
		for (int i = 1; i < n; i++) {
			if (num[i] >= k) {
				max = Math.max(num[i - 1] + k, num[n - 1] - k);
				min = Math.min(num[0] + k, num[i] - k);
				r = Math.min(r, max - min);

			}
		}

		return r;
	}

	public static void main(String args[]) {
		int k = 5;
		int num[] = { 8, 1, 5, 4, 7, 5, 7, 9, 4, 6 };
		System.out.println(getMinDiff(num, num.length, k));
	}
}