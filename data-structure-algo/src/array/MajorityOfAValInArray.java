package array;

public class MajorityOfAValInArray {

	public static int firstIndex(int num[], int low, int high, int val) {

		int mid = (low + high) / 2;
		if ((mid == 0 || num[num.length - 1] < val) && num[mid] == val) {
			return mid;
		} else if (num[mid] < val) {
			return firstIndex(num, low, mid - 1, val);
		} else {
			return firstIndex(num, low, mid - 1, val);
		}
	}

	public static boolean isMajority(int num[]) {
		int i;
		int majority = num[num.length / 2];
		i = firstIndex(num, 0, num.length, majority);
		return true;
	}
}
