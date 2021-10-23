package dynamic.programming.knapsack;

public class KnapsackProblemWithRecursion {

	public static void main(String[] args) {
		int numOfItems = 3;
		int capacityOfKnapsack = 5;
		int weights[] = { 4, 2, 3 };
		int values[] = { 10, 4, 7 };
		KnapsackProblemWithRecursion kp = new KnapsackProblemWithRecursion();
		System.out.println(kp.solveRecursion(capacityOfKnapsack, weights, values, numOfItems));
	}

	public int solveRecursion(int m, int[] w, int[] v, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (w[n - 1] > m) {
			return solveRecursion(m, w, v, n - 1);
		} else {
			// given item can fit into the knapsack so we have 2 options (include, exclude)
			int included = v[n - 1] + solveRecursion(m - w[n - 1], w, v, n - 1);
			int excluded = solveRecursion(m, w, v, n - 1);
			return Math.max(included, excluded);
		}
	}

}
