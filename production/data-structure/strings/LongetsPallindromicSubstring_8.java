package strings;

public class LongetsPallindromicSubstring_8 {
   static int resultLength;
   static int resultStart;

   public static void main(String[] args) {
      substringoptimised("aaaabbaa");
      String str = "rfkqyuqfjkxy";
      System.out.println(longestPalin(str));
   }

   public static void substring(String str) {
      int maxlength = 0;
      String finalans = "";

      for(int i = 0; i < str.length(); ++i) {
         for(int j = i + 1; j <= str.length(); ++j) {
            String s = str.substring(i, j);
            System.out.println(s);
            if (pallindrome(s) && maxlength < s.length()) {
               maxlength = s.length();
               finalans = s;
            }
         }
      }

      System.out.println(maxlength);
      System.out.println(finalans);
   }

   public static void substringoptimised(String str) {
      int[][] dp = new int[str.length()][str.length()];
      int finali = 0;
      int finalj = 0;

      for(int g = 0; g < dp.length; ++g) {
         int i = 0;

         for(int j = g; i < dp.length && j < dp.length; ++j) {
            if (g == 0) {
               dp[i][j] = 1;
            } else if (g == 1) {
               if (str.charAt(i) == str.charAt(j)) {
                  dp[i][j] = 1;
               } else {
                  dp[i][j] = 0;
               }
            } else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 1) {
               dp[i][j] = 1;
            } else {
               dp[i][j] = 0;
            }

            if (dp[i][j] == 1) {
               finali = i;
               finalj = j;
            }

            ++i;
         }
      }

      System.out.println(str.substring(finali, finalj + 1));
   }

   public static boolean pallindrome(String s) {
      int i = 0;

      for(int j = s.length() - 1; i <= j; --j) {
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }

         ++i;
      }

      return true;
   }

   static String longestPalin(String s) {
      if (s.length() < 2) {
         return s;
      } else {
         for(int start = 0; start < s.length() - 1; ++start) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
         }

         return s.substring(resultStart, resultLength + resultStart);
      }
   }

   static void expandRange(String s, int start, int end) {
      while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
         --start;
         ++end;
      }

      if (resultLength < end - start - 1) {
         resultStart = start + 1;
         resultLength = end - start - 1;
      }

   }
}
