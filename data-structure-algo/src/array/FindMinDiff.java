package array;

import java.util.Arrays;

public class FindMinDiff {

	public static int[] findMinDiff(int num[]) {
		Arrays.sort(num);
		int diff = Integer.MAX_VALUE;
		int result[] = new int[2];
		for(int i = 0; i < num.length - 1; i++) {
			if((num[i + 1] - num[i]) < diff) {
				diff = num[i + 1] - num[i];
				result[0] = i;
				result[1] = i + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 5, 2, 7, 9, 1, 0, 8 };
		System.out.println(Arrays.toString(findMinDiff(num)));
	}
}
