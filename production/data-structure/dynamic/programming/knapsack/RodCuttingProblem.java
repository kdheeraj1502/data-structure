package dynamic.programming.knapsack;

public class RodCuttingProblem {
   private int rodLength;
   private int[] prices;
   private int totalBenefit;
   private int[][] knapSackTable;

   public RodCuttingProblem(int rodLength, int[] prices) {
      this.rodLength = rodLength;
      this.prices = prices;
      this.knapSackTable = new int[prices.length + 1][rodLength + 1];
   }

   public int solve() {
      for(int i = 1; i < this.prices.length; ++i) {
         for(int j = 1; j < this.rodLength + 1; ++j) {
            if (i <= j) {
               this.knapSackTable[i][j] = Math.max(this.knapSackTable[i - 1][j], this.prices[i] + this.knapSackTable[i - 1][j - i]);
            } else {
               this.knapSackTable[i][j] = this.knapSackTable[i - 1][j];
            }
         }
      }

      this.totalBenefit = this.knapSackTable[this.prices.length - 1][this.rodLength];
      return this.totalBenefit;
   }

   public void showResult() {
      int rowIndex = this.prices.length - 1;
      int colIndex = this.rodLength;

      while(true) {
         while(rowIndex > 0) {
            if (this.knapSackTable[rowIndex][colIndex] != 0 && this.knapSackTable[rowIndex][colIndex] != this.knapSackTable[rowIndex - 1][colIndex]) {
               System.out.println("We take item : #" + rowIndex);
               colIndex -= rowIndex;
            } else {
               --rowIndex;
            }
         }

         return;
      }
   }

   public static void main(String[] args) {
      int rodLength = 5;
      int[] prices = new int[]{0, 2, 5, 7, 3, 9};
      RodCuttingProblem rcp = new RodCuttingProblem(rodLength, prices);
      System.out.println(rcp.solve());
      rcp.showResult();
   }
}
