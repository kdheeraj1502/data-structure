package array;

public class FindCeil {

	public static int findCeil(int num[], int key) {
		int start = 0;
		int end = num.length;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (num[mid] == key || (num[mid] > key && (mid == 0 || num[mid - 1] < key))) {
				return mid;
			} else if (num[mid] < key) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 8, 9, 10, 10, 12, 19 };
		System.out.println(findCeil(num, 3));
	}
}
