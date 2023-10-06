package dynamic.programming.knapsack;

public class RodCuttingSelf {
   private int length;
   private int[] amount;
   private int[][] dp;
   private int profit;

   public RodCuttingSelf(int length, int[] amount) {
      this.length = length;
      this.amount = amount;
      this.dp = new int[amount.length + 1][length + 1];
   }

   public void solve() {
      for(int i = 1; i < this.amount.length + 1; ++i) {
         for(int j = 1; j < this.length + 1; ++j) {
            if (i <= j) {
               this.dp[i][j] = Math.max(this.amount[i - 1] + this.dp[i - 1][j - i], this.dp[i - 1][j]);
            } else {
               this.dp[i][j] = this.dp[i - 1][j];
            }
         }
      }

      this.profit = this.dp[this.amount.length][this.length];
      System.out.println(this.profit);
   }

   public void showResult() {
      int n = this.amount.length;

      for(int w = this.length; n > 0; --n) {
         if (this.dp[n][w] != 0 && this.dp[n][w] != this.dp[n - 1][w]) {
            System.out.println("We make cut: " + (n - 1));
            w -= n;
         } else {
            --n;
         }
      }

   }

   public static void main(String[] args) {
      int lengthOfRod = 5;
      int[] prices = new int[]{2, 5, 7, 3, 9};
      RodCuttingSelf rcs = new RodCuttingSelf(lengthOfRod, prices);
      rcs.solve();
      rcs.showResult();
   }
}
