package binary.search;

import java.util.Arrays;

public class ClosetToTheNum {

	public static int closetToNum(int num[], int val) {
		int start = 0;
		int end = num.length - 1;
		int diff = Integer.MAX_VALUE;
		int result = -1;
		Arrays.sort(num);
		//[1, 1, 3, 7, 8, 9, 10, 11, 15, 25, 34, 57, 74, 76, 90]
		while (start <= end) {
			int mid = (start + end) / 2;
			int min = val - (num[mid]);
			if (diff > Math.abs(min)) {
				diff = Math.abs(min);
				result = mid;
			}
			if (min == num[mid])
				break;
			else if (min > 0) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		return num[result];
	}

	public static void main(String[] args) {
		int num[] = { 8, 11, 10, 9, 7, 15, 1, 25, 34, 1, 57, 3, 74, 76, 90 };
		System.out.println(closetToNum(num, 85));
	}
}
