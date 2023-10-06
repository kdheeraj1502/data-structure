package dp;

public class coingamewinner {
   public static void main(String[] args) {
      System.out.println(solve(5, 4, 3));
      System.out.println(solve(2, 4, 3));
      solvedp(5, 4, 3);
      solvedp(2, 4, 3);
   }

   public static boolean solve(int n, int x, int y) {
      if (n == 0) {
         return false;
      } else if (n == 1) {
         return true;
      } else {
         return !solve(n - 1, x, y) || n >= x && !solve(n - x, x, y) || n >= y && !solve(n - y, x, y);
      }
   }

   public static void solvedp(int n, int x, int y) {
      int[] dp = new int[n + 1];
      dp[0] = -1;
      dp[1] = 1;

      for(int i = 2; i < dp.length; ++i) {
         if (dp[i - 1] != -1 && (i < x || dp[i - x] != -1) && (i < y || dp[i - y] != -1)) {
            dp[i] = -1;
         } else {
            dp[i] = 1;
         }
      }

      if (dp[n] == 1) {
         System.out.println(true);
      } else {
         System.out.println(false);
      }

   }
}
