package dp;

import java.util.Arrays;

public class maxsumrectangle {
   public static void main(String[] args) {
      int[][] arr = new int[][]{{-3, -3, -3}, {-2, -2, 5}, {-1, 10, 10}};
      solvedp(arr);
   }

   public static void solvedp(int[][] arr) {
      int[] dp = new int[arr[0].length];
      int ans = Integer.MIN_VALUE;

      for(int i = 0; i < arr.length; ++i) {
         for(int j = i; j < arr.length; ++j) {
            int sum = 0;

            for(int k = 0; k < arr[0].length; ++k) {
               dp[k] += arr[j][k];
               if (sum + dp[k] > dp[k]) {
                  sum += dp[k];
               } else {
                  sum = dp[k];
               }

               ans = Math.max(sum, ans);
            }
         }

         Arrays.fill(dp, 0);
      }

      System.out.println(ans);
   }
}
