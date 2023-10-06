package dp;

public class maximisecutsegment {
   public static void main(String[] args) {
      int n = 9999;
      int x = 94;
      int y = 20;
      int z = 244;
      System.out.println(maximizeCuts(n, x, y, z));
   }

   public static int solverecursive(int n, int x, int y, int z) {
      if (n == 0) {
         return 0;
      } else {
         int xcut = Integer.MIN_VALUE;
         int ycut = Integer.MIN_VALUE;
         int zcut = Integer.MIN_VALUE;
         if (n - x >= 0) {
            xcut = solverecursive(n - x, x, y, z);
         }

         if (n - y >= 0) {
            ycut = solverecursive(n - y, x, y, z);
         }

         if (n - z >= 0) {
            zcut = solverecursive(n - z, x, y, z);
         }

         return Math.max(xcut, Math.max(ycut, zcut)) + 1;
      }
   }

   public static int maximizeCuts(int n, int x, int y, int z) {
      int[] dp = new int[n + 1];

      int a;
      for(a = 0; a < dp.length; ++a) {
         dp[a] = -1;
      }

      a = solvedp(n, x, y, z, dp);
      return a < 0 ? 0 : a;
   }

   public static int solvedp(int n, int x, int y, int z, int[] dp) {
      if (n == 0) {
         return 0;
      } else if (dp[n] != -1) {
         return dp[n];
      } else {
         int xcut = Integer.MIN_VALUE;
         int ycut = Integer.MIN_VALUE;
         int zcut = Integer.MIN_VALUE;
         if (n - x >= 0) {
            xcut = solvedp(n - x, x, y, z, dp);
         }

         if (n - y >= 0) {
            ycut = solvedp(n - y, x, y, z, dp);
         }

         if (n - z >= 0) {
            zcut = solvedp(n - z, x, y, z, dp);
         }

         dp[n] = Math.max(xcut, Math.max(ycut, zcut)) + 1;
         return dp[n];
      }
   }
}
