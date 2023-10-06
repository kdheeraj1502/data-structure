package array;

import java.util.Arrays;

public class FindPairCLosetToNumber {
   public static int[] findPairCLosetToNumber(int[] num, int val) {
      int start = 0;
      int end = num.length - 1;
      Arrays.sort(num);
      int diff = Integer.MAX_VALUE;
      int[] result = new int[2];

      while(start < end) {
         int curr = val - Math.abs(num[start] + num[end]);
         if (curr < diff) {
            diff = curr;
            result[0] = num[start];
            result[1] = num[end];
         }

         if (curr == 0) {
            break;
         }

         if (curr > 0) {
            ++start;
         } else {
            --end;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{53, 32, 57, 89, 11, 10, 78};
      System.out.println(Arrays.toString(findPairCLosetToNumber(num, 100)));
   }
}
