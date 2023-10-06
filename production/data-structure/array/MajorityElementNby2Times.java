package array;

import java.util.Arrays;

public class MajorityElementNby2Times {
   public static int majorityElement(int[] num) {
      Arrays.sort(num);
      int count = 1;
      int result = 0;
      int target = num.length / 2;
      int candidate = num[target];

      for(int i = 0; i < num.length; ++i) {
         if (num[i] == candidate) {
            ++count;
         }
      }

      if (count > target) {
         result = candidate;
      }

      return result;
   }
}
