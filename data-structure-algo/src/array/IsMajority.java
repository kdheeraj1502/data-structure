package array;

public class IsMajority {

	public static int findIndex(int num[], int low, int high, int val) {
		int mid = 0;
		if (high >= low)
			mid = (low + high) / 2;
		if ((mid == 0 || num[mid - 1] < val) && num[mid] == val)
			return mid;
		else if (num[mid] < val) {
			return findIndex(num, mid + 1, high, val);
		} else
			return findIndex(num, low, mid - 1, val);
	}

	public static boolean isMajority(int num[]) {
		int majority = num[num.length / 2];
		int index = findIndex(num, 0, num.length - 1, majority);
		if (((index + num.length / 2) <= (num.length - 1)) && num[index + num.length / 2] == majority)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int num[] = { 5, 5, 5, 5, 5, 5, 5, 5, 5 };

		System.out.println(isMajority(num));
	}
}
