package stack;

import java.util.*;

public class RottenFruit {

	public static void rottenFruit(int num[][], int dp[][], int currCol, int currRow, int day) {

		if (currCol < 0 || currRow < 0 || currCol >= num.length || currRow >= num[currCol].length)
			return;
		if (dp[currCol][currRow] <= day || dp[currCol][currRow] == 0)
			return;
		dp[currCol][currRow] = day;

		rottenFruit(num, dp, currCol - 1, currRow, day + 1);
		rottenFruit(num, dp, currCol + 1, currRow, day + 1);
		rottenFruit(num, dp, currCol, currRow + 1, day + 1);
		rottenFruit(num, dp, currCol, currRow - 1, day + 1);

	}

	public static int rottenFruit(int num[][]) {
		int dp[][] = new int[num.length][num[0].length];
		int day = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if (num[i][j] == 2) {
					rottenFruit(num, dp, i, j, day);
				}
			}
		}

		int maxDay = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if (num[i][j] == 1) {
					if (dp[i][j] == Integer.MAX_VALUE) {
						return -1;
					}
					if (maxDay < dp[i][j])
						maxDay = dp[i][j];
				}
			}
		}
		return maxDay;
	}

	public static void main(String[] args) {
		int num[][] = { 
				{ 1, 0, 1, 1, 0 }, 
				{ 2, 1, 0, 1, 0 }, 
				{ 0, 0, 0, 2, 1 }, 
				{ 0, 2, 0, 0, 1 }, 
				{ 1, 1, 0, 0, 1 } };
		
	//	System.out.println(rottenFruit(num));		
	}
}
