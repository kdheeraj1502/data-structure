package dynamic.programming;


// COUNT OF COIN
public class MinimumCoin {
	
	// consist of count of required coin
	
	// for example 1 rupee required as per total amount 
	// 0 times 1 ruppee, 1 times 1 rupee, 2 times 1 rupee, .. 11 times 1 rupee 
	// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
	int dp[][];
	int total;
	
	MinimumCoin(int coins[], int n){
		this.dp = new int[coins.length][n + 1];
		this.total = n;
	}

	public void minCoin(int coins[]) {
		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		//dp[1][5] = min(dp[0][5], 1 + dp[1][0]) = 1.
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(coins[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.	println();
		}
		System.out.println("---------- coins ---------");
		printChange(coins);
	}
	
	private void printChange(int coins[]) {
		int i = coins.length - 1;
		int j = total;
		int min = dp[i][j];
		System.out.println("------set of coins-------");
		while(j > 0) {
			if(dp[i - 1][j] == min) {
				i = i - 1;
			} else {
				System.out.print(coins[i] + ", ");
				j = j - coins[i];
				min = dp[i][j];
			}
		}
		System.out.println();
		System.out.println("------set of coins-------");
	}

	public static void main(String[] args) {
		//int coins[] = { 1, 5, 6, 8 };
		int coins[] = { 1, 2, 3 };
		//MinimumCoin mc = new MinimumCoin(coins, 11);
		MinimumCoin mc = new MinimumCoin(coins, 5);
		mc.minCoin(coins);
	}
}
