package array;

public class Search0_1 {

	public static int search0_1(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (num[mid] == 1 && (mid == 0 || num[mid - 1] < num[mid])) {
				return mid;
			} else if (num[mid] < 1) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		return mid;
	}

	public static int search0_1_last_index(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (num[mid] == 1 && (mid == num.length - 1)) {
				return mid;
			} else if (num[mid] > 1) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return mid;
	}

	public static void main(String[] args) {
		int num[] = { 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		System.out.println(search0_1(num));
		System.out.println(search0_1_last_index(num));
	}
}
