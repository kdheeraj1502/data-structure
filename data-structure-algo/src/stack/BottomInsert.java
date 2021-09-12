package stack;

import java.util.Stack;

public class BottomInsert {

	public static void bottomInsert(Stack<Integer> stack, int val) {
		if(stack.isEmpty()) {
			stack.push(val);
		}
		else {
			int temp = stack.pop();
			bottomInsert(stack, val);
			stack.push(temp);
		}
	}
}
