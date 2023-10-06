package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationsPermutation {
   public static List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList();
      int[] nums = new int[n];

      for(int i = 1; i <= n; nums[i - 1] = i++) {
      }

      combine(nums, result, new ArrayList(), k, 0);
      return result;
   }

   public static void combine(int[] nums, List<List<Integer>> result, List<Integer> curr, int size, int start) {
      if (curr.size() == size) {
         result.add(new ArrayList(curr));
      } else {
         for(int i = start; i < nums.length; ++i) {
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
