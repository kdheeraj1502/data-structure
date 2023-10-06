package dynamic.programming;

public class RodCuttingProblem {
   int[] prices;
   int N;
   int[][] dp;

   public RodCuttingProblem(int[] prices, int N) {
      this.prices = prices;
      this.N = N;
      this.dp = new int[prices.length][N + 1];
   }

   public int maxProfit() {
      for(int i = 1; i < this.dp.length; ++i) {
         for(int j = 1; j < this.dp[i].length; ++j) {
            if (i > j) {
               this.dp[i][j] = this.dp[i - 1][j];
            } else {
               this.dp[i][j] = Math.max(this.prices[i - 1] + this.dp[i - 1][j - i], this.dp[i - 1][j]);
            }
         }
      }

      return this.dp[this.prices.length - 1][this.N];
   }

   public static void main(String[] args) {
      int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
      RodCuttingProblem rcp = new RodCuttingProblem(price, 8);
      System.out.println(rcp.maxProfit());
   }
}
