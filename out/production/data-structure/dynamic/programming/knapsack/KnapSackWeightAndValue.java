package dynamic.programming.knapsack;

public class KnapSackWeightAndValue {
   private int[][] dp;
   private int numOfItems;
   private int capacity;
   private int profit;
   private int[] values;
   private int[] weights;

   public KnapSackWeightAndValue(int numOfItems, int capacity, int[] values, int[] weights) {
      this.numOfItems = numOfItems;
      this.capacity = capacity;
      this.values = values;
      this.weights = weights;
      this.dp = new int[numOfItems + 1][capacity + 1];
   }

   public void showResult() {
      int n = this.numOfItems;

      for(int w = this.capacity; n > 0; --n) {
         if (this.dp[n][w] != 0 && this.dp[n][w] != this.dp[n - 1][w]) {
            System.out.println("We take item : #" + n);
            w -= this.weights[n - 1];
         } else {
            --n;
         }
      }

   }

   private void solve() {
      for(int i = 1; i < this.numOfItems + 1; ++i) {
         for(int j = 1; j < this.capacity + 1; ++j) {
            int notTaken = this.dp[i - 1][j];
            int taken = 0;
            if (this.weights[i - 1] <= j) {
               taken = this.values[i - 1] + this.dp[i - 1][j - this.weights[i - 1]];
            }

            this.dp[i][j] = Math.max(notTaken, taken);
         }
      }

      this.profit = this.dp[this.numOfItems][this.capacity];
      System.out.println(this.profit);
   }

   public static void main(String[] args) {
      int numOfItems = 3;
      int capacityOfKnapsack = 5;
      int[] weights = new int[]{4, 2, 3};
      int[] values = new int[]{10, 4, 7};
      KnapSackWeightAndValue kwv = new KnapSackWeightAndValue(numOfItems, capacityOfKnapsack, values, weights);
      kwv.solve();
      kwv.showResult();
   }
}
