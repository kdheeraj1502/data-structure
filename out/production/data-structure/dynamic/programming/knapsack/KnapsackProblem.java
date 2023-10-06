package dynamic.programming.knapsack;

public class KnapsackProblem {
   private int numOfItems;
   private int totalBenefit;
   private int[][] knapSackTable;
   private int capacityOfKnapsack;
   private int[] weights;
   private int[] values;

   KnapsackProblem(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
      this.numOfItems = numOfItems;
      this.capacityOfKnapsack = capacityOfKnapsack;
      this.weights = weights;
      this.values = values;
      this.knapSackTable = new int[numOfItems + 1][capacityOfKnapsack + 1];
   }

   private void solve() {
      for(int i = 1; i < this.numOfItems + 1; ++i) {
         for(int j = 1; j < this.capacityOfKnapsack + 1; ++j) {
            int notTaken = this.knapSackTable[i - 1][j];
            int taken = 0;
            if (this.weights[i - 1] <= j) {
               taken = this.values[i - 1] + this.knapSackTable[i - 1][j - this.weights[i - 1]];
            }

            this.knapSackTable[i][j] = Math.max(notTaken, taken);
         }
      }

      this.totalBenefit = this.knapSackTable[this.numOfItems][this.capacityOfKnapsack];
      System.out.println(this.totalBenefit);
   }

   public void showResult() {
      int n = this.numOfItems;

      for(int w = this.capacityOfKnapsack; n > 0; --n) {
         if (this.knapSackTable[n][w] != 0 && this.knapSackTable[n][w] != this.knapSackTable[n - 1][w]) {
            System.out.println("We take item : #" + n);
            w -= this.weights[n - 1];
         }
      }

   }

   public static void main(String[] args) {
      int numOfItems = 4;
      int capacityOfKnapsack = 7;
      int[] weights = new int[]{1, 3, 4, 5};
      int[] values = new int[]{1, 4, 5, 7};
      KnapsackProblem kp = new KnapsackProblem(numOfItems, capacityOfKnapsack, weights, values);
      kp.solve();
      kp.showResult();
   }
}
