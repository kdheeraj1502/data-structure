package linked.list.singly;

public class ReverseKGroup {

	public static Node reverseKGroup(Node head, int k) {
		if (head == null)
			return null;
		
		int size = size(head);
		
		Node prev = null;
		Node next = null;
		Node curr = head;
		int count = 0;
		while (count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
			size--;
		}
		if (next != null && size >= k) {
			head.next = reverseKGroup(next, k);
		} else {
			head.next = next;
		}
		return prev;
	}
	
	private static int size(Node head) {
		int size = 0;
		while(head != null) {
			head = head.next;
			size++;
		}
		return size;
	}
	
	public static void print(Node node) {
		
		while(node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
	}
	
    public static Node reverseKGroup_iteration(Node head, int k) {
        if(head == null) return head;
        int size = 0;
        Node curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        curr = head;
        Node prev = null;
        int i = size/k;
        while(i-- > 0){
            prev = null;
            Node next = null;
            int count = 0;
            while(count++ < k && curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head.next = prev;
            curr = next;
        }
        return prev;
    }

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);

	//	Node rev = reverseKGroup(node, 3);
	//	print(rev);
		
		Node rev1 = reverseKGroup_iteration(node, 3);
		print(rev1);
	}
}
