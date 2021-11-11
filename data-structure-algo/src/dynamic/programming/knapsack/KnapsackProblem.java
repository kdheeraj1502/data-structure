package dynamic.programming.knapsack;

public class KnapsackProblem {

	private int numOfItems;
	private int totalBenefit;
	private int knapSackTable[][];
	private int capacityOfKnapsack;
	private int weights[];
	private int values[];

	KnapsackProblem(int numOfItems, int capacityOfKnapsack, int weights[], int values[]) {
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.weights = weights;
		this.values = values;
		this.knapSackTable = new int[numOfItems + 1][capacityOfKnapsack + 1];
	}
	
	private void solve() {
		for(int i = 1; i < numOfItems + 1; i++) {
			for(int j = 1; j < capacityOfKnapsack + 1; j++) {
				int notTaken = knapSackTable[i - 1][j];
				int taken = 0;
				if(weights[i - 1] <= j) {
					taken = values[i - 1] + knapSackTable[i - 1][j - weights[i - 1]];
				}
				knapSackTable[i][j] = Math.max(notTaken, taken);
			}
		}
		totalBenefit = knapSackTable[numOfItems][capacityOfKnapsack];
		System.out.println(totalBenefit);
	}
	/*
	 * public void solve() { for (int i = 1; i < numOfItems + 1; i++) { for (int w =
	 * 1; w < capacityOfKnapsack + 1; w++) { int notTakingItem = knapSackTable[i -
	 * 1][w]; int takingItem = 0; if (weights[i - 1] <= w) { takingItem = values[i -
	 * 1] + knapSackTable[i - 1][w - weights[i - 1]]; } knapSackTable[i][w] =
	 * Math.max(notTakingItem, takingItem); } } totalBenefit =
	 * knapSackTable[numOfItems][capacityOfKnapsack];
	 * System.out.println("TotalBenefit : " + totalBenefit); }
	 */

	public void showResult() {
		for (int n = numOfItems, w = capacityOfKnapsack; n > 0; n--) {
			if (knapSackTable[n][w] != 0 && knapSackTable[n][w] != knapSackTable[n - 1][w]) {
				System.out.println("We take item : #" + n);
				w = w - weights[n - 1];
			}
		}
	}
	
	public static void main(String[] args) {
		//int numOfItems = 3;
	//	int capacityOfKnapsack = 5;
	//	int weights[] = { 4, 2, 3 };
	//	int values[] = { 10, 4, 7 };
		
		int numOfItems = 4;
		int capacityOfKnapsack = 7;
		int weights[] = { 1, 3, 4, 5 };
		int values[] = { 1, 4, 5, 7 };
		KnapsackProblem kp = new KnapsackProblem(numOfItems, capacityOfKnapsack, weights, values);
		kp.solve();
		kp.showResult();
	}
}
