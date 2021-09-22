package binary.search;

public class MaxInRotatedArray {

	public static int maxInRotatedArray(int num[], int low, int high) {
		int max = -1;
		int mid = low + (high - low) / 2;
		if (high == low)
			return num[low];
		if ((mid == 0 || num[mid] > num[mid + 1]) && (mid == num.length - 1 || num[mid] > num[mid - 1])) {
			return num[mid];
		} else if (num[low] > num[mid]) {
			max = maxInRotatedArray(num, low, mid - 1);
		} else {
			max = maxInRotatedArray(num, mid + 1, high);
		}
		return max;
	}

	public static void main(String[] args) {
		int num[] = { 90, 8, 11, 15, 25, 34, 57, 74, 76 };
		System.out.println(maxInRotatedArray(num, 0, num.length - 1));
	}
}
