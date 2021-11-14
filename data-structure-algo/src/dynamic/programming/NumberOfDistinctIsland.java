package dynamic.programming;

import java.util.*;

public class NumberOfDistinctIsland {

	private int grid[][];

	public NumberOfDistinctIsland(int grid[][]) {
		this.grid = grid;
	}

	public int numDistinctIslands() {
		int m = grid.length, n = grid[0].length;
		Set<List<List<Integer>>> distinctIslands = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<List<Integer>> island = new ArrayList<>();
				if (grid[i][j] == 1) {
					dfs(i, j, i, j, island);
					distinctIslands.add(island);
				}
			}
		}
		distinctIslands.stream().forEach(list -> System.out.println(list));
		return distinctIslands.size();
	}

	private void dfs(int i, int j, int row, int col, List<List<Integer>> island) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0)
			return;
		grid[row][col] = 0;
		island.add(Arrays.asList(row - i, col - j));
		dfs(i, j, row - 1, col, island);
		dfs(i, j, row, col + 1, island);
		dfs(i, j, row + 1, col, island);
		dfs(i, j, row, col - 1, island);
	}

	public static void main(String[] args) {
		int grid[][] = { 
				{ 1, 1, 0, 1, 1 }, 
				{ 1, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 1 }, 
				{ 1, 1, 0, 1, 1 } 
				};
		NumberOfDistinctIsland ndi = new NumberOfDistinctIsland(grid);
		System.out.println(ndi.numDistinctIslands());
	}
}
