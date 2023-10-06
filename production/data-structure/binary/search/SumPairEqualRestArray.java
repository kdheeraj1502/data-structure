package binary.search;

import java.util.Arrays;

public class SumPairEqualRestArray {
   public static int[] findPair(int[] num) {
      int[] result = new int[2];
      int sum = 0;
      Arrays.sort(num);

      int target;
      for(target = 0; target < num.length; ++target) {
         sum += num[target];
      }

      target = sum / 2;
      int start = 0;
      int end = num.length - 1;
      int found = false;

      while(start < end) {
         int curr = num[start] + num[end];
         if (curr == target) {
            result[0] = num[start];
            result[1] = num[end];
            found = true;
            ++start;
            --end;
         } else if (curr > target) {
            --end;
         } else {
            ++start;
         }
      }

      if (found) {
         return result;
      } else {
         return null;
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 5, 8, 1, 9, 10};
      System.out.println(Arrays.toString(findPair(num)));
   }
}
