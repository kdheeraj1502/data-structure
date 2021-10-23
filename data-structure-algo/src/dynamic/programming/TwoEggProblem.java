package dynamic.programming;

/**
 * m is total floor x is egg drop floor n is total egg
 * 
 * if egg breaks break = drop(n - 1, x - 1),
 * 
 * if egg doesnt break noBreak = drop(n, m - x);
 * 
 * min{max(break, noBreak)};
 * 
 * table of eggs count in row and floor count in column dp[i][j] i eggs, j floor
 * 
 * 1st row in dp[i][j] floor is all column num value in each column bcz we have
 * 1 egg and will require same number of drop as number of floor. The drop from
 * each floor 1st column will have value 1 in each row bcz 1 floor will require
 * 1 drop doesnt matter number of eggs
 * 
 * 
 * @author dheerajkumar02
 *
 */
public class TwoEggProblem {

	private int dp[][] = new int[Constants.NUM_OF_EGGS + 1][Constants.NUM_OF_FLOORS + 1];

	public int solve() {
		dp[0][0] = 1;
		dp[1][0] = 1;

		for (int i = 1; i <= Constants.NUM_OF_FLOORS; i++) {
			dp[1][i] = i;
		}

		for (int n = 2; n <= Constants.NUM_OF_EGGS; n++) {
			for (int m = 1; m <= Constants.NUM_OF_FLOORS; m++) {
				dp[n][m] = Integer.MAX_VALUE;
				for (int x = 1; x <= m; x++) {
					int maxDrops = 1 + Math.max(dp[n][m - x], dp[n - 1][x - 1]);

					if (maxDrops < dp[n][m]) {
						dp[n][m] = maxDrops;
					}
				}
			}
		}

		return dp[Constants.NUM_OF_EGGS][Constants.NUM_OF_FLOORS];
	}

	public static void main(String[] args) {
		TwoEggProblem tep = new TwoEggProblem();
		System.out.println("Minimum number of drops to find the critical floor: " + tep.solve());
	}
}
