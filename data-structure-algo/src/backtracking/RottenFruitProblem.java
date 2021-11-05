package backtracking;

import java.util.*;

public class RottenFruitProblem {

	public int rottenFruit(int[][] num) {

		Queue<Pair> queue = new ArrayDeque<>();
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if (num[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
				}
			}
		}

		int days = 0;

		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			days = Math.max(days, curr.days);
			for (int k = 0; k < x.length; k++) {
				int row = curr.x + x[k];
				int col = curr.y + y[k];
				if (isValid(num, row, col) && num[row][col] == 1) {
					queue.add(new Pair(row, col, curr.days + 1));
					num[row][col] = 2;
				}
			}
		}

		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				if(num[i][j] == 1)
					return -1;
			}
		}
		
		return days;

	}

	public int orangesRotting(int[][] grid) {
		int R = grid.length;
		int C = grid[0].length;
		// boolean[][] visited = new boolean[R][C];
		Queue<Pair> queue = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
				}
			}
		}

		int days = 0;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			days = Math.max(days, cur.days);

			for (int k = 0; k < x.length; k++) {
				int ro = cur.x + x[k];
				int co = cur.y + y[k];

				if (isValid(grid, ro, co) && grid[ro][co] == 1) {
					queue.add(new Pair(ro, co, cur.days + 1));
					grid[ro][co] = 2;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return days;
	}

	int[] x = { 0, 0, -1, 1 };
	int[] y = { -1, 1, 0, 0 };

	public boolean isValid(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int num[][] = { { 1, 0, 1, 1, 0 }, { 2, 1, 0, 1, 0 }, { 0, 0, 0, 2, 1 }, { 0, 2, 0, 0, 1 }, { 1, 1, 0, 0, 1 } };
		RottenFruitProblem rfp = new RottenFruitProblem();
		System.out.println(rfp.rottenFruit(num));
	}

	class Pair {
		int x;
		int y;
		int days;

		public Pair(int x, int y, int days) {
			this.x = x;
			this.y = y;
			this.days = days;
		}
	}
}
