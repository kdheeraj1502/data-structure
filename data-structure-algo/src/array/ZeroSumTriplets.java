package array;

import java.util.*;

public class ZeroSumTriplets {

	public static List<List<Integer>> zeroSum(int num[], List<List<Integer>> output) {
		Arrays.sort(num);
		int result[] = new int[3];
		int start;
		int end;
		for (int i = 0; i < num.length - 2; i++) {
			start = i + 1;
			end = num.length - 1;
			// [-5, -4, 0, 1, 2, 3, 5, 7, 8]
			int a = num[i];
			while (start < end) {
				int b = num[start];
				int c = num[end];
				int sum = a + b + c;
				System.out.println(a + ", " + b + ", " + c + " = " + sum);
				if (sum == 0) {
					result[0] = num[i];
					result[1] = num[start];
					result[2] = num[end];
					List<Integer> curr = new ArrayList<>();
					curr.add(num[i]);
					curr.add(num[start]);
					curr.add(num[end]);
					output.add(curr);
					start++;
					end--;
				} else if (sum > 0) {
					end--;
				} else
					start++;
			}
		}
		// return result;
		return output;
	}

	public static void main(String[] args) {
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0 };
		List<List<Integer>> output = new ArrayList<>();
//		System.out.println(Arrays.toString(zeroSum(num, output)));
		System.out.println(zeroSum(num, output));
	}
}
