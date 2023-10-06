package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateInKRangeOrKDistance {
   public static boolean duplicateKDistance(int[] num, int dis) {
      Map<Integer, Integer> map = new HashMap();

      for(int i = 0; i < num.length; ++i) {
         if (map.containsKey(num[i]) && dis >= i - (Integer)map.get(num[i])) {
            return true;
         }

         map.put(num[i], i);
      }

      return false;
   }

   public static boolean containsNearbyDuplicate(int[] nums, int k) {
      Set<Integer> set = new HashSet();

      for(int i = 0; i < nums.length; ++i) {
         System.out.println(set.size());
         if (set.contains(nums[i])) {
            return true;
         }

         set.add(nums[i]);
         if (i >= k) {
            set.remove(nums[i - k]);
         }
      }

      return false;
   }

   public static void main(String[] args) {
      int[] num = new int[]{10, 5, 3, 4, 6, 5, 3};
      System.out.println(duplicateKDistance(num, 3));
      System.out.println(containsNearbyDuplicate(num, 3));
   }
}
