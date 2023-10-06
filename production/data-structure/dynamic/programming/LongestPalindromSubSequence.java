package dynamic.programming;

public class LongestPalindromSubSequence {
   String s;
   int[][] dp;

   public LongestPalindromSubSequence(String s) {
      this.s = s;
      this.dp = new int[s.length()][s.length()];
   }

   public int countPalindrom() {
      boolean[][] dp = new boolean[this.s.length()][this.s.length()];

      int length;
      for(length = 0; length < dp.length; ++length) {
         dp[length][length] = true;
      }

      for(length = 0; length < dp.length - 1; ++length) {
         if (this.s.charAt(length) == this.s.charAt(length + 1)) {
            dp[length][length + 1] = true;
         } else {
            dp[length][length + 1] = false;
         }
      }

      int i;
      int i;
      for(length = 3; length <= dp.length; ++length) {
         for(i = 0; i <= this.s.length() - length; ++i) {
            i = i + length - 1;
            if (this.s.charAt(i) == this.s.charAt(i)) {
               dp[i][i] = dp[i + 1][i - 1];
            } else {
               dp[i][i] = false;
            }
         }
      }

      i = 0;

      for(i = 0; i < dp.length; ++i) {
         for(int j = i; j < dp.length; ++j) {
            if (dp[i][j]) {
               ++i;
            }
         }
      }

      return i;
   }

   public int maxPalindrom() {
      int n = this.s.length();

      int length;
      for(length = 0; length < n; ++length) {
         this.dp[length][length] = 1;
      }

      for(length = 0; length <= n - 2; ++length) {
         if (this.s.charAt(length) == this.s.charAt(length + 1)) {
            this.dp[length][length + 1] = 2;
         } else {
            this.dp[length][length + 1] = 1;
         }
      }

      for(length = 3; length <= this.dp.length; ++length) {
         for(int i = 0; i <= n - length; ++i) {
            int j = i + length - 1;
            if (this.s.charAt(i) == this.s.charAt(j)) {
               this.dp[i][j] = 2 + this.dp[i + 1][j - 1];
            } else {
               this.dp[i][j] = Math.max(this.dp[i + 1][j], this.dp[i][j - 1]);
            }
         }
      }

      return this.dp[0][n - 1];
   }

   public static void main(String[] args) {
      String s = "agbdba";
      String output = "abdba";
      LongestPalindromSubSequence lps = new LongestPalindromSubSequence(s);
      System.out.println(lps.maxPalindrom());
      System.out.println(lps.countPalindrom());
   }
}
