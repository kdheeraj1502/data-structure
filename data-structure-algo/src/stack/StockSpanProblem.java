package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

	public static int[] stockSpanProb(int[] num) {
		int j = 0;
		int index = 0;
		int count;
		int result[] = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			count = 0;
			j = i;
			while (j >= 0) {
				if (num[j] <= num[i]) {
					count++;
				}
				j--;
			}
			result[index++] = count;
		}
		return result;
	}

	// 6, 5, 4, 3, 2, 4, 5, 7, 9
	public static int[] stockSpanProbStack(int[] num) {
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[num.length];
		result[0] = 1;
		stack.push(0);
		int index = 1;
		for(int i = 1; i < num.length; i++) {
			while(!stack.isEmpty() && num[stack.peek()] <= num[i]) {
				stack.pop();
			}
			result[index++] = (stack.isEmpty()) ? i + 1 : (i - stack.peek());
			stack.push(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 6, 5, 4, 3, 2, 4, 5, 7, 9 };
		int val[] = stockSpanProbStack(num);
		System.out.println(Arrays.toString(val));
	}
}
