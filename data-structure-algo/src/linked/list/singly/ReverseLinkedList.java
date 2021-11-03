package linked.list.singly;

public class ReverseLinkedList {

	public static Node reverse(Node node) {
		Node result = null;
		//1, 2, 3, 4, 5
		if(node == null || node.next == null) {
			return node;
		}
		// 5, 4, null
		// 5, 4, 3, 2, null
		result = reverse(node.next);
		// 4, 5, null
		// 4, 5, 4, 5, 4, 5..
		// 3, 4, null
		// 3, 4, 3, 4, 3, 4
		// 2, 3 null
		// 2, 3, 2, 3, 2, 3,
		// 1, 2, 1, 2, 1, 2
		node.next.next = node;
		// 4, null
		// 3, null
		// 2, null
		// 1, null
		node.next = null;
		return result;
	}
	
	public static Node reverse_self(Node node) {
		Node result = null;
		// 1, 2, 3, 4, 5 
		// 5, null
		if(node == null || node.next == null) return node;
		// 1, 2, 3, 4, 
		// 5, 4, null
		result = reverse_self(node.next);
		// 4, 5, 4, 5, 4, 5
		node.next.next = node;
		// 4, null
		node.next = null;
		return result;
	}
	
	public static Node reverse_without_recursion(Node node) {
		Node temp = node;
		Node next = null;
		Node prev = null;
		// 1, 2, 3, 4, 5 
		while(temp != null) {
			// null
			next = temp.next;
			// 5, 4, 3, 2, 1, null
			temp.next = prev;
			// 5, 4, 3, 2, 1, null
			prev = temp;
			// null
			temp = next;
		}
		return prev;
	}
}

// result = 5 -> null => 5, 4, 5, 4, .. => 5, 4, null
// node = 4, 5, 4, 5, 4, 5 => 4 => null
// 
