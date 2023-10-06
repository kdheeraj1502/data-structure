package strings;

public class WildCardCharactersStringMatching_39 {
   public static void main(String[] args) {
      wildcard("baaabab", "ba*a?");
   }

   public static void wildcard(String s1, String pat) {
      int[][] dp = new int[pat.length() + 1][s1.length() + 1];
      dp[pat.length()][s1.length()] = 1;

      int i;
      int j;
      for(i = dp.length - 2; i >= 0; --i) {
         for(j = s1.length(); j >= 0; --j) {
            if (j == s1.length()) {
               if (pat.charAt(i) == '*') {
                  dp[i][j] = dp[i + 1][j];
               }
            } else if (pat.charAt(i) != s1.charAt(j) && pat.charAt(i) != '?') {
               if (pat.charAt(i) == '*' && (dp[i][j + 1] == 1 || dp[i + 1][j] == 1)) {
                  dp[i][j] = 1;
               }
            } else {
               dp[i][j] = dp[i + 1][j + 1];
            }
         }
      }

      for(i = 0; i < dp.length; ++i) {
         for(j = 0; j < dp[0].length; ++j) {
            System.out.print(dp[i][j] + " ");
         }

         System.out.println();
      }

      System.out.println(dp[0][0]);
   }
}
