package dynamic.programming;

public class RodCuttingProblem {
	
	int prices[];
	int N;
	int dp[][];

	public RodCuttingProblem(int prices[], int N) {
		this.prices = prices;
		this.N = N;
		this.dp = new int[prices.length][N + 1];
	}
	
	public int maxProfit() {
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(i > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(prices[i - 1] + dp[i - 1][j - i], dp[i - 1][j]);
				}
			}
		}
		return dp[prices.length - 1][N];
		
	}
	
	public static void main(String[] args) {
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		RodCuttingProblem rcp = new RodCuttingProblem(price, 8);
		System.out.println(rcp.maxProfit());
	}
}
