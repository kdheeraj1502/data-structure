package backtracking;

/**
 * Move knight on chessBoard on each cell n * n = n^2 cells The move in cell
 * must always be once never be repeated
 * 
 * @author dheerajkumar02
 *
 */
public class KnightsTourProblem {

	private int[][] chessBoard;
	private int xMoves[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int yMoves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	private int numOfMoves;

	public KnightsTourProblem() {
		this.chessBoard = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		this.numOfMoves = Constants.NUM_OF_MOVES;

		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < Constants.BOARD_SIZE; i++)
			for (int j = 0; j < Constants.BOARD_SIZE; j++)
				chessBoard[i][j] = Integer.MIN_VALUE;
	}

	// step count starting from 1
	// xCord is current x position
	// yCord is current y position
	private boolean solve(int stepCount, int xCord, int yCord) {
		// If total step count reaches 8 * 8 + 1 = 65 that means we visited all cell
		// start from 1 not zero hence 65 not 64
		if (stepCount == Constants.BOARD_SIZE * Constants.BOARD_SIZE + 1) {
			return true;
		}

		// Total move per iteration of knight is 8 specified in xMoves and yMoves array
		// above more than 8 is not possible in single iteration if chessBoard size is 8
		// * 8

		for (int i = 0; i < numOfMoves; i++) {

			// Current position is (0, 0) for first step and add xMove and yMove to curr
			// position, for example at current (x,y) is (0, 0) and next is (0 + 2, 0 + 1) 2
			// and a half step of knight
			int nextX = xCord + xMoves[i];
			int nextY = yCord + yMoves[i];

			// is above moves is valid then only make recursion call
			if (isValid(nextX, nextY)) {
				this.chessBoard[nextX][nextY] = stepCount;
				if (solve(stepCount + 1, nextX, nextY)) {
					return true;
				} // else {

				// back tracking
				// even after recursion call if right step couldnt be reached then backtrack
				this.chessBoard[nextX][nextY] = Integer.MIN_VALUE;

				// Its backtrack not return false
				// return false;
				// }
			}
		}
		return false;
	}

	private boolean isValid(int nextX, int nextY) {
		// Both xMove and yMove is sum of current position plus next knight move

		// X moves must not be lower than zero and larger than board size
		if (nextX < 0 || nextX >= Constants.BOARD_SIZE)
			return false;
		// X moves must not be lower than zero and larger than board size
		if (nextY < 0 || nextY >= Constants.BOARD_SIZE)
			return false;

		// If the matrix value is other than Integer Min than it got visited earlier as
		// well
		if (this.chessBoard[nextX][nextY] != Integer.MIN_VALUE)
			return false;
		return true;
	}

	public void solveTour() {

		// starting step from 1 not zero for easy readable
		// Starting from top left and count it as first move
		chessBoard[0][0] = 1;
		// we counted first move at top left corner and lets start from 2nd move staring
		// from top left corner at 0, 0
		// x = 0, y = 0
		if (solve(2, 0, 0)) {
			printSolution();
		} else {
			System.out.println("No Feasible Solution ... ");
		}
	}

	// Print all moves which were strored in matrix
	public void printSolution() {
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				if (chessBoard[i][j] < 10) {
					System.out.print("| ");
					System.out.print("0" + chessBoard[i][j]);
					System.out.print("| ");
				} else {
					System.out.print("| ");
					System.out.print(chessBoard[i][j]);
					System.out.print("| ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		KnightsTourProblem ktp = new KnightsTourProblem();
		ktp.solveTour();
	}
}
