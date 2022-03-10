package geekForGeek;

import java.util.Vector;

public class QueriesOnArray {

	static void PerformQueries(int[] a, int[][] vec) {

		Vector<Integer> ans = new Vector<>();

		// Size of the array with
		// 1-based indexing
		int n = (int) a.length - 1;

		// Number of queries
		int q = (int) vec.length;

		// Iterating through the queries
		for (int i = 0; i < q; ++i) {

			long t = vec[i][0];
			int m = vec[i][1];

			// If m is more than the
			// size of the array
			if (m > n) {
				ans.add(-1);
				continue;
			}

			// Count of turns
			int turn = (int) (t / n);

			// Find the remainder
			int rem = (int) (t % n);

			// If the remainder is 0 and turn is
			// odd then the array is empty
			if (rem == 0 && turn % 2 == 1) {
				ans.add(-1);
				continue;
			}

			// If the remainder is 0 and turn is
			// even then array is full and
			// is in its initial state
			if (rem == 0 && turn % 2 == 0) {
				ans.add(a[m]);
				continue;
			}

			// If the remainder is not 0
			// and the turn is even
			if (turn % 2 == 0) {

				// Current size of the array
				int cursize = n - rem;

				if (cursize < m) {
					ans.add(-1);
					continue;
				}
				ans.add(a[m + rem]);
			} else {

				// Current size of the array
				int cursize = rem;
				if (cursize < m) {
					ans.add(-1);
					continue;
				}
				ans.add(a[m]);
			}
		}

		// Print the result
		for (int i : ans)
			System.out.print(i + "\n");
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int[][] Q = { { 1, 4 }, { 6, 1 }, { 3, 5 } };
		PerformQueries(arr, Q);
	}
}
