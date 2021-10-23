package dynamic.programming.knapsack;

public class KnapSackWeightAndValue {
	
	private int[][] dp;
	private int numOfItems;
	private int capacity;
	private int profit;
	private int values[];
	private int weights[];
	
	public KnapSackWeightAndValue(int numOfItems, int capacity, int values[], int weights[]) {
		this.numOfItems = numOfItems;
		this.capacity = capacity;
		this.values = values;
		this.weights = weights;
		
		this.dp = new int[numOfItems + 1][capacity + 1];
	}

	public void showResult() {
		for(int  n = numOfItems, w = capacity; n > 0; n--) {
			if(dp[n][w] != 0 && dp[n][w] != dp[n - 1][w]) {
				System.out.println("We take item : #" + n);
				w = w - weights[n - 1];
			}else {
				n--;
			}
		}
	}
	private void solve() {
		for(int i = 1; i < numOfItems + 1; i++) {
			for(int j = 1; j < capacity + 1; j++) {
				int notTaken = dp[i - 1][j];
				int taken = 0;
				if(weights[i - 1] <= j) {
					taken = values[i - 1] + dp[i - 1][j - weights[i - 1]];
				}
				dp[i][j] = Math.max(notTaken, taken);
			}
		}
		profit = dp[numOfItems][capacity];
		System.out.println(profit);
	}

	public static void main(String[] args) {
		int numOfItems = 3;
		int capacityOfKnapsack = 5;
		int weights[] = { 4, 2, 3 };
		int values[] = { 10, 4, 7 };
		KnapSackWeightAndValue kwv= new KnapSackWeightAndValue(numOfItems, capacityOfKnapsack, values, weights);
		kwv.solve();
		kwv.showResult();
	}
}
