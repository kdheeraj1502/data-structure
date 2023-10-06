package dynamic.programming;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubSequence {
   int[] num;
   int[] dp;

   public LongestIncreasingSubSequence(int[] num) {
      this.num = num;
      this.dp = new int[num.length];
   }

   public int LIS() {
      int i = true;
      int j = false;
      Arrays.fill(this.dp, 1);

      for(int i = 1; i < this.num.length; ++i) {
         for(int j = 0; j < i; ++j) {
            if (this.num[i] > this.num[j] && this.dp[i] < this.dp[j] + 1) {
               this.dp[i] = this.dp[j] + 1;
            }
         }
      }

      System.out.println(Arrays.toString(this.dp));
      System.out.println();
      this.print(this.dp[this.num.length - 1]);
      System.out.println();
      return this.dp[this.num.length - 1];
   }

   private void print(int maxLength) {
      int i;
      for(i = this.dp.length - 1; this.dp[i] < maxLength; --i) {
      }

      Stack<Integer> stack = new Stack();
      int curr = this.num[i];
      stack.push(this.num[i]);
      --maxLength;

      while(maxLength > 0) {
         --i;
         if (this.dp[i] == maxLength && this.num[i] < curr) {
            stack.push(this.num[i]);
            curr = this.num[i];
            --maxLength;
         }
      }

      while(!stack.isEmpty()) {
         System.out.print(stack.pop() + ", ");
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{3, 4, -1, 0, 6, 2, 3};
      LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence(num);
      System.out.println(lis.LIS());
   }
}
