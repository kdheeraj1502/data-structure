package queue;

import java.util.ArrayDeque;

public class StackUsing1Queue {

	private ArrayDeque<Integer> queue1;
	private int size;
	
	public StackUsing1Queue() {
		queue1 = new ArrayDeque<>();
	}
	
	public void push(int val) {
		if(!this.queue1.isEmpty()) {
			this.queue1.add(val);
		}
		else {
			this.queue1 = new ArrayDeque<>();
			this.queue1.add(val);
		}
		size += 1;
	}
	
	public int pop() {
		if(size == 0) {
			System.out.println("No result found");
			return -1;
		}
		else
			return queue1.getLast();
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
