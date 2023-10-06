package dp;

import java.util.Arrays;

public class weightedjobscheduling {
   public static void main(String[] args) {
   }

   public static void solvedp(pair[] jobs) {
      Arrays.parallelSort(jobs);
      int[] dp = new int[jobs.length];

      int i;
      for(i = 0; i < dp.length; ++i) {
         dp[i] = jobs[i].p;
      }

      for(i = 0; i < dp.length; ++i) {
         int inc = jobs[i].p;

         for(int j = i - 1; j >= 0; --j) {
            if (jobs[j].e <= jobs[i].s) {
               inc += dp[j];
               break;
            }
         }

         dp[i] = Math.max(inc, dp[i - 1]);
      }

      for(i = 0; i < dp.length; ++i) {
         System.out.print(dp[i] + " ");
      }

   }
}
