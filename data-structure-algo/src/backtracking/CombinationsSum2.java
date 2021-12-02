package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationsSum2 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> nums = Arrays.stream(candidates).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<>(nums);
		nums = new ArrayList<>(set);
		Arrays.sort(candidates);
		Collections.sort(nums);
		int num[] = new int[nums.size()];
		int i = 0;
		for(int in : nums) {
			num[i++] = in;
		}
	combinationSum2(result, new ArrayList<>(), candidates, target, 0);
		//combinationSum2(result, new ArrayList<>(), num, target, 0);
		return result;
	}

	public static void combinationSum2(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remaining,
			int start) {
		if (remaining < 0) {
			return;
		} else if (remaining == 0) {
			result.add(new ArrayList<>(temp));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				if (i > start && candidates[i] == candidates[i - 1])
					continue;
				temp.add(candidates[i]);
				combinationSum2(result, temp, candidates, remaining - candidates[i], i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 8, 1, 8, 6, 8 };

		System.out.println(combinationSum2(nums, 12));
	}
}
