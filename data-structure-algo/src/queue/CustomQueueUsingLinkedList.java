package queue;

public class CustomQueueUsingLinkedList {

	private int size;
	private Node tail;

	static class Node {
		Node next;
		int val;

		Node() {
		}

		Node(int val) {
			this.val = val;
			this.next = null;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	public void add(int val) {
		Node node = new Node(val, null);
		if (this.tail == null) {
			this.tail = node;
			this.tail.next = this.tail;
		} else {
			node.next = this.tail.next;
			this.tail.next = node;
			this.tail = node;
		}
		size += 1;
	}

	public int remove() {
		int val = -1;
		if (this.tail == this.tail.next) {
			val = this.tail.val;
			this.tail = null;
		} else {
			val = this.tail.next.val;
			this.tail.next = this.tail.next.next;
		}
		size -= 1;
		return val;
	}

	public int peek() {
		int val = -1;
		if (this.tail == this.tail.next) {
			val = this.tail.val;
		} else {
			val = this.tail.next.val;
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
		Node curr = this.tail.next;
		int i = size + 1;
		while (curr != null && i >= 0) {
			System.out.println(curr.val);
			i--;
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		CustomQueueUsingLinkedList cq = new CustomQueueUsingLinkedList();
		cq.add(5);
		cq.add(15);
		cq.add(20);
		System.out.println(cq.remove());
		System.out.println("-------------------");
		cq.print();
	}
}
