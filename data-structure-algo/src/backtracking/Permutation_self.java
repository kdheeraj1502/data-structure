package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_self {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permute(result, new ArrayList<>(), nums);
		return result;
	}
	
	public static void permute(List<List<Integer>> result, List<Integer> temp, int[] nums) {
		if(temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			//return;
		}
		else {
			for(int i = 0; i < nums.length; i++) {
				if (temp.contains(nums[i]))
					continue;
				temp.add(nums[i]);
				permute(result, temp, nums);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		System.out.println(permute(nums));
	}
}

