package backtracking;

public class UniqueBinarySearchTree {
   public static int generateTrees(int n) {
      int[] dp = new int[n + 1];
      dp[0] = dp[1] = 1;

      for(int i = 2; i <= n; ++i) {
         for(int j = 1; j <= i; ++j) {
            dp[i] += dp[j - 1] * dp[i - j];
         }
      }

      return dp[n];
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 3, 4, 5, 6, 7};
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int in = var2[var4];
         System.out.println(in + " : " + generateTrees(3));
      }

   }
}
