package binary.search;

import java.util.Arrays;

public class FindFloor {

	public static int findFloor(int num[], int val) {
		int start = 0;
		int end = num.length - 1;
		Arrays.sort(num);
		// [1, 1, 3, 7, 8, 9, 10, 11, 15, 25, 34, 57, 74, 76, 90]
		int floor = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (num[mid] == val || val > num[mid] && (mid == num.length - 1 || val < num[mid + 1])) {
				floor = num[mid];
				break;
			} else if (val > num[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return floor;
	}

	public static void main(String[] args) {
		int num[] = { 8, 11, 10, 9, 7, 15, 1, 25, 34, 1, 57, 3, 74, 76, 90 };
		int num1[] = { 10, 12, 14, 19, 17, 115, 81, 45, 41, 1, 27, 23, 73, 71, 89 };
		// System.out.println(findFloor(num, 10));
		System.out.print("[ ");
		for (int in : num1) {
			System.out.print(in + " :: " + findFloor(num, in) + ", ");
		}
		System.out.print(" ]");
	}
}
