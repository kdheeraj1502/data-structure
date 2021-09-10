package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxElementInArray {

	public static int findMax(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		int middle = -1;
		// 13, 24, 65, 101, 1132
		// 13, 14, 15, 1, 2, 3, 4
		while (low <= high) {
			middle = low + (high - low) / 2;
			if ((middle == arr.length - 1) && arr[middle] > arr[middle - 1]) {
				return arr[middle];
			}
			if (middle < arr.length - 1 && arr[middle] > arr[middle + 1]) {
				return arr[middle];
			}
			if (arr[low] > arr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static int findMaxIndex(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		int middle = -1;
		// 13, 24, 65, 101, 1132
		// 13, 14, 15, 1, 2, 3, 4
		while (low <= high) {
			middle = low + (high - low) / 2;
			if ((middle == arr.length - 1) && arr[middle] > arr[middle - 1]) {
				return middle;
			}
			if (middle < arr.length - 1 && arr[middle] > arr[middle + 1]) {
				return middle;
			}
			if (arr[low] > arr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] num = { 3, 4, 5, 1, 2 };

		System.out.println(
				"Array is : " + Arrays.toString(num) + " Max is " + findMax(num) + " Index is : " + findMaxIndex(num));
	}
}
