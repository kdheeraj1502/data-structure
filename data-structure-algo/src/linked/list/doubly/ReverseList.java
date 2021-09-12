package linked.list.doubly;

public class ReverseList {

	public static Node reverse(Node head) {
		Node curr = head;
		Node next = null;
		Node prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			prev.prev = next;
			curr = next;
		}
		return prev;
	}

	public static Node reverseByAdding(Node head) {
		Node node = null;
		if(head != null) {
			node = new Node(head.val, null, null);
			Node curr = head.next;
			while (curr != null) {
				addFrontForReverse(node, curr.val);
				curr = curr.next;
			}
		}
		return node;
	}

	public static void addFrontForReverse(Node prev, int val) {
		Node node = new Node(val, null, null);
		Node temp = prev;
		while (temp.prev != null) {
			temp = temp.prev;
		}
		temp.prev = node;
		//node.prev = temp;
	}
}
