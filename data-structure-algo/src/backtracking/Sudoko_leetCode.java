package backtracking;

public class Sudoko_leetCode {

	public void solveSudoku(char[][] board) {
		solveSudoku(0, 0, board);
		printSolution(board);
	}

	private void printSolution(char[][] board) {
		for (int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
			}
			for (int j = 0; j < Constants.SUDOKO_BOARD_SIZE; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print(" ");
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean solveSudoku(int rowIndex, int colIndex, char[][] board) {
		// WHEN WE REACH LAST ROW
		if (rowIndex == Constants.SUDOKO_BOARD_SIZE) {
			return true;
		}
		int nextRowIndex = 0;
		int nextColIndex = 0;
		// WHEN WE REACH LAST COLUMN AND SHIFT TO NEXT ROW AND START COULMN FROM 0
		if (colIndex == Constants.SUDOKO_BOARD_SIZE - 1) {
			nextRowIndex = rowIndex + 1;
			nextColIndex = 0;
		} else {
			nextRowIndex = rowIndex;
			nextColIndex = colIndex + 1;
		}
		if (board[rowIndex][colIndex] != 0) {
			return solveSudoku(nextRowIndex, nextColIndex, board);
		}
		for (int number = Constants.SUDOKO_MIN_NUM; number <= Constants.SUDOKO_MAX_NUM; number++) {
			if (isValid(rowIndex, colIndex, number, board)) {
				board[rowIndex][colIndex] = (char)(number + '0');
				if (solveSudoku(nextRowIndex, nextColIndex, board)) {
					return true;
				}
				board[rowIndex][colIndex] = '.';
			}
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex, int actualNumber, char[][] board) {
		for (int k = 0; k < Constants.SUDOKO_BOARD_SIZE; k++) {
			if (board[rowIndex][k] == actualNumber) {
				return false;
			}
		}

		for (int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if (board[i][colIndex] == actualNumber) {
				return false;
			}
		}

		int boxRowOffSet = (rowIndex / 3) * Constants.SUDOKO_BOX_SIZE;
		int boxColOffSet = (colIndex / 3) * Constants.SUDOKO_BOX_SIZE;
		for (int i = 0; i < Constants.SUDOKO_BOX_SIZE; i++) {
			for (int j = 0; j < Constants.SUDOKO_BOX_SIZE; j++) {
				if ((char)(actualNumber + '0') == board[boxRowOffSet + i][boxColOffSet + j])
					return false;
			}
		}
		return true;
	}
	
	
	
	private boolean feasibleSudoko(int rowIndex, int colIndex, char[][] board) {
		// WHEN WE REACH LAST ROW
		if (rowIndex == Constants.SUDOKO_BOARD_SIZE) {
			return true;
		}
		int nextRowIndex = 0;
		int nextColIndex = 0;
		// WHEN WE REACH LAST COLUMN AND SHIFT TO NEXT ROW AND START COULMN FROM 0
		if (colIndex == Constants.SUDOKO_BOARD_SIZE - 1) {
			nextRowIndex = rowIndex + 1;
			nextColIndex = 0;
		} else {
			nextRowIndex = rowIndex;
			nextColIndex = colIndex + 1;
		}
		if (board[rowIndex][colIndex] != '.') {
			return feasibleSudoko(nextRowIndex, nextColIndex, board);
		}
		for (int number = Constants.SUDOKO_MIN_NUM; number <= Constants.SUDOKO_MAX_NUM; number++) {
			if (isValid_1(rowIndex, colIndex, number, board)) {
				board[rowIndex][colIndex] = (char)(number + '0');
				if (feasibleSudoko(nextRowIndex, nextColIndex, board)) {
					return true;
				}
				board[rowIndex][colIndex] = '.';
			}
		}
		return false;
	}

	private boolean isValid_1(int rowIndex, int colIndex, int actualNumber, char[][] board) {
		for (int k = 0; k < Constants.SUDOKO_BOARD_SIZE; k++) {
			if (board[rowIndex][k] == (char)(actualNumber + '0')) {
				return false;
			}
		}

		for (int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if (board[i][colIndex] == (char)(actualNumber + '0')) {
				return false;
			}
		}

		int boxRowOffSet = (rowIndex / 3) * Constants.SUDOKO_BOX_SIZE;
		int boxColOffSet = (colIndex / 3) * Constants.SUDOKO_BOX_SIZE;
		for (int i = 0; i < Constants.SUDOKO_BOX_SIZE; i++) {
			for (int j = 0; j < Constants.SUDOKO_BOX_SIZE; j++) {
				if ((char)(actualNumber + '0') == board[boxRowOffSet + i][boxColOffSet + j])
					return false;
			}
		}
		return true;
	}

	private void printSolution_1(char[][] board) {
		for (int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
			}
			for (int j = 0; j < Constants.SUDOKO_BOARD_SIZE; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print(" ");
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve(char[][] board) {
		if (feasibleSudoko(0, 0, board)) {
			printSolution_1(board);
		} else {
			System.out.println("There is no solution ...");
		}
	}


	public static void main(String[] args) {
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		Sudoko_leetCode sl = new Sudoko_leetCode();
		sl.solve(board);
	}
}
