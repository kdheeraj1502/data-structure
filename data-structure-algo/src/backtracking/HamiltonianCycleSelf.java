package backtracking;

public class HamiltonianCycleSelf {

	private int[][] adjacencyMatrix;
	private int numOfVertex;
	private int hamitonianpath[];

	public HamiltonianCycleSelf(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVertex = adjacencyMatrix.length;
		this.hamitonianpath = new int[numOfVertex];
		this.hamitonianpath[0] = 0;
	}

	public boolean feasibleSolution(int position) {
		if (position == numOfVertex) {
			if (adjacencyMatrix[hamitonianpath[position - 1]][hamitonianpath[0]] == 1) {
				return true;
			} else
				return false;
		}
		for (int vertexIndex = 1; vertexIndex < hamitonianpath.length; vertexIndex++) {
			if (isFeasibleVertex(position, vertexIndex)) {
				hamitonianpath[position] = vertexIndex;
				if (feasibleSolution(position + 1)) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	private boolean isFeasibleVertex(int actualPosition, int vertexIndex) {
		if (adjacencyMatrix[hamitonianpath[actualPosition - 1]][vertexIndex] == 0) {
			return false;
		}
		for (int i = 0; i < actualPosition; i++) {
			if (hamitonianpath[i] == vertexIndex) {
				return false;
			}
		}
		return true;
	}

	public void solve() {
		if (feasibleSolution(1)) {
			printPath();
		} else {
			System.out.println("No solution");
		}
	}

	public void printPath() {
		for (int i = 0; i < hamitonianpath.length; i++) {
			System.out.print(hamitonianpath[i] + ", ");
		}
	}

	public static void main(String[] args) {
		int adjacencyMatrix[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };

		HamiltonianCycleSelf hcf = new HamiltonianCycleSelf(adjacencyMatrix);
		hcf.solve();
	}
}
