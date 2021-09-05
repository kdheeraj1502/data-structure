package dynamic.programming;

import java.util.*;

public class PermutationUsingList {

	public static Set<List<Integer>> permute(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> curr = new ArrayList<>();
		int start = 0;
		int end = nums.length - 1;
		permute(nums, start, end, curr, result);
		return result;
	}

	public static void permute(int[] nums, int start, int end, List<Integer> curr, Set<List<Integer>> result) {
		if (start == end) {
		//	List<Integer> curr = new ArrayList<Integer>();
		//	for (int num : nums) {
		//		curr.add(num);
		//	}
			result.add(curr);
			return;
		}

		// Swap element at st with every other element, fix the swapped element at st
		// and then permute with st + 1
		// After permuting reset to the original positions before
		// permuting(Backtracking)
		for (int i = start; i <= end; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(curr);
			temp.add(nums[i]);
			//swap(nums, start, i);
			permute(nums, i + 1, end, temp, result); // Fix the element at current values of st and then increase st
			//temp.add(nums[i]);
			//	swap(nums, start, i);
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
