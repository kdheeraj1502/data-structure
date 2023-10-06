package strings;

public class CountPallindromicSubsequence_22 {
   public static void main(String[] args) {
      subsequenceoptimised("abcd");
   }

   public static void subsequenceoptimised(String str) {
      int[][] dp = new int[str.length()][str.length()];

      for(int g = 0; g < dp.length; ++g) {
         int i = 0;

         for(int j = g; i < dp.length && j < dp.length; ++j) {
            if (g == 0) {
               dp[i][j] = 1;
            } else if (g == 1) {
               if (str.charAt(i) == str.charAt(j)) {
                  dp[i][j] = 3;
               } else {
                  dp[i][j] = 2;
               }
            } else if (str.charAt(i) == str.charAt(j)) {
               dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
            } else {
               dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
            }

            ++i;
         }
      }

      System.out.println(dp[0][str.length() - 1]);
   }
}
