package dynamic.programming;

public class MinimumScoreTriangulationofPolygon {

	public static int minScoreTriangulation(int[] values) {
		int dp[][] = new int[values.length][values.length];
		for (int g = 0; g < values.length; g++) {
			for (int i = 0, j = g; j < values.length; i++, j++) {
				if (g == 0 || g == 1)
					dp[i][j] = 0;
				else if (g == 2) {
					dp[i][j] = values[i] * values[i + 1] * values[i + 2];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						int left = dp[i][k];
						int right = dp[k][j];
						int mc = values[i] * values[j] * values[k];
						int tc = left + right + mc;
						min = Math.min(min, tc);
					}
					dp[i][j] = min;
				}
			}
		}
		return dp[0][dp.length - 1];

	}
	public static int minScoreTriangulation_1(int[] values) {
		int dp[][] = new int[values.length][values.length];
		for (int g = 0; g < values.length; g++) {
			for (int i = 0, j = g; j < values.length; i++, j++) {
				if (g == 0 || g == 1)
					dp[i][j] = 0;
				else if (g == 2) {
					dp[i][j] = values[i] * values[i + 1] * values[i + 2];
				} else {
					int min = Integer.MAX_VALUE;
					// dp[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						int left = dp[i][k];
						int right = dp[k][j];
						int mc = values[i] * values[j] * values[k];
						int tc = left + right + mc;
						min = Math.min(min, tc);
					}
					dp[i][j] = min;
				}
			}
		}
		return dp[0][dp.length - 1];

	}
	
	public static void main(String[] args) {
		int nums[] = { 3, 7, 4, 5 };
		System.out.println(minScoreTriangulation(nums));
		System.out.println(minScoreTriangulation_1(nums));
	}
}
