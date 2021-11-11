package dynamic.programming;

public class CoinChangeProblem {
	int dp[][];
	int N;
	
	CoinChangeProblem(int coins[], int N) {
		this.dp = new int[coins.length + 1][N + 1];
		this.N = N;
	}

	public int numOfWays(int coins[]) {
		
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		
		for(int j = 0; j < N + 1; j++) {
			dp[1][j] = 1;
		}
		// 1, 2, 3
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(coins[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				}
			}
		}
		System.out.println("--------------num of ways--------");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.	println();
		}
		System.out.println("--------------num of ways--------");
		System.out.println("--------------min coin--------");
		minCoin(coins);
		return dp[dp.length - 1][N];
	}
	
	public void minCoin(int coins[]) {
		this.dp = new int[coins.length + 1][N + 1];
		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		//dp[1][5] = min(dp[0][5], 1 + dp[1][0]) = 1.
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(coins[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}
		
		System.out.println("--------------coin count-----------");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.	println();
		}
		System.out.println("-------------coin count----------");
		System.out.println("----------set of coins ---------");
		printChange(coins);
	}
	
	private void printChange(int coins[]) {
		int i = dp.length - 1;
		int j = N;
		int min = dp[i][j];
		while(j > 0) {
			if(dp[i - 1][j] == min) {
				i = i - 1;
			} else {
				System.out.print(coins[i - 1] + ", ");
				j = j - coins[i - 1];
				min = dp[i][j];
			}
		}
		System.out.println();
		System.out.println("------------set of coins---------------");
	}
	
	public static void main(String[] args) {
		int coins[] = { 1, 2, 3 };
		int N = 5; 
		/// Subproblem over lapping
		// optimization  
		// memoization 
		CoinChangeProblem ccp = new CoinChangeProblem(coins, N);
		// 1, 1, 1, 1, 1 
		// 1, 1, 1, 2 
		// 2, 2, 1 
		// 2, 3, 
		// 1, 1, 3
		// output = 5
		// System.out.println(ccp.numOfWays_recursion(coins, coins.length, N));
		int a =ccp.numOfWays(coins);
		System.out.println("-----------Total num of ways----------");
		System.out.println(a);
	}

	
	// --------------------------------//
	public int numOfWays_recursion(int coins[], int index, int N) {
		if (N == 0)
			return 1;
		if (N < 0)
			return 0;
		if (index <= 0 && N >= 1)
			return 0;
		return numOfWays_recursion(coins, index - 1, N) + numOfWays_recursion(coins, index, N - coins[index - 1]);
	}

}
