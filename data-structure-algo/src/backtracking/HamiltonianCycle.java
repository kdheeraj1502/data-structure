package backtracking;

public class HamiltonianCycle {

	private int adjacencyMatrix[][];
	private int numOfVertexes;
	private int[] hamiltonianPath;

	public HamiltonianCycle(int adjacencyMatrix[][]) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
		this.numOfVertexes = adjacencyMatrix.length;

		this.hamiltonianPath[0] = 0;

	}

	private boolean findFeasibleSolution(int position) {
		if (position == numOfVertexes) {
			if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		for (int vertexIndex = 1; vertexIndex < numOfVertexes; vertexIndex++) {
			if (isFeasibleVertex(vertexIndex, position)) {
				hamiltonianPath[position] = vertexIndex;
				if (findFeasibleSolution(position + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isFeasibleVertex(int vertexIndex, int actualPosition) {
		// Check if new vertexIndex has any connection with previous index. The previous
		// visited index are present in hamiltonianPath hence we with pick out the
		// previous index and using it with new vertexIndex we can check in matrix if it
		// forms 1 (connected)
		if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0)
			return false;
		for (int i = 0; i < actualPosition; i++) {
			// the new vertexIndex should never be visited hence it should not be in
			// hamiltonianPath visited array
			if (hamiltonianPath[i] == vertexIndex)
				return false;
		}
		return true;
	}

	private void showHamitonianPath() {
		for (int i = 0; i < hamiltonianPath.length; i++) {
			System.out.print(hamiltonianPath[i] + ", ");
		}
	}

	public void solve() {
		if (findFeasibleSolution(1)) {
			showHamitonianPath();
		} else {
			System.out.println("No solution");
		}
	}

	public static void main(String[] args) {
		int adjacencyMatrix[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };
		int graph2[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 }, };
		HamiltonianCycle hc = new HamiltonianCycle(adjacencyMatrix);
		hc.solve();
		System.out.println();
		HamiltonianCycle hc2 = new HamiltonianCycle(graph2);
		hc2.solve();
	}
}
