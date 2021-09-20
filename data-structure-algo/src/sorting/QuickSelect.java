package sorting;

public class QuickSelect {

	public static int partition(int[] arr, int low, int high, int pivot) {
		System.out.println("Pivot is " + pivot);
		int i = low;
		int j = low;
		while (i <= high) {
			if (arr[i] <= pivot) {
				Main.swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
		System.out.println("Pivot index is " + (j - 1));
		return j - 1;
	}

	public static int quickSelect(int num[], int low, int high, int k) {
		int pivot = num[high];
		int result = -1;
		int pi = partition(num, low, high, pivot);
		if (k > pi) {
			result = quickSelect(num, pi + 1, high, k);
		} else if (k < pi) {
			result = quickSelect(num, low, pi - 1, k);
		} else if (k == pi) {
			result = num[pi];
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 1, 3, 2, 4, 8, 5 };
		System.out.println(quickSelect(num, 0, num.length - 1, 2));
	}
}
