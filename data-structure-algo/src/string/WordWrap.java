package string;

import java.util.Arrays;

public class WordWrap {

	final int MAX = Integer.MAX_VALUE;
	int printSolution(int p[], int n) {
		int k;
		if (p[n] == 1)
			k = 1;
		else
			k = printSolution(p, p[n] - 1) + 1;
		System.out.println("Line number" + " " + k + ": " + "From word no." + " " + p[n] + " " + "to" + " " + n);
		return k;
	}

	void solveWordWrap(int l[], int n, int M) {
		int extras[][] = new int[n + 1][n + 1];
		int lc[][] = new int[n + 1][n + 1];
		int c[] = new int[n + 1];
		int p[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			extras[i][i] = M - l[i - 1];
			for (int j = i + 1; j <= n; j++)
				extras[i][j] = extras[i][j - 1] - l[j - 1] - 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (extras[i][j] < 0)
					lc[i][j] = MAX;
				else if (j == n && extras[i][j] >= 0)
					lc[i][j] = 0;
				else
					lc[i][j] = extras[i][j] * extras[i][j];
			}
		}
		c[0] = 0;
		for (int i = 1; i <= n; i++) {
			c[i] = MAX;
			for (int j = 1; j <= i; j++) {
				if (c[j - 1] != MAX && lc[j][i] != MAX && (c[j - 1] + lc[j][i] < c[i])) {
					c[i] = c[j - 1] + lc[j][i];
					p[i] = j;
				}
			}
		}
		
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(p));
		printSolution(p, n);
	}

	public static void main(String args[]) {
		WordWrap w = new WordWrap();
		int l[] = { 3, 2, 2, 5 };
		int n = l.length;
		int M = 6;
		w.solveWordWrap(l, n, M);
	}
}