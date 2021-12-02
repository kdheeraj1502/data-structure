package backtracking;

import java.util.*;

public class IsValidSudoko {

	public boolean isValidSudoku(char[][] board) {
		Set<Character> set = null;
		for (int i = 0; i < 9; i++) {
			set = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && set.contains(board[i][j])) {
					System.out.println("1 Issue" + set);
					return false;
				} else {
					set.add(board[i][j]);
				}
			}
		}
		int col = 0;
		while (col < 9) {
			set = new HashSet<>();
			for (int i = 0; i < 9; i++) {
				if (board[i][col] != '.' && set.contains(board[i][col])) {
					System.out.println("2 Issue" + set);
					return false;
				} else {
					set.add(board[i][col]);
				}
			}
			col++;
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				set = new HashSet<>();
				for (int k = i; k < i + 3; k++) {
					for (int z = j; z < j + 3; z++) {
						if (board[k][z] != '.' && set.contains(board[k][z])) {
							System.out.println("3 Issue" + set);
							return false;
						} else {
							set.add(board[k][z]);
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char board[][] = { 
				{ '.', '.', '.', '.', '.', '.', '5', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '9', '3', '.', '.', '2', '.', '4', '.', '.' }, 
				{ '.', '.', '7', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
				{ '.', '.', '.', '3', '4', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '3', '.', '.', '.' }, 
				{ '.', '.', '.', '.', '.', '5', '2', '.', '.' } };
		IsValidSudoko is = new IsValidSudoko();
		System.out.println(is.isValidSudoku(board));
	}
}
