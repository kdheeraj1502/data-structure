package recursion;

public class BinarySearchInRecursion {

	public static int search(int num[], int low, int high, int k) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (num[mid] == k)
			return mid;
		else if (k < num[mid])
			return search(num, low, mid - 1, k);
		else
			return search(num, mid + 1, high, k);
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(search(num, 0, num.length, 6));
	}
}
