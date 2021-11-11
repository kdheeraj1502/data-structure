package dynamic.programming;

import java.util.Stack;

public class LongestCommonSubsequence {

	String s1;
	String s2;
	int dp[][];

	LongestCommonSubsequence(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
		this.dp = new int[s1.length() + 1][s2.length() + 1];
	}

	public int LCSLength() {

		for (int i = 0; i < dp.length; i++) {
			dp[0][i] = 0;
			dp[i][0] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		printLCS();
		return dp[s1.length()][s2.length()];
	}

	public void printLCS() {
		int i = dp.length - 1;
		int j = dp[0].length - 1;
		Stack<Character> stack = new Stack<>();
		while (j > 0 && i > 0) {
			if ((dp[i][j] == dp[i - 1][j - 1] + 1) && s1.charAt(i - 1) == s2.charAt(j - 1)) {
				stack.push(s1.charAt(i - 1));
				i--;
				j--;
			}
			else if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else {
				j--;
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String s1 = "acbcf";
		String s2 = "abcdaf";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(s1, s2);
		System.out.println(lcs.LCSLength());
	}
}
