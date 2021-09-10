package array;

public class SearchInRotatedArray {

	public static int searchInRotatedArray(int num[], int key) {
		int maxIndex = MaxElementInArray.findMaxIndex(num);
		int index = -1;
		if (num[0] <= key && key <= num[maxIndex]) {
			index = searchFirst(num, 0, maxIndex, key);
		} else {
			index = searchFirst(num, maxIndex + 1, num.length, key);
		}
		if (index != -1) {
			return index;
		} else
			return -1;
	}

	public static int searchFirst(int num[], int start, int end, int key) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (num[mid] == key)
				return mid;
			else if (num[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int num[] = { 13, 14, 15, 1, 2, 3, 4 };
		for(Integer in : num) {
			System.out.println(searchInRotatedArray(num, in));
		}
	}
}
