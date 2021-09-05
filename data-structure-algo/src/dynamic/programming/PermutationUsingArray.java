package dynamic.programming;

import java.util.*;

public class PermutationUsingArray {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int start = 0;
		int end = nums.length - 1;
		permute(nums, start, end, result);
		return result;
	}

	public static void permute(int[] nums, int start, int end, List<List<Integer>> result) {
		if (start == end) {
			List<Integer> curr = new ArrayList<Integer>();
			for (int num : nums) {
				curr.add(num);
			}
			result.add(curr);
			return;
		}

		// Swap element at st with every other element, fix the swapped element at st
		// and then permute with st + 1
		// After permuting reset to the original positions before
		// permuting(Backtracking)
		for (int i = start; i <= end; i++) {
			swap(nums, start, i);
			permute(nums, start + 1, end, result); // Fix the element at current values of st and then increase st
			swap(nums, start, i);
		}
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 4, 3 };
		System.out.println(permute(num));
	}
}
