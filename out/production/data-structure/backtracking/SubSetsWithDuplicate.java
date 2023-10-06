package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetsWithDuplicate {
   public List<List<Integer>> subsetsWithDup(int[] nums) {
      Set<List<Integer>> result = new HashSet();
      Arrays.sort(nums);
      this.subsetsWithDup(result, new ArrayList(), nums, 0);
      return new ArrayList(result);
   }

   public void subsetsWithDup(Set<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
      result.add(new ArrayList(temp));

      for(int i = start; i < nums.length; ++i) {
         if (i <= start || nums[i] != nums[i - 1]) {
            temp.add(nums[i]);
            this.subsetsWithDup(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
         }
      }

   }

   public static void main(String[] args) {
      int[] nums = new int[]{1, 2, 2};
      SubSetsWithDuplicate ss = new SubSetsWithDuplicate();
      ss.subsetsWithDup(nums).forEach((num) -> {
         System.out.println(num);
      });
   }
}
