package dynamic.programming.zero.one.knapsack;

public class KnapsackWeightValue {

	int weight[];
	int values[];
	int maxCapacity;
	int dp[][];

	public KnapsackWeightValue(int weight[], int values[], int maxCapacity) {
		this.weight = weight;
		this.values = values;
		this.maxCapacity = maxCapacity;
		this.dp = new int[values.length + 1][maxCapacity + 1];
	}

	public int maxValue() {
		// for(int i = 0; i < dp.length; i++) {
		// dp[i][0] = 0;
		// }

		for (int j = 0; j < dp[0].length; j++) {
			int w = weight[0];
			if (j >= w) {
				dp[1][j] = w;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (weight[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
				}
			}
		}
		System.out.println("------------------");
		print();
		System.out.println("------------------");
		return dp[values.length - 1][maxCapacity];
	}
	
	private void print() {
		int i = dp.length - 1;
		int j = dp[0].length - 1;
		int min = dp[i][j];
		while(j > 0 && i > 0) {
			if(dp[i - 1][j] == min) {
				i = i - 1;
			} else {
				System.out.println("# " + i);
				j = j - weight[i - 1];
				min = dp[i][j];
			}
		}
	}

	public static void main(String[] args) {
		int weight[] = { 1, 3, 4, 5 };
		int values[] = { 1, 4, 5, 7 };
		KnapsackWeightValue kwv = new KnapsackWeightValue(weight, values, 7);
		System.out.println(kwv.maxValue());
	}
}
