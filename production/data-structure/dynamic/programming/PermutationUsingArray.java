package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class PermutationUsingArray {
   public static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList();
      int start = 0;
      int end = nums.length - 1;
      permute(nums, start, end, result);
      return result;
   }

   public static void permute(int[] nums, int start, int end, List<List<Integer>> result) {
      if (start == end) {
         List<Integer> curr = new ArrayList();
         int[] var5 = nums;
         int var6 = nums.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            int num = var5[var7];
            curr.add(num);
         }

         result.add(curr);
      } else {
         for(int i = start; i <= end; ++i) {
            swap(nums, start, i);
            permute(nums, start + 1, end, result);
            swap(nums, start, i);
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
