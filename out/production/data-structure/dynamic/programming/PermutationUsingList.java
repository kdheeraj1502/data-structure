package dynamic.programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationUsingList {
   public static Set<List<Integer>> permute(int[] nums) {
      Set<List<Integer>> result = new HashSet();
      List<Integer> curr = new ArrayList();
      int start = 0;
      int end = nums.length - 1;
      permute(nums, start, end, curr, result);
      return result;
   }

   public static void permute(int[] nums, int start, int end, List<Integer> curr, Set<List<Integer>> result) {
      if (start == end) {
         result.add(curr);
      } else {
         for(int i = start; i <= end; ++i) {
            List<Integer> temp = new ArrayList();
            temp.addAll(curr);
            temp.add(nums[i]);
            permute(nums, i + 1, end, temp, result);
         }

      }
   }

   public static void swap(int[] nums, int a, int b) {
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 4, 3};
      System.out.println(permute(num));
   }
}
