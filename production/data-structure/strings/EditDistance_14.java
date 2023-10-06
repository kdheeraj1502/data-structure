package strings;

public class EditDistance_14 {
   public static void main(String[] args) {
      editdistance("abc", "abd");
   }

   public static void editdistance(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int[][] dp = new int[s1.length() + 1][s2.length() + 1];

      int i;
      for(i = 0; i < dp[0].length; dp[0][i] = i++) {
      }

      for(i = 1; i < dp.length; dp[i][0] = i++) {
      }

      for(i = 1; i < dp.length; ++i) {
         for(int j = 1; j < dp[0].length; ++j) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1];
            } else {
               int replace = dp[i - 1][j - 1];
               int insert = dp[i][j - 1];
               int remove = dp[i - 1][j];
               dp[i][j] = Math.min(replace, Math.min(remove, insert)) + 1;
            }
         }
      }

      System.out.println(dp[m][n]);
   }
}
