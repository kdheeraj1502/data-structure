package array;

public class ClosestNumberSortedArray {

	public static int findClosetNumber(int num[], int key) {
		int start = 0;
		int end = num.length - 1;
		int numDist = Integer.MAX_VALUE;
		int output = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if(key == num[mid])
				break;
			if(numDist > Math.abs(num[mid] - key)) {
				numDist = Math.abs(num[mid] - key);
				output = num[mid];
			}
			else if(num[mid] < key) {
				start = mid + 1;
			}
			else
				end = mid - 1;
		}
		return output;
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 8, 9, 10, 10, 12, 19 };
		System.out.println(findClosetNumber(num, 16));
	}
}
