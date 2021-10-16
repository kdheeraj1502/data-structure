package backtracking;

public class SudokoProblem {

	private int[][] sudokoTable;

	public SudokoProblem(int[][] sudokoTable) {
		this.sudokoTable = sudokoTable;
	}

	private boolean feasibleSudoko(int rowIndex, int colIndex) {
		if (rowIndex == Constants.SUDOKO_BOARD_SIZE) {
			return true;
		}
		int nextRowIndex = 0;
		int nextColIndex = 0;
		if (colIndex == Constants.SUDOKO_BOARD_SIZE - 1) {
			nextRowIndex = rowIndex + 1;
			nextColIndex = 0;
		} else {
			nextRowIndex = rowIndex;
			nextColIndex = colIndex + 1;
		}
		if (this.sudokoTable[rowIndex][colIndex] != 0) {
			return feasibleSudoko(nextRowIndex, nextColIndex);
		}
		for (int number = Constants.SUDOKO_MIN_NUM; number <= Constants.SUDOKO_MAX_NUM; number++) {
			if (isValid(rowIndex, colIndex, number)) {
				this.sudokoTable[rowIndex][colIndex] = number;
				if (feasibleSudoko(nextRowIndex, nextColIndex)) {
					return true;
				}
				this.sudokoTable[rowIndex][colIndex] = 0;
			}
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex, int actualNumber) {
		for (int k = 0; k < Constants.SUDOKO_BOARD_SIZE; k++) {
			if (this.sudokoTable[rowIndex][k] == actualNumber) {
				return false;
			}
		}

		for (int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if (this.sudokoTable[i][colIndex] == actualNumber) {
				return false;
			}
		}

		int boxRowOffSet = (rowIndex / 3) * Constants.SUDOKO_BOX_SIZE;
		int boxColOffSet = (colIndex / 3) * Constants.SUDOKO_BOX_SIZE;
		for (int i = 0; i < Constants.SUDOKO_BOX_SIZE; i++) {
			for (int j = 0; j < Constants.SUDOKO_BOX_SIZE; j++) {
				if (actualNumber == this.sudokoTable[boxRowOffSet + i][boxColOffSet + j])
					return false;
			}
		}
		return true;
	}

	private void printSolution() {
		for (int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
			}
			for (int j = 0; j < Constants.SUDOKO_BOARD_SIZE; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print(" ");
				System.out.print(sudokoTable[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve() {
		if (feasibleSudoko(0, 0)) {
			printSolution();
		} else {
			System.out.println("There is no solution ...");
		}
	}

	public static void main(String[] args) throws Exception {
		int[][] sudokoTable = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		SudokoProblem sp = new SudokoProblem(sudokoTable);
		sp.solve();
	}
}
