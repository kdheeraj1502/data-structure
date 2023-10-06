package dynamic.programming.knapsack;

public class SubSetSumProblemSelf {
   private int maxSum;
   private int[] nums;
   private boolean[][] knapSackTable;
   private boolean result;

   public SubSetSumProblemSelf(int maxSum, int[] nums) {
      this.maxSum = maxSum;
      this.nums = nums;
      this.knapSackTable = new boolean[nums.length + 1][maxSum + 1];
   }

   public boolean solve() {
      int rowIndex;
      for(rowIndex = 0; rowIndex < this.nums.length + 1; ++rowIndex) {
         this.knapSackTable[rowIndex][0] = true;
      }

      for(rowIndex = 1; rowIndex < this.nums.length + 1; ++rowIndex) {
         for(int colIndex = 1; colIndex < this.maxSum + 1; ++colIndex) {
            if (colIndex < this.nums[rowIndex - 1]) {
               this.knapSackTable[rowIndex][colIndex] = this.knapSackTable[rowIndex - 1][colIndex];
            } else if (this.knapSackTable[rowIndex - 1][colIndex]) {
               this.knapSackTable[rowIndex][colIndex] = this.knapSackTable[rowIndex - 1][colIndex];
            } else {
               this.knapSackTable[rowIndex][colIndex] = this.knapSackTable[rowIndex - 1][colIndex - this.nums[rowIndex - 1]];
            }
         }
      }

      return this.knapSackTable[this.nums.length][this.maxSum];
   }

   public boolean solve_self() {
      int i;
      for(i = 0; i < this.nums.length + 1; ++i) {
         this.knapSackTable[i][0] = true;
      }

      for(i = 1; i < this.nums.length + 1; ++i) {
         for(int j = 1; j < this.maxSum + 1; ++j) {
            if (j < i) {
               this.knapSackTable[i][j] = this.knapSackTable[i - 1][j];
            } else if (this.knapSackTable[i - 1][j] = true) {
               this.knapSackTable[i][j] = this.knapSackTable[i - 1][j];
            } else {
               this.knapSackTable[i][j] = this.knapSackTable[i - 1][j - this.nums[i - 1]];
            }
         }
      }

      return this.knapSackTable[this.nums.length][this.maxSum];
   }

   public static void main(String[] args) {
      int[] S = new int[]{5, 2, 3, 1};
      int sum = 9;
      SubSetSumProblemSelf ssp = new SubSetSumProblemSelf(sum, S);
      System.out.println(ssp.solve_self());
   }
}
