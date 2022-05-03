package linked.list.singly;

public class ReverseLinkedListFromK {
		public static Node reverse(Node node, int k) {
			Node first = new Node(-1);
			Node firstTemp = first;
			Node second = null;
			Node temp = node;
			int a = 1;
			while (temp != null) {
				if (a == k) {
					second = temp.next;
					break;
				}
				a++;
				firstTemp.next = temp;
				temp = temp.next;
				firstTemp = firstTemp.next;
			}
			firstTemp.next = null;
			Node rev1 = reverse(first.next);
			Node rev2 = reverse(second);
			Node result = new Node(4);
			result.next = rev1;
			temp = result;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = rev2;
			return result;
		}
	
		private static Node reverse(Node node) {
			Node curr = node;
			Node prev = null;
			Node next = null;
			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			return prev;
		}
	
	private static void print(Node node) {
		while(node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(2);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next.next = new Node(8);
		
		Node result = reverse(node, 4);
		print(result);
	}
}
