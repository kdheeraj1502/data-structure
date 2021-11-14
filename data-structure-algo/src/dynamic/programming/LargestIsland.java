package dynamic.programming;

import java.util.Arrays;

/**
 * 
 * FIND AREA WHERE THE NUMBER OF 1 IS MAXIMUM AND THEY ARE ALL CONNECT IN SOME MANNER
 * EITHER VERTICALLY OR HORIZONTALY OR DIGONALLY CONNECTED OR CONNECTTHROUGH ALL 6 SIDES
 * 
 * 
 * 1 IS ISLAND AND 0 IS WATER
 * 
 * @author dheerajkumar02
 *
 */
public class LargestIsland {

	int graph[][];
	int dp[][];
	int visted[][];

	LargestIsland(int graph[][]) {
		this.graph = graph;
		this.dp = new int[graph.length][graph[0].length];
		this.visted = new int[graph.length][graph[0].length];
		initialize();
	}

	private void initialize() {
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(this.dp[i], Integer.MAX_VALUE);
		}
	}

	public int largestIsland(int row, int col, int value) {
		if (row < 0 || row >= graph.length || col < 0 || col >= graph[row].length || graph[row][col] == 0)
			return 0;
		graph[row][col] = 0;
		return 1 + largestIsland(row - 1, col, value) + largestIsland(row - 1, col + 1, value)
				+ largestIsland(row, col + 1, value) + largestIsland(row + 1, col + 1, value)
				+ largestIsland(row + 1, col, value) + largestIsland(row + 1, col - 1, value)
				+ largestIsland(row, col - 1, value) + largestIsland(row - 1, col - 1, value);
	}

	public int solve() {
		int maxVal = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				// ONLY GO TO ISLAND VERTEX
				if(graph[i][j] == 1)
					maxVal = Math.max(maxVal, largestIsland(i, j, graph[i][j]));
			}
		}
		return maxVal;
	}

	public static void main(String[] args) {
		/*
		 * int graph[][] = { { 1, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0 }, { 0, 1, 1, 1, 1 }, {
		 * 0, 1, 0, 0, 0 }, { 1, 1, 0, 0, 1 } };
		 */
		int graph[][] = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		LargestIsland li = new LargestIsland(graph);
		System.out.println(li.solve());
	}
}
