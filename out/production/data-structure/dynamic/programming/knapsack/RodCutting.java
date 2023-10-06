package dynamic.programming.knapsack;

public class RodCutting {
   private int[][] dpTable;
   private int lenghtOfRod;
   private int[] prices;

   public RodCutting(int lengthOfRod, int[] prices) {
      this.prices = prices;
      this.lenghtOfRod = lengthOfRod;
      this.dpTable = new int[prices.length + 1][lengthOfRod + 1];
   }

   public void solve() {
      for(int i = 1; i < this.prices.length; ++i) {
         for(int j = 1; j < this.lenghtOfRod + 1; ++j) {
            if (i <= j) {
               this.dpTable[i][j] = Math.max(this.dpTable[i - 1][j], this.prices[i] + this.dpTable[i - 1][j - i]);
            } else {
               this.dpTable[i][j] = this.dpTable[i - 1][j];
            }
         }
      }

   }

   public void showResult() {
      System.out.println("Optimal profit: $" + this.dpTable[this.prices.length - 1][this.lenghtOfRod]);
      int n = this.prices.length - 1;
      int w = this.lenghtOfRod;

      while(true) {
         while(n > 0) {
            if (this.dpTable[n][w] != 0 && this.dpTable[n][w] != this.dpTable[n - 1][w]) {
               System.out.println("We make cut: " + n + "m");
               w -= n;
            } else {
               --n;
            }
         }

         return;
      }
   }

   public static void main(String[] args) {
      int lengthOfRod = 5;
      int[] prices = new int[]{0, 2, 5, 7, 3, 9};
      RodCutting cutting = new RodCutting(lengthOfRod, prices);
      cutting.solve();
      cutting.showResult();
   }
}
