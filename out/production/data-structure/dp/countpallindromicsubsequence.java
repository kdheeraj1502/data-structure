package dp;

public class countpallindromicsubsequence {
   public static void main(String[] args) {
   }

   long countPS(String s) {
      long[][] dp = new long[s.length()][s.length()];
      int mod = 1000000007;

      for(int g = 0; g < s.length(); ++g) {
         int i = 0;

         for(int j = g; i < dp.length && j < dp[0].length; ++j) {
            if (g == 0) {
               dp[i][j] = 1L;
            } else if (s.charAt(i) == s.charAt(j)) {
               dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1L) % (long)mod;
            } else {
               dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + (long)mod) % (long)mod;
            }

            ++i;
         }
      }

      return dp[0][s.length() - 1];
   }
}
