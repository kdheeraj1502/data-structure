package dp;

public class longestpallindromicsubsequence {
   public static void main(String[] args) {
      String s = "aab";
      System.out.println(solverec(s, 0, s.length() - 1));
      solvedp(s);
   }

   public static int solverec(String s, int i, int j) {
      if (i > j) {
         return 0;
      } else if (i == j) {
         return 1;
      } else {
         return s.charAt(i) == s.charAt(j) ? 2 + solverec(s, i + 1, j - 1) : Math.max(solverec(s, i + 1, j), solverec(s, i, j - 1));
      }
   }

   public static void solvedp(String s) {
      int[][] dp = new int[s.length()][s.length()];

      for(int g = 0; g < dp.length; ++g) {
         int i = 0;

         for(int j = g; i < dp.length && j < dp[0].length; ++j) {
            if (g == 0) {
               dp[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
               dp[i][j] = 2 + dp[i + 1][j - 1];
            } else {
               dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }

            ++i;
         }
      }

      System.out.println(dp[0][s.length() - 1]);
   }
}
