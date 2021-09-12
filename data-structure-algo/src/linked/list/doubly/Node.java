package linked.list.doubly;

public class Node {

	Node next;
	Node prev;
	int val;

	Node() {
	}

	Node(int val) {
		next = prev = null;
	}

	Node(int val, Node prev, Node next) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}
}
