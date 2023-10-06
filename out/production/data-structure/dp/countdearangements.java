package dp;

public class countdearangements {
   public static void main(String[] args) {
      System.out.println(solverec(4));
      solvedp(4);
   }

   public static int solverec(int n) {
      if (n == 1) {
         return 0;
      } else {
         return n == 2 ? 1 : (n - 1) * (solverec(n - 1) + solverec(n - 2));
      }
   }

   public static void solvedp(int n) {
      int[] dp = new int[n + 1];
      dp[1] = 0;
      dp[2] = 1;

      for(int i = 3; i < dp.length; ++i) {
         dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
      }

      System.out.println(dp[n]);
   }
}
