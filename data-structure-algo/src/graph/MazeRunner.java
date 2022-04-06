package graph;

public class MazeRunner {

	private int[][] maze;
	private boolean[][] visited;

	public MazeRunner(int[][] maze) {
		this.maze = maze;
		this.visited = new boolean[maze.length][maze[0].length];
	}

	private boolean solveMaze(int rowIndex, int colIndex) {
		if (rowIndex >= maze.length - 1 && colIndex >= maze.length - 1) {
			visited[rowIndex][colIndex] = true;
			return true;
		}
		if (isValid(rowIndex, colIndex)) {
			visited[rowIndex][colIndex] = true;
			if (solveMaze(rowIndex + 1, colIndex)) {
				return true;
			}
			if (solveMaze(rowIndex - 1, colIndex)) {
				return true;
			}
			if (solveMaze(rowIndex, colIndex + 1)) {
				return true;
			}
			if (solveMaze(rowIndex, colIndex - 1)) {
				return true;
			}
			// Backtrack
			visited[rowIndex][colIndex] = false;
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex) {
		if (rowIndex < 0 || rowIndex > maze.length - 1)
			return false;
		if (colIndex < 0 || colIndex > maze.length - 1)
			return false;
		if (visited[rowIndex][colIndex])
			return false;
		if (maze[rowIndex][colIndex] == 1)
			return false;
		return true;
	}

	public void solve() {
		int i = 0;
		int j = 0;
		boolean status = false;
		for (i = 0; i < maze.length; i++) {
			for (j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == 2) {
					status = true;
					break;
				}
			}
			if (status)
				break;
		}
		if (solveMaze(i, j)) {
			System.out.println("Solution exist");
			showResult();
		} else {
			System.out.println("No Solution..");
		}
	}

	private void showResult() {
		int i = 0;
		int j = 0;
		System.out.println("----------------The Path is ----------------");
		for (i = 0; i < visited.length; i++) {
			for (j = 0; j < visited[i].length; j++) {
				if (visited[i][j] == true) {
					System.out.println("[i][j] " + i + ", " + j);
				}
			}
		}
	}

	public static void main(String[] args) {
		int num[][] = { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 2, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 1, 1, 1, 3 } 
				};
		MazeRunner mr = new MazeRunner(num);
		mr.solve();

	}
}
