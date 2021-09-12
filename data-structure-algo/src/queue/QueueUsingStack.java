package queue;

import java.util.Stack;

public class QueueUsingStack {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public QueueUsingStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void add(int val) {
		stack1.push(val);
	}
	
	public int remove() {
		int val;
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}
		while(!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		QueueUsingStack qus = new QueueUsingStack();
		qus.add(86);
		qus.add(78);
		qus.add(45);
		
		System.out.println(qus.remove());
		System.out.println(qus.remove());
	}
}
