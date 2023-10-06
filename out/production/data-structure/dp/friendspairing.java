package dp;

public class friendspairing {
   public static void main(String[] args) {
      String s = "12345";
      recursivesolveprint(s, "");
      System.out.println(recursivesolvecount(5));
      System.out.println(countFriendsPairings(5));
   }

   public static void recursivesolveprint(String s, String ans) {
      if (s.length() == 0) {
         System.out.println(ans);
      } else {
         String ros = s.substring(1);
         recursivesolveprint(ros, ans + "{" + s.charAt(0) + "}");

         for(int i = 1; i < s.length(); ++i) {
            String pair = "{" + s.charAt(0) + s.charAt(i) + "}";
            String res = s.substring(1, i) + s.substring(i + 1);
            recursivesolveprint(res, ans + pair);
         }

      }
   }

   public static int recursivesolvecount(int n) {
      if (n == 0) {
         return 0;
      } else if (n == 1) {
         return 1;
      } else if (n == 2) {
         return 2;
      } else {
         int myans = 0;
         myans += recursivesolvecount(n - 1);
         myans += recursivesolvecount(n - 2) * (n - 1);
         return myans;
      }
   }

   public static long countFriendsPairings(int n) {
      int mod = 1000000007;
      if (n == 0) {
         return 0L;
      } else if (n == 1) {
         return 1L;
      } else if (n == 2) {
         return 2L;
      } else {
         long[] dp = new long[n + 1];
         dp[0] = 0L;
         dp[1] = 1L;
         dp[2] = 2L;

         for(int i = 3; i < dp.length; ++i) {
            dp[i] = (dp[i - 1] + (long)(i - 1) * dp[i - 2]) % (long)mod;
         }

         return dp[n];
      }
   }
}
