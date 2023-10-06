package array;

import java.util.Arrays;

public class FindDiffPair {
   public static int[] findDiffPair(int[] num, int val) {
      int[] result = new int[2];
      Arrays.sort(num);
      int first = 0;
      int second = 0;

      while(first < num.length && second < num.length) {
         int diff = Math.abs(num[first] - num[second]);
         if (diff == val) {
            result[0] = num[first];
            result[1] = num[second];
            return result;
         }

         if (diff > val) {
            ++first;
         } else {
            ++second;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{5, 2, 7, 9, 1, 8};
      System.out.println(Arrays.toString(findDiffPair(num, 2)));
   }
}
