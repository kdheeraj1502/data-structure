package dynamic.programming;

import java.util.Stack;

public class LongestCommonSubsequence {
   String s1;
   String s2;
   int[][] dp;

   LongestCommonSubsequence(String s1, String s2) {
      this.s1 = s1;
      this.s2 = s2;
      this.dp = new int[s1.length() + 1][s2.length() + 1];
   }

   public int LCSLength() {
      int i;
      for(i = 0; i < this.dp.length; ++i) {
         this.dp[0][i] = 0;
         this.dp[i][0] = 0;
      }

      for(i = 1; i < this.dp.length; ++i) {
         for(int j = 1; j < this.dp[i].length; ++j) {
            if (this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
               this.dp[i][j] = this.dp[i - 1][j - 1] + 1;
            } else {
               this.dp[i][j] = Math.max(this.dp[i - 1][j], this.dp[i][j - 1]);
            }
         }
      }

      this.printLCS();
      return this.dp[this.s1.length()][this.s2.length()];
   }

   public void printLCS() {
      int i = this.dp.length - 1;
      int j = this.dp[0].length - 1;
      Stack<Character> stack = new Stack();

      while(j > 0 && i > 0) {
         if (this.dp[i][j] == this.dp[i - 1][j - 1] + 1 && this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
            stack.push(this.s1.charAt(i - 1));
            --i;
            --j;
         } else if (this.dp[i][j] == this.dp[i - 1][j]) {
            --i;
         } else {
            --j;
         }
      }

      while(!stack.isEmpty()) {
         System.out.print(stack.pop() + ", ");
      }

      System.out.println();
   }

   public static void main(String[] args) {
      String s1 = "acbcf";
      String s2 = "abcdaf";
      LongestCommonSubsequence lcs = new LongestCommonSubsequence(s1, s2);
      System.out.println(lcs.LCSLength());
   }
}
