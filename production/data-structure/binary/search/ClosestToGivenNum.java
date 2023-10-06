package binary.search;

import java.util.Arrays;

public class ClosestToGivenNum {
   public static int[] close(int[] num, int val) {
      int start = 0;
      int end = num.length - 1;
      int[] result = new int[2];
      int min = Integer.MAX_VALUE;

      while(start < end) {
         int curr = val - (num[start] + num[end]);
         if (min > Math.abs(curr)) {
            min = curr;
            result[0] = num[start];
            result[1] = num[end];
         } else if (curr > 0) {
            ++start;
         } else {
            --end;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{10, 22, 28, 29, 30, 40};
      System.out.println(Arrays.toString(close(num, 54)));
   }
}
