package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WeightedActivitySelection {
   private Job[] jobs;

   WeightedActivitySelection(Job[] jobs) {
      this.jobs = jobs;
   }

   public int maxProfit() {
      Arrays.sort(this.jobs);
      int[] dp = new int[this.jobs.length];
      int i = 0;
      Job[] var3 = this.jobs;
      int max = var3.length;

      for(int var5 = 0; var5 < max; ++var5) {
         Job last = var3[var5];
         dp[i++] = last.profit;
      }

      int i = true;
      int j = false;

      for(i = 1; i < dp.length; ++i) {
         for(int j = 0; j < i; ++j) {
            if (this.jobs[j].finish <= this.jobs[i].start) {
               dp[i] = Math.max(this.jobs[i].profit + dp[j], dp[i]);
            }
         }
      }

      max = 0;

      for(i = 0; i < dp.length; ++i) {
         if (dp[i] > max) {
            max = dp[i];
         }
      }

      return max;
   }

   public static void main(String[] args) {
      Job[] jobs = new Job[]{new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200)};
      WeightedActivitySelection was = new WeightedActivitySelection(jobs);
      System.out.println(was.jobScheduling_LEET());
   }

   public int jobScheduling(int[] start, int[] end, int[] profit) {
      ArrayList<Pair> list = new ArrayList();

      for(int i = 0; i < start.length; ++i) {
         list.add(new Pair(start[i], end[i], profit[i]));
      }

      Collections.sort(list);
      int[] arr = new int[((Pair)list.get(list.size() - 1)).end + 1];
      arr[0] = 0;
      int k = 0;
      int i = 1;

      while(k < list.size()) {
         if (((Pair)list.get(k)).end == i) {
            arr[i] = Math.max(arr[i], Math.max(arr[i - 1], arr[((Pair)list.get(k)).start] + ((Pair)list.get(k)).profit));
            ++k;
         } else {
            arr[i] = Math.max(arr[i - 1], arr[i]);
            ++i;
         }
      }

      return arr[arr.length - 1];
   }

   public int jobScheduling_1(int[] startTime, int[] endTime, int[] profit) {
      int n = startTime.length;
      Job1[] jobs = new Job1[n];

      for(int i = 0; i < n; ++i) {
         jobs[i] = new Job1(this, startTime[i], endTime[i], profit[i]);
      }

      Arrays.sort(jobs);
      int[] dp = new int[n];
      dp[n - 1] = jobs[n - 1].profit;

      for(int i = n - 2; i >= 0; --i) {
         dp[i] = Math.max(jobs[i].profit, dp[i + 1]);

         for(int j = i + 1; j < n; ++j) {
            if (jobs[i].end <= jobs[j].start) {
               dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
               break;
            }
         }
      }

      return dp[0];
   }

   public int jobScheduling_LEET() {
      Arrays.sort(this.jobs);
      int n = this.jobs.length;
      int i = false;
      int[] dp = new int[n];
      dp[n - 1] = this.jobs[n - 1].profit;

      for(int i = n - 2; i >= 0; --i) {
         dp[i] = Math.max(this.jobs[i].profit, dp[i + 1]);

         for(int j = i + 1; j < n; ++j) {
            if (this.jobs[i].finish <= this.jobs[j].start) {
               dp[i] = Math.max(dp[i], this.jobs[i].profit + dp[j]);
               break;
            }
         }
      }

      return dp[0];
   }
}
