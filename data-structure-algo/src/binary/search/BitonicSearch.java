package binary.search;

public class BitonicSearch {

	public static int findEle(int num[], int val) {
		int maximaIndex = BitonicMaxima.getMaximaIndex(num);
		int result = -1;
		if (val >= num[0] && val <= num[maximaIndex]) {
			result = BinarySearch.search(num, 0, maximaIndex, val);
		} else if (val >= num[num.length - 1] && val <= num[maximaIndex])
			result = BinarySearch.search(num, maximaIndex, num.length - 1, val);
		if (result != -1) {
			return result;
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 34, 57, 74, 76, 90, 25, 15, 11, 8 };

		// 25, 15, 11, 8
		System.out.println(findEle(num, 11));
	}
}
