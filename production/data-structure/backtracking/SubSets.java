package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
   public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList();
      this.subsets(result, new ArrayList(), nums, 0);
      return result;
   }

   public void subsets(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
      result.add(new ArrayList(temp));

      for(int i = start; i < nums.length; ++i) {
         temp.add(nums[i]);
         this.subsets(result, temp, nums, i + 1);
         temp.remove(temp.size() - 1);
      }

   }

   public static void main(String[] args) {
      int[] nums = new int[]{1, 2, 3};
      SubSets ss = new SubSets();
      ss.subsets(nums).forEach((num) -> {
         System.out.println(num);
      });
   }
}
