package backtracking;

import java.util.*;

public class NQueensProblemForMultipleSolution {

	char[][] chessBoard = null;
	List<List<String>> res = new ArrayList();

	public List<List<String>> solveNQueens(int n) {
		this.chessBoard = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chessBoard[i][j] = '.';
			}
		}
		solve(0);
		return res;
	}

	void solve(int column) {
		if (column == chessBoard.length) {
			populateResult();
			return;
		}

		for (int i = 0; i < chessBoard.length; i++) {
			if (isValid(i, column)) {
				chessBoard[i][column] = 'Q';
				solve(column + 1);
				chessBoard[i][column] = '.';
			}
		}
	}

	void populateResult() {
		StringBuilder sb = new StringBuilder();
		List<String> ans = new ArrayList();
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				sb.append(chessBoard[i][j]);
			}
			ans.add(sb.toString());
			sb.setLength(0);
		}
		res.add(ans);
	}

	boolean isValid(int row, int col) {
		for (int j = 0; j < chessBoard.length; j++) {
			if (chessBoard[row][j] == 'Q') {
				return false;
			}
		}
		for (int i = row, j = col; i < chessBoard.length && j >= 0; i++, j--) {
			if (chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
}
