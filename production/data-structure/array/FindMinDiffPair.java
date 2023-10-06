package array;

import java.util.Arrays;

public class FindMinDiffPair {
   public static int[] findDiffPair(int[] num1, int[] num2) {
      int minDiff = Integer.MAX_VALUE;
      int first = 0;
      int second = 0;
      Arrays.sort(num1);
      Arrays.sort(num2);
      int[] result = new int[2];

      while(first < num1.length && second < num2.length) {
         int diff = Math.abs(num1[first] - Math.abs(num2[second]));
         if (minDiff > diff) {
            minDiff = diff;
            result[0] = num1[first];
            result[1] = num2[second];
         } else if (num1[first] < num2[second]) {
            ++first;
         } else {
            ++second;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num1 = new int[]{45, 87, 23, 99, 18, 100};
      int[] num2 = new int[]{53, 32, 57, 89, 11, 10, 78};
      System.out.println(Arrays.toString(findDiffPair(num1, num2)));
   }
}
