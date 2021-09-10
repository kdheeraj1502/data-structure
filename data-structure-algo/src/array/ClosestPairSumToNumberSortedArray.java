package array;

import java.util.Arrays;

public class ClosestPairSumToNumberSortedArray {

	public static void main(String[] args) {
		int num[] = { 1, 2, 8, 9, 10, 10, 12, 19 };
		System.out.println(Arrays.toString(findClosetNumber(num, 25)));
		System.out.println(Arrays.toString(findClosetNumberSelf(num, 25)));
	}

	public static int[] findClosetNumber(int num[], int key) {
		int start = 0;
		int first = 0;
		int second = 0;
		int end = num.length - 1;
		int diff = Integer.MAX_VALUE;
		int curr;
		int result[] = new int[2];
		while(start < end) {
			curr = key - (num[start] + num[end]);
			if(Math.abs(curr) < diff) {
				diff = Math.abs(curr);
				first  = num[start];
				second = num[end];
				result[0] = first;
				result[1] = second;
			}
			if(curr == 0) {
				break;
			}
			else if(curr > 0) {
				start++;
			}
			else
				end--;
		}
		return result;
	}
	
	public static int[] findClosetNumberSelf(int num[], int key) {
		int start = 0;
		int end = num.length - 1;
		int curr = 0;
		int diff = Integer.MAX_VALUE;
		int result[] = new int[2];
		while(start < end) {
			curr = key - (num[start] + num[end]);
			if(Math.abs(curr) < diff) {
				result[0] = num[start];
				result[1] = num[end];
				diff = Math.abs(curr);
			}
			else if(curr > 0) {
				start++;
			}
			else
				end--;
		}
		return result;
	}
}
