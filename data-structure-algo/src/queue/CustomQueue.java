package queue;

import java.util.Arrays;

public class CustomQueue {

	private int front = 0;
	private int back = 0;
	private int capacity;
	private int data[];
	private int size;

	public CustomQueue() {
		this.capacity = 20;
		data = new int[this.capacity];
	}

	public CustomQueue(int capacity) {
		this.capacity = capacity;
		data = new int[this.capacity];
	}

	public boolean add(int val) {
		if (size >= this.capacity) {
			System.out.println("Queue is full");
			return false;
		} else {
			size++;
			data[back] = val;
			back = (++back) % (capacity - 1);
		}
		return true;
	}

	public int remove() {
		int val;
		if (size <= 0) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			size--;
			val = data[front];
			front = (++front) % (capacity - 1);
		}
		return val;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return this.size;
	}
	
	public void print() {
		System.out.println(Arrays.toString(data));
	}
	
	public static void main(String[] args) {
		CustomQueue cq = new CustomQueue();
		cq.add(5);
	}
}
