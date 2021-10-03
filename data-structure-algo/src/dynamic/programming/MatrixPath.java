package dynamic.programming;

import java.util.*;

public class MatrixPath {

	public static List<List<Integer>> getAllPath(int num[][]) {
		List<List<Integer>> result = new ArrayList<>();
		getAllPath(num, 0, 0, result, new ArrayList<>());
		return result;
	}

	public static void getAllPath(int num[][], int row, int col, List<List<Integer>> result,
			List<Integer> curr) {
		if(num.length == 1) return;
		if(num[row].length == 1) return;
		if(row >= num.length && col >= num[row].length) {
			result.add(curr);
			curr.clear();
			return;
		}
		for(int i = 0; i < num.length; i++) {
			
		}
	}
	
	private static void canMove(int num[][], int row, int col) {
		boolean a = ((row < num.length) && (col < num[row].length));
	}

	public static void main(String[] args) {
		int num[][] = { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 } 
				};
	}
}
