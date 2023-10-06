package dynamic.programming.knapsack;

public class SubSetSumProblem {
   private boolean[][] knapSackTable;
   private int[] S;
   private int sum;

   public SubSetSumProblem(int[] S, int sum) {
      this.S = S;
      this.sum = sum;
      this.knapSackTable = new boolean[S.length + 1][sum + 1];
   }

   public boolean solve() {
      int rowIndex;
      for(rowIndex = 0; rowIndex < this.S.length + 1; ++rowIndex) {
         this.knapSackTable[rowIndex][0] = true;
      }

      for(rowIndex = 1; rowIndex < this.S.length + 1; ++rowIndex) {
         for(int colIndex = 1; colIndex < this.sum + 1; ++colIndex) {
            if (colIndex < this.S[rowIndex - 1]) {
               this.knapSackTable[rowIndex][colIndex] = this.knapSackTable[rowIndex - 1][colIndex];
            } else if (this.knapSackTable[rowIndex - 1][colIndex]) {
               this.knapSackTable[rowIndex][colIndex] = this.knapSackTable[rowIndex - 1][colIndex];
            } else {
               this.knapSackTable[rowIndex][colIndex] = this.knapSackTable[rowIndex - 1][colIndex - this.S[rowIndex - 1]];
            }
         }
      }

      return this.knapSackTable[this.S.length][this.sum];
   }

   public void showResult() {
      int colIndex = this.sum;
      int rowIndex = this.S.length;

      while(colIndex > 0 || rowIndex > 0) {
         if (this.knapSackTable[rowIndex][colIndex] == this.knapSackTable[rowIndex - 1][colIndex]) {
            --rowIndex;
         } else {
            System.out.println("We take " + this.S[rowIndex - 1]);
            colIndex -= this.S[rowIndex - 1];
            --rowIndex;
         }
      }

   }

   public static void main(String[] args) {
      int[] S = new int[]{5, 2, 3, 1};
      int sum = 9;
      SubSetSumProblem ssp = new SubSetSumProblem(S, sum);
      System.out.println(ssp.solve());
      ssp.showResult();
   }
}
