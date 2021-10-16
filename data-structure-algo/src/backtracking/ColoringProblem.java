package backtracking;

public class ColoringProblem {

	private int matrix[][];
	private int numOfVertex;
	private int numOfColors;
	private int colors[];

	public ColoringProblem(int matrix[][], int numOfColors) {
		this.matrix = matrix;
		this.numOfColors = numOfColors;
		this.numOfVertex = matrix.length;
		this.colors = new int[numOfVertex];
	}

	private boolean canBeColored(int nodePosition) {
		if (nodePosition == numOfVertex) {
			return true;
		}
		for (int colorType = 1; colorType <= numOfColors; colorType++) {
			if (isColorValid(nodePosition, colorType)) {
				colors[nodePosition] = colorType;
				if (canBeColored(nodePosition + 1)) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	private boolean isColorValid(int actualPosition, int colorType) {
		for (int i = 0; i < numOfVertex; i++) {
			if (matrix[actualPosition][i] == 1 && colorType == colors[i])
				return false;
		}
		return true;
	}

	public void solve() {
		if (canBeColored(0)) {
			printPath();
		} else {
			System.out.println("There is no solutio .. . ");
		}
	}

	public void printPath() {
		for (int i = 0; i < colors.length; i++) {
			System.out.println("Node " + (i + 1) + " has color " + colors[i]);
		}
	}

	public static void main(String[] args) {
		int matrix[][] = {	{0, 1, 0, 1, 0},
							{1, 0, 1, 1, 0},
							{0, 1, 0, 1, 0},
							{1, 1, 1, 0, 1},
							{0, 0, 0, 1, 0}
							};
		int numOfColors = 3;
		ColoringProblem cp = new ColoringProblem(matrix, numOfColors);
		cp.solve();
		
	}
}
