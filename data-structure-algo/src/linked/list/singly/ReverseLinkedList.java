package linked.list.singly;

public class ReverseLinkedList {

	public static Node reverse(Node node) {
		Node result = null;
		//1, 2, 3, 4, 5
		if(node == null || node.next == null) {
			return node;
		}
		result = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return result;
	}
}

// result = 5 -> null => 5, 4, 5, 4, .. => 5, 4, null
// node = 4, 5, 4, 5, 4, 5 => 4 => null
// 
