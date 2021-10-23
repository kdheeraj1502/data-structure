package dynamic.programming.knapsack;

public class RodCuttingSelf {

	private int length;
	private int amount[];
	private int dp[][];
	private int profit;

	public RodCuttingSelf(int length, int amount[]) {
		this.length = length;
		this.amount = amount;
		this.dp = new int[amount.length + 1][length + 1];
	}

	public void solve() {
		for (int i = 1; i < amount.length + 1; i++) {
			for (int j = 1; j < length + 1; j++) {
				if (i <= j) {
					dp[i][j] = Math.max(amount[i - 1] + dp[i - 1][j - i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		profit = dp[amount.length][length];
		System.out.println(profit);
	}
	
	public void showResult() {
		for(int n = amount.length, w = length; n > 0; n--) {
			if(dp[n][w] != 0 && dp[n][w] != dp[n - 1][w]) {
				System.out.println("We make cut: " + (n - 1));
				w = w - n;
			}else {
				n--;
			}
		}
	}

	public static void main(String[] args) {
		int lengthOfRod = 5;
		int[] prices = { 2, 5, 7, 3, 9 };

		RodCuttingSelf rcs = new RodCuttingSelf(lengthOfRod, prices);
		rcs.solve();
		rcs.showResult();
	}
}
