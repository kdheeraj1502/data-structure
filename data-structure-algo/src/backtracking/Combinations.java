package backtracking;

import java.util.*;

public class Combinations {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	public static void combinationSum(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remaining,
			int start) {
		if (remaining < 0) {
			return;
		} else if (remaining == 0) {
			result.add(new ArrayList<>(temp));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				combinationSum(result, temp, candidates, remaining - candidates[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 8, 1, 8, 6, 8 };

		System.out.println(combinationSum(nums, 12));
	}
}
