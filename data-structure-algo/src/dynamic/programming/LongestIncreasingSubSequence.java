package dynamic.programming;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubSequence {
	int num[];
	int dp[];

	public LongestIncreasingSubSequence(int[] num) {
		this.num = num;
		this.dp = new int[num.length];
	}

	public int LIS() {
		int i = 1;
		int j = 0;
		Arrays.fill(dp, 1);
		for (i = 1; i < num.length; i++) {
			for (j = 0; j < i; j++) {
				if (num[i] > num[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println();
		print(dp[num.length - 1]);
		System.out.println();
		return dp[num.length - 1];
	}

	private void print(int maxLength) {
		int i = dp.length - 1;
		while(dp[i] < maxLength) {
			i = i - 1;
		}
		Stack<Integer> stack = new Stack<>();
		int curr = num[i];
		stack.push(num[i]);
		maxLength--;
		while(maxLength > 0) {
			i--;
			if(dp[i] == maxLength && num[i] < curr) {
				stack.push(num[i]);
				curr = num[i];
				maxLength--;
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
	}
	public static void main(String[] args) {
		int num[] = { 3, 4, -1, 0, 6, 2, 3 };
		LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence(num);
		System.out.println(lis.LIS());
	}

}
