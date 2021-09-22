package binary.search;

import java.util.Arrays;

public class SumPairEqualRestArray {

	public static int[] findPair(int num[]) {
		int result[] = new int[2];
		int sum = 0;
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		int target = sum / 2;
		int start = 0;
		int end = num.length - 1;
		int curr;
		int found = 0;
		while (start < end) {
			curr = num[start] + num[end];
			if (curr == target) {
				result[0] = num[start];
				result[1] = num[end];
				found = 1;
				start++;
				end--;
			} else if (curr > target) {
				end--;
			} else
				start++;
		}
		if(found == 1) return result;
		else return null;
	}

	public static void main(String[] args) {
		int num[] = { 2, 5, 8, 1, 9, 10 };
		System.out.println(Arrays.toString(findPair(num)));
	}
}
