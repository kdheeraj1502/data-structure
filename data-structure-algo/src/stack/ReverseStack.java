package stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseStack {

	public static void reverse(Stack<Integer> stack) {
		if (stack.size() > 0) {
			int val = stack.pop();
			reverse(stack);
			BottomInsert.bottomInsert(stack, val);
		}
	}

	public static void reverseUseQueue(Stack<Integer> stack) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		while (!stack.isEmpty()) {
			deque.add(stack.pop());
		}

		while (!deque.isEmpty()) {
			stack.push(deque.pop());
		}
	}

	public static void reverseKElement(Stack<Integer> stack, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		while (k > 0) {
			deque.add(stack.pop());
			k--;
		}

		while (!deque.isEmpty()) {
			stack.push(deque.pop());
		}
	}
}
