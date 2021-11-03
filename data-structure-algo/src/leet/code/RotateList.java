package leet.code;

public class RotateList {

	public Node rotateRight(Node head, int k) {
		Node nodeToReverse = null;
		int size = 0;
		Node curr = head;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		if (size < 2 || k % size == 0)
			return head;
		k = k % size;
		int i = k;

		Node fastPtr = head;
		Node slowPtr = head;

		while (i-- > 0) {
			fastPtr = fastPtr.next;
		}

		while (fastPtr.next != null) {
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}

		nodeToReverse = slowPtr.next;
		slowPtr.next = null;

		Node tmpHead = head;
		head = nodeToReverse;
		while (nodeToReverse.next != null) {
			nodeToReverse = nodeToReverse.next;
		}
		nodeToReverse.next = tmpHead;

		return head;
	}

	public static void main(String[] args) {

		RotateList rl = new RotateList();
		Node node = new Node(1);
		node.next = new Node(2);
	//	node.next.next = new Node(3);
	//	node.next.next.next = new Node(4);
	//	node.next.next.next.next = new Node(5);

		Node result = rl.rotateRight(node, 0);

		while (result != null) {
			System.out.println(result);
			result = result.next;
		}
	}
}
