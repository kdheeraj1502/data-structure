package array;

public class OccuranceCountInSortedArray {

	public static int findLastIndex(int num[], int key) {

		int start = 0;
		int end = num.length - 1;
		int mid = (start + end) / 2;
		int found = 0;
		//2, 3, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 9
		while (start <= end) {
			mid = (start + end) / 2;
			if (num[mid] == key && (mid == end || num[mid + 1] != key)) {
				found = 1;
				break;
			} if (num[mid] > key) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		if (found == 1) {
			return mid;
		} else
			return -1;
	}

	public static int findFirstIndex(int num[], int key) {
		int start = 0;
		int end = num.length - 1;
		int mid = (start + end) / 2;
		int found = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if ((num[mid] == key && (mid == 0 || num[mid] > num[mid - 1]))) {
				found = 1;
				break;
			} else if (num[mid] < key) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		if (found == 1) {
			return mid;
		} else
			return -1;
	}

	public static int occuranceCount(int num[], int key) {
		int first = findFirstIndex(num, key);
		int last = findLastIndex(num, key);
		return last - first + 1;
	}

	public static void main(String[] args) {
		int num[] = { 2, 3, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 9 };
		System.out.println(occuranceCount(num, 6));
	}
}
