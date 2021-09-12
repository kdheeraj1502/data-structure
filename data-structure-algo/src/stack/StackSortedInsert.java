package stack;

import java.util.Stack;

public class StackSortedInsert {

	public void sortedInsert(Stack<Integer> stack, int val) {
		if (stack.isEmpty() || val > stack.peek()) {
			stack.push(val);
		} else {
			int temp = stack.pop();
			sortedInsert(stack, val);
			stack.push(temp);
		}
	}

	public void sortStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sortStack(stack);
			sortedInsert(stack, temp);
		}
	}

	public Stack<Integer> sortStackIteration(Stack<Integer> stack) {
		Stack<Integer> stk = new Stack<>();
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			sortedInsert(stk, temp);
		}
		return stk;
	}

	public static Stack<Integer> sortStackGEEK(Stack<Integer> input) {
		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!input.isEmpty()) {
			int tmp = input.pop();
			while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
				input.push(tmpStack.pop());
			}
			tmpStack.push(tmp);
		}
		return tmpStack;
	}

	public static Stack<Integer> sortStackGEEKSelf(Stack<Integer> input) {
		Stack<Integer> tmpStack = new Stack<Integer>();
		while(!input.isEmpty()) {
			int temp = input.pop();
			while(!tmpStack.isEmpty() && tmpStack.peek() > temp) {
				input.push(tmpStack.pop());
			}
			tmpStack.push(temp);
		}
		return tmpStack;
	}
}
