package stack;

import java.util.*;

public class MinStack {

	Stack<Integer> st = new Stack<>();
	Stack<Integer> mn = new Stack<>();

	public void push(int val) {
		if (st.isEmpty() || val <= mn.peek()) {
			mn.push(val);
		}
		st.push(val);
	}

	public void pop() {
		if (st.peek().equals(mn.peek()))
			mn.pop();
		st.pop();
	}

	private int getMin() {
		return mn.peek();
	}

	private int top() {
		return st.peek();
	}

	public static void main(String args[]) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(6);
		minStack.push(4);
		minStack.push(7);
		minStack.push(5);
		minStack.push(3);
		int param1 = minStack.getMin();
		minStack.pop();
		int param2 = minStack.top();
		int param3 = minStack.getMin();

		System.out.println(param1);
		System.out.println(param2);
		System.out.println(param3);
	}
}
