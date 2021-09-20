package array;

import java.util.Arrays;

public class SortByOrderAndSortRemaining {

	public static void sortAccording(int A1[], int A2[]) {
		int m = A1.length;
		int n = A2.length;
		int temp[] = new int[m], visited[] = new int[m];
		for (int i = 0; i < m; i++) {
			temp[i] = A1[i];
			visited[i] = 0;
		}
		Arrays.sort(temp);
		int index = 0;
		for (int i = 0; i < n; i++) {
			int f = first(temp, 0, m - 1, A2[i], m);
			if (f == -1)
				continue;
			for (int j = f; (j < m && temp[j] == A2[i]); j++) {
				A1[index++] = temp[j];
				visited[j] = 1;
			}
		}

// Now copy all items of temp[] which are
// not present in A2[]
		for (int i = 0; i < m; i++)
			if (visited[i] == 0)
				A1[index++] = temp[i];
	}

	static int first(int arr[], int low, int high, int x, int n) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			if (x > arr[mid])
				return first(arr, (mid + 1), high, x, n);
			return first(arr, low, (mid - 1), x, n);
		}
		return -1;
	}

	public static void main(String[] args) {
		int num[] = { 898, 1, 13422, 898, 3, 7, 1, 879, 13422, 6, 8, 8 };
		int order[] = { 13422, 1, 898, 3 };
		sortAccording(num, order);
		System.out.println(Arrays.toString(num));
	}
}
