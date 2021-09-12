package queue;

import java.util.ArrayDeque;

public class StackUsing2Queue {

	private ArrayDeque<Integer> queue1;
	private ArrayDeque<Integer> queue2;
	
	public StackUsing2Queue() {
		queue1 = new ArrayDeque<>();
		queue2 = new ArrayDeque<>();
	}
	
	public void push(int val) {
		if(!this.queue1.isEmpty()) {
			this.queue1.add(val);
		}
		else {
			this.queue1 = new ArrayDeque<>();
			this.queue1.add(val);
		}
	}
	
	public int pop() {
		if(!queue2.isEmpty()) {
			return queue2.remove();
		}
		while(!queue1.isEmpty()) {
			queue2.add(queue1.remove());
		}
		return queue2.remove();
	}
	
	
	public static void main(String[] args) {
		StackUsing2Queue suq = new StackUsing2Queue();
		suq.push(86);
		suq.push(78);
		suq.push(45);
		
		System.out.println(suq.pop());
		System.out.println(suq.pop());
	}
}
