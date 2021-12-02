package backtracking;

import java.util.*;

/**
 * 
 * 
 * Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * 
 * 
 * 
 * @author dheerajkumar02
 *
 */
public class CombinationsPermutation {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int nums[] = new int[n];
        for(int i = 1; i <= n; i++){
            nums[i - 1] = i;
        }
        combine(nums, result, new ArrayList<>(), k, 0);
        return result;
    }
    
     public static void combine(int nums[], List<List<Integer>> result, List<Integer> curr, int size, int start) {
         if(curr.size() == size) {
             result.add(new ArrayList<>(curr));
             return;
         } else{
            for(int i = start; i < nums.length; i++){
                curr.add(nums[i]);
                combine(nums, result, curr, size, i + 1);
                curr.remove(curr.size() - 1);
            } 
         }
     }
     
     public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(combine(n, k));
	}
}
