package backtracking;

public class QueensProblem {

	private int chessBoard[][];
	private int numOfQueens;

	public QueensProblem() {
	}

	public QueensProblem(int numOfQueens) {
		this.numOfQueens = numOfQueens;
		this.chessBoard = new int[numOfQueens][numOfQueens];
	}

	private boolean isPlaceValid(int rowIndex, int colIndex) {

		// Horizontal check in single row
		// vertical row of same column is not required bcz columns are getting
		// incremented
		// so there is no chance of same row
		for (int j = 0; j < chessBoard.length; j++) {
			if (chessBoard[rowIndex][j] == 1)
				return false;
		}

		// Diagonal check from right top from the new column index to bottom left ,
		// increment row and decrement column
		for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}

		// Diagonal check from bottom right, from new index of row and column to top
		// left
		// Decrement both row and column
		for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1)
				return false;
		}
		return true;
	}

	public boolean nQueenProb(int colIndex) {

		// If we reached upto last column
		// it means previous queen storage was correct
		if (chessBoard.length == colIndex) {
			return true;
		}

		// check for row 0 to last for each column hence initialize with row 0
		for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
			if (isPlaceValid(rowIndex, colIndex)) {
				chessBoard[rowIndex][colIndex] = 1;

				// column are getting incremented
				if (nQueenProb(colIndex + 1)) {
					return true;
				}
				chessBoard[rowIndex][colIndex] = 0;
			}
		}
		return false;
	}

	public void solve(int numOfQueens) {
		this.numOfQueens = numOfQueens;
		this.chessBoard = new int[numOfQueens][numOfQueens];
		if (nQueenProb(0)) {
			printQueens();
		} else {
			System.out.println("There is no solution...");
		}
	}

	private void printQueens() {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				if (chessBoard[i][j] == 1) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		QueensProblem qp = new QueensProblem();
		System.out.println(System.currentTimeMillis()/1000);
		qp.solve(30);
		System.out.println(System.currentTimeMillis()/1000);
	}
}
