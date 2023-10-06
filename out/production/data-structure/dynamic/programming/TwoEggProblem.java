package dynamic.programming;

public class TwoEggProblem {
   private int[][] dp = new int[3][101];

   public int solve() {
      this.dp[0][0] = 1;
      this.dp[1][0] = 1;

      int n;
      for(n = 1; n <= 100; this.dp[1][n] = n++) {
      }

      for(n = 2; n <= 2; ++n) {
         for(int m = 1; m <= 100; ++m) {
            this.dp[n][m] = Integer.MAX_VALUE;

            for(int x = 1; x <= m; ++x) {
               int maxDrops = 1 + Math.max(this.dp[n][m - x], this.dp[n - 1][x - 1]);
               if (maxDrops < this.dp[n][m]) {
                  this.dp[n][m] = maxDrops;
               }
            }
         }
      }

      return this.dp[2][100];
   }

   public static void main(String[] args) {
      TwoEggProblem tep = new TwoEggProblem();
      System.out.println("Minimum number of drops to find the critical floor: " + tep.solve());
   }
}
