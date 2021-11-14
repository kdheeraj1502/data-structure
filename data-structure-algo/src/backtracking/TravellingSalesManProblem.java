package backtracking;

import java.util.ArrayList;
import java.util.List;

public class TravellingSalesManProblem {

	private int graph[][];
	private List<Integer> path;
	private boolean visited[];
	private int min;

	public TravellingSalesManProblem(int graph[][]) {
		this.graph = graph;
		this.path = new ArrayList<>();
		this.visited = new boolean[graph.length];

		initialize();
	}

	private void initialize() {
		this.path.add(0);
		this.visited[0] = true;
		this.min = Integer.MAX_VALUE;
	}

	public static void main(String args[]) {
		int graph[][] = { 
				{ 0, 10, 15, 20 }, 
				{ 10, 0, 35, 25 }, 
				{ 15, 35, 0, 30 }, 
				{ 20, 25, 30, 0 } };
		TravellingSalesManProblem tsm = new TravellingSalesManProblem(graph);
		////     (X, Y) == > 0
		tsm.solve(0, 1, 0);
		System.out.println(tsm.min);
	}

	private void solve(int actualPosition, int counter, int cost) {
		// 4 == GRAPH.LENGTH   &&  
		if (counter == graph.length && graph[actualPosition][0] != 0) {
			this.path.add(0);
			this.path.forEach(num -> System.out.print(num + ", "));
			System.out.println("\nCost " + (cost + graph[actualPosition][0]) + "\n");
			if ((cost + graph[actualPosition][0]) < min)
				min = (cost + graph[actualPosition][0]);
			path.remove(path.size() - 1);  // REMOVE D
			return;
		}
		for (int i = 0; i < graph.length; ++i) {
			// 0, 0/ 0, 1
			if (isValid(actualPosition, i)) {
				visited[i] = true;
				path.add(i);
				solve(i, counter + 1, cost + graph[actualPosition][i]);

				// BACKTRACK
				visited[i] = false;
				path.remove(path.size() - 1);  // REMOPVE C
			}
		}
	}

	private boolean isValid(int actualPosition, int vertex) {
		if (visited[vertex])
			return false;
		// GRAPH[0][1]
		if (graph[actualPosition][vertex] == 0)
			return false;
		return true;
	}
}
