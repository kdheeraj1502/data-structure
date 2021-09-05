package array;

import java.util.*;

public class FindDiffPair {

	public static int[] findDiffPair(int num[], int val) {
		int result[] = new int[2];
		Arrays.sort(num);
		int first = 0;
		int second = 0;
		int diff;
		//[1, 2, 5, 7, 8, 9]
		while(first < num.length && second < num.length) {
			diff = Math.abs(num[first] - num[second]);
			if(diff == val) {
				result[0] = num[first];
				result[1] = num[second];
				return result;
			}
			else if (diff > val) {
				first++;
			}
			else
				second++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int num[] = { 5, 2, 7, 9, 1, 8 };
		System.out.println(Arrays.toString(findDiffPair(num, 2)));
	}
}
