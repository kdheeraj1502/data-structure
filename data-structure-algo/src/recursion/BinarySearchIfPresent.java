package recursion;

public class BinarySearchIfPresent {

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearchRecursion(num, 6));
	}

	private static int binarySearchRecursion(int[] num, int k) {
		return binarySearchRecursion(num, 0, num.length - 1, k);
	}

	private static int binarySearchRecursion(int[] num, int start, int end, int k) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (num[mid] == k)
			return mid;
		else if (k > num[mid]) {
			return binarySearchRecursion(num, mid + 1, end, k);
		} else {
			return binarySearchRecursion(num, start, mid - 1, k);
		}
	}
}
