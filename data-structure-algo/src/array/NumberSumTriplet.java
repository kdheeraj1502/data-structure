package array;

import java.util.*;

public class NumberSumTriplet {

	public static List<List<Integer>> numberSum(int num[], int val, List<List<Integer>> output) {
		Arrays.sort(num);
		int start;
		int end = num.length - 1;
		int result[] = new int[3];
		for(int i = 0; i < num.length - 2; i++) {
			start = i + 1;
			end = num.length - 1;
			while(start < end) {
				int sum = num[i] + num[start] + num[end];
				if(val == sum) {
					result[0] = num[start];
					result[1] = num[i];
					result[2] = num[end];
					List<Integer> list = new ArrayList<>();
					list.add(num[start]);
					list.add(num[i]);
					list.add(num[end]);
					output.add(list);
					start++;
					end--;
				}
				else if(sum > val) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0 };
		List<List<Integer>> result = new ArrayList<>();
		System.out.println((numberSum(num, 13, result)));
	}
}
