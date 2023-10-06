package array;

import java.util.Arrays;

public class choclatedistribution {
   public static void main(String[] args) {
      int[] arr = new int[]{7, 3, 2, 4, 9, 12, 56};
      dist(arr, 3);
   }

   public static void dist(int[] arr, int m) {
      Arrays.sort(arr);
      int ans = Integer.MAX_VALUE;

      for(int i = 0; i + m - 1 < arr.length; ++i) {
         int diff = arr[i + m - 1] - arr[i];
         if (diff < ans) {
            ans = diff;
         }
      }

      System.out.println(ans);
   }
}
