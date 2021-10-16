package backtracking;

public class MazeProblem {

	private int[][] mazeTable;
	private int[][] solutionTable;
	private int mazeSize;

	public MazeProblem(int[][] mazeTable) {
		this.mazeTable = mazeTable;
		this.mazeSize = this.mazeTable.length;
		this.solutionTable = new int[this.mazeSize][this.mazeSize];
	}

	private boolean solveMaze(int x, int y) {
		if (x == mazeSize - 1 && y == mazeSize - 1) {
			solutionTable[x][y] = 1;
			return true;
		}
		if (isValid(x, y)) {
			solutionTable[x][y] = 1;
			if (solveMaze(x, y + 1)) {
				return true;
			}
			if (solveMaze(x + 1, y)) {
				return true;
			}
			
			//
			
			if (solveMaze(x - 1, y)) {
				return true;
			}
			if (solveMaze(x, y - 1)) {
				return true;
			}
			solutionTable[x][y] = 0;
		}
		return false;
	}

	private boolean isValid(int x, int y) {
		if (x < 0 || x >= mazeSize)
			return false;
		if (y < 0 || y >= mazeSize)
			return false;
		if (mazeTable[x][y] != 1)
			return false;
		if(solutionTable[x][y] == 1)
			return false;
		return true;
	}

	private void showResult() {
		for (int i = 0; i < mazeSize; i++) {
			for (int j = 0; j < mazeSize; j++) {
				if (solutionTable[i][j] == 1) {
					System.out.print(" p ");
				} else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
	
	public void solve() {
		if (solveMaze(0, 0)) {
			showResult();
		} else {
			System.out.println("No solution");
			showResult();
		}
	}

	public static void main(String[] args) {
		int[][] mazeTable = {
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1}
		};
		
		int[][] mazeTable2 = {
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 0, 1}
		};
		
		System.out.println("----1st maze------");
		MazeProblem mp = new MazeProblem(mazeTable);
		mp.solve();
		System.out.println("----2nd maze------");
		MazeProblem mp2 = new MazeProblem(mazeTable2);
		mp2.solve();
		
		int[][] mazeTable3 = {
				{1, 0, 1, 1, 1},
				{1, 0, 0, 1, 0},
				{1, 0, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 0, 1}
		};
		System.out.println("----3rd maze------");
		MazeProblem mp3 = new MazeProblem(mazeTable3);
		mp3.solve();
	}
}
