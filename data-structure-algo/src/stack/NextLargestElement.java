package stack;

import java.util.Stack;

public class NextLargestElement {

	public static void nextLargestElement_stack(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int curr;
		int index = -1;
		int result[] = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			curr = num[i];
			while (!stack.isEmpty() && num[stack.peek()] <= curr) {
				index = stack.pop();
				result[index] = curr;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			index = stack.pop();
			result[index] = -1;
		}

		for (int val : result) {
			System.out.print(val + " ");
		}
	}
	
	public static void main(String[] args) {
		int num[] = { 20, 19, 10, 21, 40, 35, 39, 50, 45, 42 };
		nextLargestElement_stack(num);
	}
}
