package stack;

public class StackUsingLinkedList<T> {

	private int size;
	private Node head;

	private static class Node<T> {
		private T val;
		private Node next;

		Node() {
		}

		Node(T val) {
			this.val = val;
			this.next = null;
		}

		Node(T val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	StackUsingLinkedList() {
		head = null;
	}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public void push(T val) {
		this.size += 1;
		Node node = new Node(val, null);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public Object pop() {
		size -= 1;
		Object val = null;
		if (size > 0) {
			val = head.val;
			head = head.next;
		} else
			val = null;
		return val;
	}
	
	public void print() {
		Node curr = this.head;
		while(curr != null) {
			System.out.print(curr.val + ", ");
			curr = curr.next;
		}
		System.out.println();
	}
}
