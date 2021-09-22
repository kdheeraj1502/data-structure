package binary.search;

import java.util.Arrays;

public class FindDiffPair {
	
	public static int[] findDiff(int num[], int val) {
		int start = 0, end = num.length - 1;
		Arrays.sort(num);
		int diff ;
		int result[] = new int[2];
		while (start < end) {
			diff = Math.abs(num[start] - num[end]);
			if (diff  ==  Math.abs(val)) {
				result[0] = num[start];
				result[1] = num[end];
			}
			if (diff > val)
				start++;
			else
				end--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int num[] = {1, 8, 30, 40, 100};;
		System.out.println(Arrays.toString(findDiff(num, -60)));
	}

}
