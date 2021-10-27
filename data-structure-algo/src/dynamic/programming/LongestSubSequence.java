package dynamic.programming;

import java.util.*;

public class LongestSubSequence {

	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int[] dp = new int[len];
		dp[0] = 1;
		int max = 0;
		// 10, 9, 2, 5, 3, 7, 101, 18
		for (int i = 1; i < dp.length; i++) {
			// find all previous numbers that are smaller than nums[i]
			max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
				dp[i] = max + 1;
			}
			max = Math.max(dp[i], max);
		}
		return Arrays.stream(dp).max().getAsInt();
		// return max;
	}

	// Iterative function to find the longest increasing subsequence
	// of a given array

	public static void findLIS(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++)
			result.add(new ArrayList<>());
		// 1, 3, 6, 7, 9, 4, 10, 5, 6
		result.get(0).add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && result.get(j).size() > result.get(i).size()) {
					result.set(i, new ArrayList<>(result.get(j)));
				}
			}
			result.get(i).add(arr[i]);
		}
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (result.get(j).size() < result.get(i).size()) {
				j = i;
			}
		}

		System.out.print(result.get(j));
	}

	public static List<Integer> findLIS_self(int[] num) {
		if (num.length == 0)
			return null;
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < num.length; i++)
			result.add(new ArrayList<>());
		
		result.get(0).add(1);
		
		for(int i = 1; i < num.length; i++) {
			for(int j = 0; j < num.length; j++) {
				if(num[j] < num[i] && result.get(j).size() > result.get(i).size()) {
					result.set(i, new ArrayList<>(result.get(j)));
				}
			}
			result.get(i).add(num[i]);
		}
		int j = 0;
		for(int i = 1; i < result.size(); i++) {
			if(result.get(j).size() < result.get(i).size()) {
				j = i;
			}
		}
		return result.get(j);
	}

	public static void main(String[] args) {
		// int num[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int num[] = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		int output[] = { 2, 3, 7, 101 };
		LongestSubSequence lss = new LongestSubSequence();
		System.out.println(lss.lengthOfLIS(num));
		lss.findLIS(num);
		System.out.println();
		System.out.println(lss.findLIS_self(num));
	}
}
