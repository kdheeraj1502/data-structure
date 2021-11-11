package dynamic.programming;

// Crossing 1 or 2 step and cost is getting added
// we have to cross the intire array
// cost  array is step cost, choose min cost array value, 
// add them all and find the min cost to cross
public class MinCostCLimbingStair {

	public static int minCostClimbingStairs(int[] cost) {
		// Its a min cost array , it will store min cost through out the steps
		int dp[] = new int[cost.length + 1];
		// Starting from nothing we can reach either on 1st index or second index
		// The cost will the cost of zero or first index to cross the array
		// Hence the minCost dp array will have only step cost present in cost array
		dp[0] = cost[0];
		dp[1] = cost[1];
		// Starting from step 2 we got the 0 and 1 index min cost already above
		// Now at index 2 either we move from 0 index or 1st index which ever is lower
		// In price
		// Hence the min cost is min cost of 0 or min cost of 1, plus the reach
		// Step/index cost
		// i.e. min(dp[0], dp[1]) which ever is lower
		// Plus/+ the reached step/index cost or the current step cost which is cost[2]
		// min(dp[0], dp[1]) + cost[2];
		// Run the loop in such manner and collect the min cost amount in dp array/min
		// Cost array
		for (int i = 2; i < dp.length; i++) {
			if (i > cost.length - 1) {
				// either call recursion on previous 2 steps or
				// use memoization dp array of previous 2 steps
				dp[i] = Math.min(dp[i - 2], dp[i - 1]);
			} else
				dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
		}
		int n = dp.length;
		// returning previous 2 steps min value because we will be either
		// on last index or second index to cross
		return Math.min(dp[n - 1], dp[n - 2]);
	}

	// Same solution through recursion without memoization
	public static int minCostClimbingStairs_recursion(int[] cost) {
		return minCost(cost.length - 1, cost);
	}

	private static int minCost(int i, int cost[]) {
		if (i < 0)
			return 0;
		if (i == 0 || i == 1)
			return cost[i];
		return cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost));
	}
	
	// Time complexity = O(N)
	// space complexity = O(1)
	public static int minCostClimbingStairs_optimization(int[] cost) {
		int dpOne = cost[0];
		int dpTwo = cost[1];
		
		for(int i = 2; i < cost.length; i++) {
			int current = cost[i] + Math.min(dpTwo, dpOne);
			dpOne = dpTwo;
			dpTwo = current;
		}
		return Math.min(dpOne, dpTwo);
	}

	public static void main(String[] args) {
		int cost[] = { 10, 15, 20 };
		System.out.println(minCostClimbingStairs(cost));
		System.out.println(minCostClimbingStairs_recursion(cost));
		System.out.println(minCostClimbingStairs_optimization(cost));
	}
}
