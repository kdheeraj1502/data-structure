package backtracking;

public class SudokoProblem {

	private int[][] sudokoTable;
	
	public SudokoProblem(int[][] sudokoTable){
		this.sudokoTable= sudokoTable;
		
	}
	
	public void solve() {
		if(feasibleSudoko(0, 0)) {
			printSolution();
		} else {
			System.out.println("There is no solution ...");
		}
	}
	
	private boolean feasibleSudoko(int rowIndex, int colIndex) {
		if(rowIndex == Constants.SUDOKO_BOARD_SIZE && ++colIndex == Constants.SUDOKO_BOARD_SIZE) {
			return true;
		}
		if(rowIndex == Constants.SUDOKO_BOARD_SIZE) {
			rowIndex = 0;
			colIndex += 1;
		}
		if(sudokoTable[rowIndex][colIndex] != 0) {
			feasibleSudoko(rowIndex + 1, colIndex);
		}
		for(int number = Constants.SUDOKO_MIN_NUM; number <= Constants.SUDOKO_MAX_NUM; number++) {
			if(isValid(rowIndex, colIndex, number)) {
				sudokoTable[rowIndex][colIndex] = number;
				if(feasibleSudoko(rowIndex + 1, colIndex)) {
					return true;
				}
				sudokoTable[rowIndex][colIndex] = 0;
			}
		}
		return false;
	}

	private boolean isValid(int rowIndex, int colIndex, int number) {
		return false;
	}

	private void printSolution() {
		for(int i = 0; i < Constants.SUDOKO_BOARD_SIZE; i++) {
			if(i % 3 == 0)
				System.out.print(" ");
			for(int j = 0; j < Constants.SUDOKO_BOARD_SIZE; j++) {
				if(i % 3 == 0)
					System.out.print(" ");
				System.out.print(sudokoTable[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
	}
}
