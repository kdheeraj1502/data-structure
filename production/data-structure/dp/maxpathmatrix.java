package dp;

public class maxpathmatrix {
   public static void main(String[] args) {
      int[][] arr = new int[][]{{348, 391}, {618, 193}};
      solve(arr);
   }

   public static void solve(int[][] arr) {
      int[][] dp = new int[arr.length][arr[0].length];

      int i;
      int j;
      for(i = dp.length - 1; i >= 0; --i) {
         for(j = dp[0].length - 1; j >= 0; --j) {
            if (i == dp.length - 1) {
               dp[i][j] = arr[i][j];
            } else {
               int a = false;
               int b = 0;
               int c = 0;
               int a = dp[i + 1][j];
               if (j - 1 >= 0) {
                  b = dp[i + 1][j - 1];
               }

               if (j + 1 < dp[0].length) {
                  c = dp[i + 1][j + 1];
               }

               dp[i][j] = Math.max(a, Math.max(b, c)) + arr[i][j];
            }
         }
      }

      i = 0;

      for(j = 0; j < dp[0].length; ++j) {
         i = Math.max(i, dp[0][j]);
      }

      System.out.println(i);
   }
}
