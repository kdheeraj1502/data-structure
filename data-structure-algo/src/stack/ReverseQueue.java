package stack;

import java.util.*;

public class ReverseQueue {

	public static void reverseQueue(ArrayDeque<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
	
	public static void reverseKELeInQueue(ArrayDeque<Integer> queue, int k) {
		Stack<Integer> stack = new Stack<>();
		int i = k;
		while(i > 0) {
			stack.push(queue.remove());
			i--;
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		int diff = queue.size() - k;
		while(diff > 0) {
			int temp = queue.remove();
			queue.add(temp);
			diff--;
		}
	}
}
