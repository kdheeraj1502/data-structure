package greedy;

import java.util.Arrays;

public class jobsequencingproblem {
   public static void main(String[] args) {
      Job[] arr = new Job[]{new Job(20, 4), new Job(10, 1), new Job(40, 1), new Job(30, 1)};
      JobScheduling(arr, arr.length);
   }

   public static void JobScheduling(Job[] arr, int n) {
      Arrays.sort(arr, new 1());
      int maxdeadline = 0;

      for(int i = 0; i < arr.length; ++i) {
         if (maxdeadline < arr[i].deadline) {
            maxdeadline = arr[i].deadline;
         }
      }

      int[] sheduler = new int[maxdeadline + 1];

      int maxprofit;
      for(maxprofit = 0; maxprofit < sheduler.length; ++maxprofit) {
         sheduler[maxprofit] = -1;
      }

      maxprofit = 0;
      int c = 0;

      for(int i = 0; i < arr.length; ++i) {
         int dead = arr[i].deadline;

         for(int j = dead; j >= 1; --j) {
            if (sheduler[j] == -1) {
               ++c;
               sheduler[j] = arr[i].profit;
               maxprofit += arr[i].profit;
               break;
            }
         }
      }

      System.out.println(maxprofit);
   }
}
