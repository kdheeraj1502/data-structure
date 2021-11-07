package linked.list.singly;

public class LinkedList {

	private Node head;
	
	public Node getHead() {
		return this.head;
	}

	public static LinkedList getInstance() {
		return new LinkedList();
	}

	public void addAtFront(int val) {
		Node node = new Node(val);
		node.next = head;
		this.head = node;
	}

	public void addAtTail(int val) {
		Node node = new Node(val, null);
		if (head == null) {
			head = node;
			return;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = node;
	}

	public static void print(Node node) {
		if (node == null)
			return;
		System.out.print(node.val + ", ");
		print(node.next);
	}

	public void sortedInsert(int val) {
		Node node = new Node(val);
		if (this.head == null) {
			this.head = node;
		}
		Node curr = this.head;
		while (curr.next != null) {
			curr = curr.next;
			if (curr.val > val) {
				break;
			}
		}
		Node next = curr.next;
		curr.next = node;
		node.next = next;
	}

	public boolean search(int val) {
		Node curr = this.head;
		while (curr != null) {
			if (curr.val == val)
				return true;
			curr = curr.next;
		}
		return false;
	}

	public void deleteNode(int val) {
		if (head.val == val) {
			head = head.next;
		}
		Node curr = this.head;
		while (curr.next != null) {
			if (curr.next.val == val) {
				Node next = curr.next.next;
				if (next != null) {
					curr.next = next;
				} else
					curr.next = null;
			} else
				curr = curr.next;
		}
	}

	public Node reverse() {
		Node curr = this.head;
		Node prev = null;
		Node next = null;
		if (curr.next == null)
			return this.head;
		while (curr.next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		curr.next = prev;
		prev = curr;
		return prev;
	}

//43, 25, 11, 16, 35, 
	public Node reverseRecursion(Node node) {
		if (node == null || node.next == null)
			return node;
		Node rest = reverseRecursion(node.next);
		node.next.next = node;
		node.next = null;
		return rest;
	}

	public Node reverseRecursionUtil(Node curr, Node prev) {
		if (head == null)
			return head;
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return head;
		}
		Node next = curr.next;
		curr.next = prev;
		reverseRecursionUtil(next, curr);
		return head;
	}

	public Node reverseRecursionUtilSelf(Node curr, Node prev) {
		Node node = null;
		if (curr == null) {
			return node;
		}
		if (curr.next == null) {
			node = curr;
			curr.next = prev;
			return node;
		}
		Node next = curr.next;
		curr.next = prev;
		node = reverseRecursionUtilSelf(next, curr);
		return node;
	}

	public void removeDUplicateFromSorted(Node node) {

	}

	public static void main(String[] args) {
		LinkedList instance = getInstance();
		// instance.addAtTail(5);
		instance.addAtFront(5);
		instance.addAtFront(4);
		instance.addAtFront(3);
		instance.addAtFront(2);
		instance.addAtFront(1);
		print(instance.head);
		print(ReverseLinkedList.reverse(instance.head));

//		instance.sortedInsert(35);
		// print(instance.head);

		// System.out.println("\n" + instance.search(16));

		// instance.deleteNode(7);
		// instance.deleteNode(7);
		// instance.deleteNode(43);
		// instance.deleteNode(5);
		// print(instance.head);
		System.out.println();
		// System.out.println();
		// print(instance.reverse());
		// System.out.println();
		// print(instance.reverseRecursion(instance.head));
		System.out.println();
		// print(instance.reverseRecursionUtilSelf(instance.head, null));

		LinkedList instances = getInstance();
		instances.addAtTail(1);
		instances.addAtTail(2);
		instances.addAtTail(3);
		instances.addAtTail(4);
		instances.addAtTail(5);
		instances.addAtTail(6);
		Node curr = instances.head;
		Node fourNode = null;

		while (curr.next != null) {
			if (curr.val == 4) {
				fourNode = curr;
			}
			curr = curr.next;
		}
		curr.next = fourNode;
		System.out.println();
		
		System.out.println("-------------Find loop--------------");
		DetectLoop.detectLoop(instances.head);
		System.out.println("-------------------");

		Node node = DetectLoop.detectLoop_SPFP(instances.head);
		RemoveLoop.removeLoop(node, instances.head);
		print(instances.head);
	}
}
