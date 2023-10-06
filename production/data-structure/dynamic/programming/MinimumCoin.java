package dynamic.programming;

public class MinimumCoin {
   int[][] dp;
   int total;

   MinimumCoin(int[] coins, int n) {
      this.dp = new int[coins.length][n + 1];
      this.total = n;
   }

   public void minCoin(int[] coins) {
      int i;
      for(i = 0; i < coins.length; ++i) {
         this.dp[i][0] = 0;
      }

      for(i = 0; i < this.dp[0].length; this.dp[0][i] = i++) {
      }

      int j;
      for(i = 1; i < this.dp.length; ++i) {
         for(j = 1; j < this.dp[0].length; ++j) {
            if (coins[i] > j) {
               this.dp[i][j] = this.dp[i - 1][j];
            } else {
               this.dp[i][j] = Math.min(this.dp[i - 1][j], 1 + this.dp[i][j - coins[i]]);
            }
         }
      }

      for(i = 0; i < this.dp.length; ++i) {
         for(j = 0; j < this.dp[0].length; ++j) {
            System.out.print(this.dp[i][j] + " ");
         }

         System.out.println();
      }

      System.out.println("---------- coins ---------");
      this.printChange(coins);
   }

   private void printChange(int[] coins) {
      int i = coins.length - 1;
      int j = this.total;
      int min = this.dp[i][j];
      System.out.println("------set of coins-------");

      while(j > 0) {
         if (this.dp[i - 1][j] == min) {
            --i;
         } else {
            System.out.print(coins[i] + ", ");
            j -= coins[i];
            min = this.dp[i][j];
         }
      }

      System.out.println();
      System.out.println("------set of coins-------");
   }

   public static void main(String[] args) {
      int[] coins = new int[]{1, 2, 3};
      MinimumCoin mc = new MinimumCoin(coins, 5);
      mc.minCoin(coins);
   }
}
