package dp;

public class goldmine {
   public static void main(String[] args) {
      int[][] mat = new int[][]{{10, 33, 13, 15}, {22, 21, 4, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};
      solve(mat);
   }

   public static void solve(int[][] arr) {
      int[][] dp = new int[arr.length][arr[0].length];

      int max;
      for(max = 0; max < dp.length; ++max) {
         dp[max][arr[0].length - 1] = arr[max][arr[0].length - 1];
      }

      max = Integer.MIN_VALUE;

      int j;
      int i;
      for(j = arr[0].length - 2; j >= 0; --j) {
         for(i = 0; i < dp.length; ++i) {
            int right = false;
            int upright = 0;
            int downright = 0;
            int right = dp[i][j + 1];
            if (i - 1 >= 0) {
               upright = dp[i - 1][j + 1];
            }

            if (i + 1 < dp.length) {
               downright = dp[i + 1][j + 1];
            }

            dp[i][j] = Math.max(right, Math.max(upright, downright)) + arr[i][j];
            if (max < dp[i][j]) {
               max = dp[i][j];
            }
         }
      }

      for(j = 0; j < dp.length; ++j) {
         for(i = 0; i < dp[0].length; ++i) {
            System.out.print(dp[j][i] + " ");
         }

         System.out.println();
      }

      System.out.println(max);
   }
}
