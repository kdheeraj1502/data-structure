package array;

import java.util.Arrays;

public class SumOfPairIsEqualToRestOfArray {
   public static int[] findPair(int[] num) {
      int total = 0;

      int rest;
      for(rest = 0; rest < num.length; ++rest) {
         total += num[rest];
      }

      rest = total / 2;
      int start = 0;
      int end = num.length - 1;
      int curr = false;
      int[] result = new int[2];

      while(start < end) {
         int curr = num[start] + num[end];
         if (curr == rest) {
            result[0] = num[start];
            result[1] = num[end];
         }

         if (curr > rest) {
            --end;
         } else {
            ++start;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 3, 4, 7, 7, 9};
      System.out.println(Arrays.toString(findPair(num)));
   }
}
