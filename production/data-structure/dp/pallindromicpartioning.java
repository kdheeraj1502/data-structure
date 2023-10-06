package dp;

public class pallindromicpartioning {
   public static void main(String[] args) {
      System.out.println(solverec("ababbbabbababa"));
      solvedp("ababbbabbababa");
   }

   public static int solverec(String s) {
      if (s.length() != 1 && !checkpallindrome(s)) {
         int myfans = Integer.MAX_VALUE;

         for(int i = 0; i < s.length(); ++i) {
            String mys = s.substring(0, i + 1);
            String ros = s.substring(i + 1);
            if (checkpallindrome(mys)) {
               int myans = solverec(ros);
               if (myfans > myans + 1) {
                  myfans = myans + 1;
               }
            }
         }

         return myfans;
      } else {
         return 0;
      }
   }

   public static boolean checkpallindrome(String s) {
      int i = 0;

      for(int j = s.length() - 1; i < j; --j) {
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }

         ++i;
      }

      return true;
   }

   public static void solvedp(String s) {
      int[][] dp = new int[s.length()][s.length()];
      int[][] check = new int[s.length()][s.length()];

      int g;
      int i;
      int j;
      for(g = 0; g < check.length; ++g) {
         i = 0;

         for(j = g; j < check[0].length && i < check.length; ++i) {
            if (g == 0) {
               check[i][j] = 1;
            } else if (g == 1) {
               check[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
            } else if (s.charAt(i) == s.charAt(j) && check[i + 1][j - 1] == 1) {
               check[i][j] = 1;
            } else {
               check[i][j] = 0;
            }

            ++j;
         }
      }

      for(g = 0; g < dp.length; ++g) {
         i = 0;

         for(j = g; i < dp.length && j < dp[0].length; ++j) {
            if (g == 0) {
               dp[i][j] = 0;
            } else if (g == 1) {
               dp[i][j] = check[i][j] == 1 ? 0 : 1;
            } else if (check[i][j] == 1) {
               dp[i][j] = 0;
            } else {
               int min = Integer.MAX_VALUE;

               for(int k = i; k < j; ++k) {
                  int lefthalf = dp[i][k];
                  int righthalf = dp[k + 1][j];
                  if (min > lefthalf + righthalf + 1) {
                     min = lefthalf + righthalf + 1;
                  }
               }

               dp[i][j] = min;
            }

            ++i;
         }
      }

      System.out.println(dp[0][s.length() - 1]);
   }
}
