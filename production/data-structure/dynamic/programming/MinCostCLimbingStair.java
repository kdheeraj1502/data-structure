package dynamic.programming;

public class MinCostCLimbingStair {
   public static int minCostClimbingStairs(int[] cost) {
      int[] dp = new int[cost.length + 1];
      dp[0] = cost[0];
      dp[1] = cost[1];

      int i;
      for(i = 2; i < dp.length; ++i) {
         if (i > cost.length - 1) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]);
         } else {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
         }
      }

      i = dp.length;
      return Math.min(dp[i - 1], dp[i - 2]);
   }

   public static int minCostClimbingStairs_recursion(int[] cost) {
      return minCost(cost.length - 1, cost);
   }

   private static int minCost(int i, int[] cost) {
      if (i < 0) {
         return 0;
      } else {
         return i != 0 && i != 1 ? cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost)) : cost[i];
      }
   }

   public static int minCostClimbingStairs_optimization(int[] cost) {
      int dpOne = cost[0];
      int dpTwo = cost[1];

      for(int i = 2; i < cost.length; ++i) {
         int current = cost[i] + Math.min(dpTwo, dpOne);
         dpOne = dpTwo;
         dpTwo = current;
      }

      return Math.min(dpOne, dpTwo);
   }

   public static void main(String[] args) {
      int[] cost = new int[]{10, 15, 20};
      System.out.println(minCostClimbingStairs(cost));
      System.out.println(minCostClimbingStairs_recursion(cost));
      System.out.println(minCostClimbingStairs_optimization(cost));
   }
}
