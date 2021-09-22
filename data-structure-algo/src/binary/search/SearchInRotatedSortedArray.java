package binary.search;

public class SearchInRotatedSortedArray {

	public static int search(int num[], int low, int high, int val) {
		int maximaIdex = getMaxIndex(num, 0, num.length - 1);
		if(num[maximaIdex] == val) return maximaIdex;
		int index = -1;
		if (num[low] <= val && val < num[maximaIdex]) {
			index = BinarySearch.search(num, 0, maximaIdex, val);
		} else {
			index = BinarySearch.search(num, maximaIdex + 1, high, val);
		}
		return index;
	}

	public static int getMaxIndex(int num[], int low, int high) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2;
		int maxIndex = -1;
		if ((mid == 0 || num[mid] > num[mid - 1]) && (mid == num.length - 1 || num[mid] > num[mid + 1])) {
			maxIndex = mid;
		} else if (num[low] > num[mid]) {
			maxIndex = getMaxIndex(num, low, mid - 1);
		} else {
			maxIndex = getMaxIndex(num, mid + 1, high);
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int num[] = { 74, 76, 90, 8, 11, 15, 25, 34, 57 };
		for(int in : num) {
			System.out.println(search(num, 0, num.length - 1, in));
		}
	}
}
