package dp;

public class longestpallindromicsubstring {
   public static void main(String[] args) {
      String s = "aacabdkacaa";
      solvedp(s);
   }

   public static void solvedp(String s) {
      int[][] dp = new int[s.length()][s.length()];
      int maxi = 0;
      int maxj = 0;
      int maxlength = 0;

      for(int g = 0; g < dp.length; ++g) {
         int i = 0;

         for(int j = g; i < dp.length && j < dp[0].length; ++j) {
            if (g == 0) {
               dp[i][j] = 1;
            } else if (g == 1) {
               if (s.charAt(i) == s.charAt(j)) {
                  dp[i][j] = 2;
               }
            } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
               dp[i][j] = 2 + dp[i + 1][j - 1];
            } else {
               dp[i][j] = 0;
            }

            if (maxlength < dp[i][j]) {
               maxlength = dp[i][j];
               maxi = i;
               maxj = j;
            }

            ++i;
         }
      }

      System.out.println(s.substring(maxi, maxj + 1));
      System.out.println(maxlength);
   }
}
