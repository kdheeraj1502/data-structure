package array;

import java.util.concurrent.atomic.AtomicInteger;

public class MakingLargeIsland {

	public static int largestIsland(int[][] grid) {
		int found = 0;
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					found = 1;
					max = Math.max(max, largestIsland(grid, i, j, new AtomicInteger(1)));
				}
			}
		}
		if (found == 0) {
			max = 1;
		}
		return max;
	}

	public static int largestIsland(int[][] grid, int row, int col, AtomicInteger extra) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
			return 0;
		}
		if (grid[row][col] == 0 && extra.get() == 0) {
			return 0;
		}
		if (grid[row][col] == 0 && extra.get() == 1) {
			extra = new AtomicInteger(0);
			return 1;
		}
		grid[row][col] = 0;
		int count = 1;
		count += largestIsland(grid, row + 1, col, extra);
		count += largestIsland(grid, row - 1, col, extra);
		count += largestIsland(grid, row, col + 1, extra);
		count += largestIsland(grid, row, col - 1, extra);
		return count;
	}

	public static void main(String[] args) {
		int grid[][] = { 
				{ 1, 1 }, 
				{ 1, 0 } 
				};
		
		System.out.println(largestIsland(grid));
	}
}