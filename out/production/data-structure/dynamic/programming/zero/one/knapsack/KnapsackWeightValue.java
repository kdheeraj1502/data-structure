package dynamic.programming.zero.one.knapsack;

public class KnapsackWeightValue {
   int[] weight;
   int[] values;
   int maxCapacity;
   int[][] dp;

   public KnapsackWeightValue(int[] weight, int[] values, int maxCapacity) {
      this.weight = weight;
      this.values = values;
      this.maxCapacity = maxCapacity;
      this.dp = new int[values.length + 1][maxCapacity + 1];
   }

   public int maxValue() {
      int i;
      int j;
      for(i = 0; i < this.dp[0].length; ++i) {
         j = this.weight[0];
         if (i >= j) {
            this.dp[1][i] = j;
         }
      }

      for(i = 1; i < this.dp.length; ++i) {
         for(j = 1; j < this.dp[0].length; ++j) {
            if (this.weight[i - 1] > j) {
               this.dp[i][j] = this.dp[i - 1][j];
            } else {
               this.dp[i][j] = Math.max(this.values[i - 1] + this.dp[i - 1][j - this.weight[i - 1]], this.dp[i - 1][j]);
            }
         }
      }

      System.out.println("------------------");
      this.print();
      System.out.println("------------------");
      return this.dp[this.values.length - 1][this.maxCapacity];
   }

   private void print() {
      int i = this.dp.length - 1;
      int j = this.dp[0].length - 1;
      int min = this.dp[i][j];

      while(j > 0 && i > 0) {
         if (this.dp[i - 1][j] == min) {
            --i;
         } else {
            System.out.println("# " + i);
            j -= this.weight[i - 1];
            min = this.dp[i][j];
         }
      }

   }

   public static void main(String[] args) {
      int[] weight = new int[]{1, 3, 4, 5};
      int[] values = new int[]{1, 4, 5, 7};
      KnapsackWeightValue kwv = new KnapsackWeightValue(weight, values, 7);
      System.out.println(kwv.maxValue());
   }
}
