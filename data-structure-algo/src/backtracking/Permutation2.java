package backtracking;

import java.util.*;

public class Permutation2 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(result, new ArrayList<>(), nums, used);
        return result;
    }
    
    public static void permuteUnique(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean used[]) {
        if(nums.length == temp.size()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1]  && !used[i - 1])) continue;
            used[i] = true;
            temp.add(nums[i]);
            permuteUnique(result, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
		int  nums[] = { 1, 2, 3 };
		
		System.out.println(permuteUnique(nums));
	}
}
