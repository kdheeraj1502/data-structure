package array;

import java.util.Arrays;

public class CheckReverse {

	public static boolean checkReverse(int arr[], int n) {
		if (n == 1) {
			return true;
		}
		// Find first increasing part
		int i;
		for (i = 1; arr[i - 1] < arr[i] && i < n; i++)
			;
		if (i == n) {
			return true;
		}

		// Find reversed part
		int j = i;
		while (j < n && arr[j] < arr[j - 1]) {
			if (i > 1 && arr[j] < arr[i - 2]) {
				return false;
			}
			j++;
		}

		if (j == n) {
			return true;
		}

		// Find last increasing part
		int k = j;

		// To handle cases like {1,2,3,4,20,9,16,17}
		if (arr[k] < arr[i - 1]) {
			return false;
		}

		while (k > 1 && k < n) {
			if (arr[k] < arr[k - 1]) {
				return false;
			}
			k++;
		}
		return true;
	}

	public static boolean checkReverse_sort(int num[]) {
		int temp[] = num.clone();
		int front = 0;
		int back = num.length - 1;
		Arrays.sort(temp);
		// 1, 5, 7, 10, 9, 6
		// 1, 5, 6, 7, 9, 10
		// 1, 5, 7, 10, 9, 8
		// 1, 5, 7, 8, 9, 10
		for (int i = 0; i < num.length; i++) {
			if (temp[i] != num[i]) {
				front = i;
				break;
			}
		}

		for (int i = num.length - 1; i >= 0; i--) {
			if (temp[i] != num[i]) {
				back = i;
				break;
			}
		}

		if (front >= back) {
			return true;
		}

		do {
			front++;
			if (num[front - 1] < num[front]) {
				return false;
			}
		} while (front != back);
		return true;
	}

	public static boolean checkReverse_sort_self(int num[]) {
		int temp[] = num.clone();
		int front = 0;
		int back = num.length - 1;
		Arrays.sort(temp);
		for (int i = 0; i < num.length; i++) {
			if (temp[i] != num[i]) {
				front = i;
				break;
			}
		}
		for (int i = num.length - 1; i >= 0; i--) {
			if (temp[i] != num[i]) {
				back = i;
				break;
			}
		}
		if (front >= back)
			return true;
		do {
			front++;
			if (num[front - 1] < num[front]) {
				return false;
			}
		} while (front != back);
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 7, 10, 9, 6 };
		int n = arr.length;
		System.out.println(checkReverse_sort_self(arr));
	}
}
