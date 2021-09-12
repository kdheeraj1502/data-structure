package queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseStackUsingQueue {

	private ArrayDeque<Integer> queue;
	
	ReverseStackUsingQueue(){
		queue = new ArrayDeque<>();
	}
	
	public void reverse(Stack<Integer> stack) {
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
	}
	
	public void reverseUsingArray(Stack<Integer> stack) {
		int arr[] = new int[stack.size()];
		int index  = 0;
		while(!stack.isEmpty()) {
			arr[index++] = stack.pop();
		}
		for(int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		ReverseStackUsingQueue rsuq = new ReverseStackUsingQueue();
		Stack<Integer> stack = new Stack<>();
		stack.push(56);
		stack.push(77);
		stack.push(51);
		stack.push(91);
		stack.push(23);
		System.out.println(stack);
		rsuq.reverse(stack);
		System.out.println(stack);
		rsuq.reverseUsingArray(stack);
		System.out.println(stack);
	}
}
