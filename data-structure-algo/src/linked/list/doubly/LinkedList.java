package linked.list.doubly;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public Node getHead() {
		return this.head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return this.tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void print(Node node) {
		if (node == null)
			return;
		System.out.print(node.val + ", ");
		print(node.next);
	}

	public void addHead(int val) {
		Node node = new Node(val, null, null);
		if (size == 0) {
			tail = head = node;
		} else {
			head.prev = node;
			node.next = head;
			head = node;
		}
		size++;
	}

	public void sortedInsert(int val) {
		Node node = new Node(val, null, null);
		if (this.head == null) {
			this.tail = this.head = node;
		}
		if (this.head.next == null) {
			if (this.head.val > val) {
				addHead(val);
			} else {
				tail = node;
				head.next = node;
			}
		} else {
			Node curr = this.head;
			while (curr.next != null) {
				if (curr.next.val > val) {
					node.prev = curr;
					curr.next.prev = node;
					node.next = curr.next;
					curr.next = node;
					size++;
					break;
				}
				curr = curr.next;
			}
		}
	}

	public int removeHead() {
		int val = head.val;
		head = head.next;
		head.prev = null;
		size--;
		return val;
	}

	public void removeNode(int val) {
		if (head.val == val) {
			removeHead();
		}
		if (head.next.val == val && head.next.next == null) {
			head.next = null;
		}
		Node curr = this.head;
		while (curr.next != null) {
			if (curr.next.val == val) {
				curr.next = curr.next.next;
				curr.next.prev = curr;
				break;
			}
			curr = curr.next;
		}
	}
}
