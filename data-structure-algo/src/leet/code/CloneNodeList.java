package leet.code;

import leet.code.ListNode.Node;

public class CloneNodeList {

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node curr = head;
		// 1, 2, 3, 4, 5
		while (curr != null) {
			Node newNode = new Node(curr.val); // 1, 2, 3, 4
			newNode.next = curr.next; // 1, 2, 3, 4, 5 // 2, 3, 4, 5 // 3, 4, 5 // 4, 5
			curr.next = newNode; // 1, 1, 2, 3, 4, 5 // 2, 2, 3, 4, 5 // 3, 3, 4, 5 // 4, 4, 5
			curr = curr.next.next; // 2, 3, 4, 5 // 3, 4, 5 // 4, 5
		}
		curr = head;
		Node newHead = new Node(0);
		Node newCurr = newHead;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		curr = head;
		while (curr != null) {
			Node tempNode = curr.next;
			curr.next = curr.next.next;
			newCurr.next = tempNode;
			newCurr = newCurr.next;
			curr = curr.next;
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		Node ln = new Node(1);
		ln.random = null;
		ln.next = new Node(2);
		ln.next.random = new Node(0);
		ln.next.next = new Node(3);
		ln.next.next.random = new Node(4);
		ln.next.next.next = new Node(4);
		ln.next.next.next.random = new Node(2);
		ln.next.next.next.next = new Node(5);
		ln.next.next.next.next.random = new Node(0);

		CloneNodeList cnl = new CloneNodeList();
		Node node = cnl.copyRandomList(ln);
		while (node != null) {
			System.out.print(node + ", ");
			node = node.next;
		}
	}
}
