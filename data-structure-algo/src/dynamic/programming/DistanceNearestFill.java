package dynamic.programming;

import java.util.Arrays;

public class DistanceNearestFill {

	int graph[][];
	int dp[][];

	DistanceNearestFill(int graph[][]) {
		this.graph = graph;
		this.dp = new int[graph.length][graph.length];
		initialize();
	}

	private void initialize() {
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(this.dp[i], Integer.MAX_VALUE);
		}
	}

	public void nearestFil(int row, int col, int dist) {
		if (row < 0 || row >= graph.length || col < 0 || col >= graph[row].length)
			return;
		if(dp[row][col] <= dist) 
			return;
		dp[row][col] = dist;
		nearestFil(row, col - 1, dist + 1);
		nearestFil(row, col + 1, dist + 1);
		nearestFil(row + 1, col, dist + 1);
		nearestFil(row - 1, col, dist + 1);
	}

	public void solve() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] == 1) {
					nearestFil(i, j, 0);
				}
			}
		}
		Arrays.stream(dp).forEach(d -> System.out.println(Arrays.toString(d)));
	}

	public static void main(String[] args) {
		int num[][] = {
				{ 1, 0, 1, 1, 0 },
				{ 1, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1 }
		};
		DistanceNearestFill dnf = new DistanceNearestFill(num);
		dnf.solve();
	}
}
