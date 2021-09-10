package bitonic;

import java.util.*;

public class SearchInBitonicArray {
	

	public static int getMaxEleIndex(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) / 2;
			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
				break;
			} else if (num[mid] < num[mid + 1] && num[mid] > num[mid - 1]) {
				start = mid + 1;
			} else if (num[mid] < num[mid - 1] && num[mid] > num[mid + 1]) {
				end = mid - 1;
			} else
				break;
		}
		return mid;
	}

	public static int seacrhVal(int num[], int val) {
		int start = 0;
		int end = num.length - 1;
		int maxIndex = getMaxEleIndex(num);
		int index = binarySearch(num, start, maxIndex, val, true);
		if (index != -1)
			return index;
		else
			return binarySearch(num, maxIndex + 1, end, val, false);
	}

	public static int binarySearch(int num[], int low, int high, int val, boolean status) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (val == num[mid])
				return mid;
			else if (val > num[mid]) {
				if(status)
					low = mid + 1;
				else
					high = mid - 1;
			} else {
				if(status) {
					high = mid - 1;
				}
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int num[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		for(Integer in : num) {
			System.out.println(seacrhVal(num, in));
		}
	}
}
