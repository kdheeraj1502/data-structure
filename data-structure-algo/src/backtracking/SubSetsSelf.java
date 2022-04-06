package backtracking;

import java.util.*;

public class SubSetsSelf {

	public static List<List<Integer>> getSubsets(int nums[]) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		getSubsets(nums, result, new ArrayList<>(), 0);
		return result;
	}

	// 1, 1, 2, 2
	public static void getSubsets(int nums[], List<List<Integer>> result, List<Integer> curr, int index) {
		result.add(new ArrayList<>(curr));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;
			curr.add(nums[i]);
			getSubsets(nums, result, curr, i + 1);
			curr.remove(curr.size() - 1);
		}
		return;
	}

	private static List<List<Integer>> subset1(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<>());
		int start = 0;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				start = end + 1;
			}
			end = outer.size() - 1;
			int n = outer.size();

			for (int j = start; j < n; j++) {
				List<Integer> internal = new ArrayList<>(outer.get(j));
				// System.out.println(internal.size());
				internal.add(arr[i]);
				// System.out.println(internal.size());
				outer.add(internal);
			}
		}
		return outer;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2, 2 };
		List<List<Integer>> result = getSubsets(nums);
		result.stream().forEach(System.out::println);
	}
}
