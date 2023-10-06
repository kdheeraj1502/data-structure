package dp;

public class optimalgame {
   public static void main(String[] args) {
      int[] arr = new int[]{8, 15, 3, 7, 8, 5, 3, 7};
      int[][] dp = new int[arr.length][arr.length];
      System.out.println(solverec(0, arr.length - 1, arr, dp));

      for(int i = 0; i < dp.length; ++i) {
         for(int j = 0; j < dp[0].length; ++j) {
            System.out.print(dp[i][j] + " ");
         }

         System.out.println();
      }

      solvedp(arr);
   }

   public static int solverec(int i, int j, int[] arr, int[][] dp) {
      if (i > j) {
         return 0;
      } else if (dp[i][j] != 0) {
         return dp[i][j];
      } else {
         int ith = arr[i] + Math.min(solverec(i + 1, j - 1, arr, dp), solverec(i + 2, j, arr, dp));
         int jth = arr[j] + Math.min(solverec(i + 1, j - 1, arr, dp), solverec(i, j - 2, arr, dp));
         return dp[i][j] = Math.max(ith, jth);
      }
   }

   public static void solvedp(int[] arr) {
      int[][] dp = new int[arr.length][arr.length];

      for(int g = 0; g < dp.length; ++g) {
         int i = 0;

         for(int j = g; i < dp.length && j < dp[0].length; ++j) {
            if (g == 0) {
               dp[i][j] = arr[i];
            } else if (g == 1) {
               dp[i][j] = Math.max(arr[i], arr[j]);
            } else {
               int ith = arr[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]);
               int jth = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
               dp[i][j] = Math.max(ith, jth);
            }

            ++i;
         }
      }

      System.out.println(dp[0][arr.length - 1]);
   }
}
