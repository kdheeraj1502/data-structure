package backtracking;

import java.util.*;

public class CountOfSubArray {

	public static int subSequence(int arr[]) {
		List<List<Integer>> result = new ArrayList<>();
		subSequence(result, arr, 0);
		System.out.println(result);
		return result.size();
	}

	public static void subSequence(List<List<Integer>> result, int arr[], int index) {
		if (index >= arr.length)
			return;
		// 5, 1, 2, 3, 4
		List<Integer> temp = new ArrayList<>();
		for (int i = index; i < arr.length; i++) {
			temp.add(arr[i]);
			if (isEven(temp)) {
				result.add(new ArrayList<>(temp));
				System.out.println(result);
				subSequence(result, arr, i + 1);
			} else {
				if (temp.size() > 0)
					temp.remove(0);
			}
		}
	}

	private static boolean isEven(List<Integer> curr) {
		int mul = 1;
		for (int in : curr) {
			mul *= in;
		}
		if (mul % 2 == 0) {
			return false;
		}
		return true;
	}

	public static int numOfSubarrays(int[] arr) {
		int even = 1; // counting 0 in even
		int odd = 0;
		long ans = 0;
		int sum = 0;
		// 1, 3, 5   // odd sum
		// we need to count the number of odd and even sums before current position
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum % 2 != 0) {
				ans += odd;
				even++;
			} else {
				ans += even;
				even++;
			}
		}
		return (int) (ans % 1000000007);
	}
	
	public static int numOfSubarraysForEven(int[] arr) {
		int even = 1; // counting 0 in even
		int odd = 0;
		long ans = 0;
		int sum = 0;
		// 1, 3, 5   // odd sum
		// we need to count the number of odd and even sums before current position
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum % 2 != 0) {
				ans += odd;
				odd++;
			} else {
				ans += even;
				even++;
			}
		}
		return (int) (ans % 1000000007);
	}

	public static void main(String[] args) {
		// int arr[] = { 5, 1, 2, 3, 4 };
		// int arr[] = {12, 15, 7, 3, 25, 6, 2, 1, 1, 7};
		int arr[] = { 2, 1, 6, 8, 10 };
		// 15., 7, 3., 25., 1, 1., 7. => 7
		// 15, 7.
		// 7, 3.
		// 3, 25.
		// 1, 1.
		// 1, 7.
		// 15, 7, 3.
		// 7, 3, 25.
		// 1, 1, 7.
		// 15, 7, 3, 25.
		// [[1], [1, 1], [3], [7], [1, 1, 7], [1, 7], [15, 7, 3], [15], [3, 25], [25],
		// [15, 7], [15, 7, 3, 25], [7, 3, 25], [7, 3]]

		// System.out.println(subSequence(arr));

		System.out.println(numOfSubarrays(arr));
	}
}
