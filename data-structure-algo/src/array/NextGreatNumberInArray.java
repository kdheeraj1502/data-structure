package array;

import java.util.Stack;

public class NextGreatNumberInArray {

	public static void nextGreatNumber(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[num.length];

		for (int i = num.length - 1; i >= 0; i--) {
			if (!stack.empty()) {
				while (!stack.empty() && stack.peek() <= num[i]) {
					stack.pop();
				}
			}
			result[i] = stack.empty() ? -1 : stack.peek();
			stack.push(num[i]);
		}
		for (int i = 0; i < num.length; i++)
			System.out.println(num[i] + " --> " + result[i]);
	}

	public static void main(String[] args) {
		int num[] = { 11, 13, 21, 3 };
		nextGreatNumber(num);
	}
}
