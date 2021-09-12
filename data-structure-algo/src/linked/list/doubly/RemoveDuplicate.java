package linked.list.doubly;

public class RemoveDuplicate {

	public static void removeDuplicate(Node head, LinkedList list) {
		Node curr = head;
		while(curr != null) {
			if(curr.next != null && curr.val == curr.next.val) {
				Node deleteNode = curr.next;
				if(deleteNode.next != null) {
					curr.next = deleteNode.next;
					curr.next.prev = curr;
				}
				else {
					curr.next = null;
				}
				if(deleteNode == list.getTail()) {
					list.setTail(curr);
				}
			}
			curr = curr.next;
		}
	}
}
