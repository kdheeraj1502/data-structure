package leet.code;

public class ListNode {

	static class Node {
		int val;
		Node next;
		public Node random;

		Node() {
			this.next = this.random = null;
		}

		Node(int val) {
			this.val = val;
			this.next = this.random = null;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", next=" + next + ", random=" + random + "]";
		}

	}

	public Node reverseBetween_self(Node head, int left, int right) {
		int pos = 1;
		Node curr = head, start = head;
		while (pos < left) {
			start = curr;
			curr = curr.next;
			pos++;
		}
		// 1, 2, 3, 4, 5, 6,
		// 1, 4, 3, 2, 5, 6
		Node prev = null, next = null, tail = curr;
		while (pos >= left && pos <= right) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			pos++;
		}
		start.next = prev;
		tail.next = curr;
		if (left == 1)
			return prev;
		else
			return head;
	}

	public Node reverseBetween(Node head, int left, int right) {
		if (left == right || head == null)
			return head;

		Node dummy = new Node(0);
		dummy.next = head;
		Node pre = dummy, post = dummy;

		for (int i = 1; i <= right + 1; i++) {
			if (i < left)
				pre = pre.next; // Find the pre node (i.e. node before Start node)
			post = post.next; // Find the post node (i.e. node after End node)
		}
		Node start = pre.next;
		Node temp = post; // temp is reverse part which is followed by post node

		while (start != post) {
			Node next = start.next;
			start.next = temp;
			temp = start;
			start = next;
		}

		pre.next = temp; // pre node is followed by reversed part
		return dummy.next;
	}

	public Node cloneIt(Node head) {
		Node curr = head;
		while (curr != null) {
			Node temp = new Node(curr.val);
			temp.next = curr.next;
			curr.next = temp;
			curr = curr.next.next;
		}
		curr = head;
		while (curr != null) {
			if (curr.random != null)
				curr.next.random = curr.random.next;
			curr = curr.next.next;
		}
		curr = head;
		Node newNode = new Node(0);
		Node temp = newNode;
		while (curr != null) {
			temp.next = curr.next;
			curr.next = curr.next.next;
			curr = curr.next;
			temp = temp.next;
		}
		return newNode.next;
	}

	public Node rotate(Node head, int k) {
		Node curr = head;
		int size = 0;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		k = k % size;
		if (size < 2 || k == 0)
			return head;
		Node fast = head;
		Node slow = head;
		while (k-- > 0) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		Node rev1 = slow.next; // 4, 5
		slow.next = null; // 1, 2, 3 , null
		Node rev2 = head; // rev2 = 1, 2, 3, null
		head = rev1; // head = 4, 5, null

		while (rev1.next != null) {
			rev1 = rev1.next;
		}
		rev1.next = rev2;
		return head;
	}

	public Node reverseBetween_1(Node head, int left, int right) {
		int pos = 1;
		Node start = head, curr = head;
		while (pos < left) {
			start = curr;
			curr = curr.next;
			pos++;
		}
		Node next = null, prev = null, tail = curr;
		while (pos >= left && pos <= right) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			pos++;
		}
		start.next = prev;
		tail.next = curr;
		if (left == 1)
			return prev;
		else
			return head;
	}

	public static void main(String[] args) {
		Node ln = new Node(1);
		ln.next = new Node(2);
		ln.next.next = new Node(3);
		ln.next.next.next = new Node(4);
		ln.next.next.next.next = new Node(5);

		ListNode list = new ListNode();
		/*
		 * Node node = list.reverseBetween_self(ln, 2, 4); while (node != null) {
		 * System.out.print(node + ", "); node = node.next; }
		 */
		/*
		 * System.out.println(); System.out.println("-----clone----------"); Node
		 * newNode = list.cloneIt(ln); while (newNode != null) {
		 * System.out.print(newNode.val + ", "); newNode = newNode.next; }
		 * 
		 * System.out.println(); System.out.println("-----rotate----------"); Node rev =
		 * list.rotate(ln, 2); while (rev != null) { System.out.print(rev.val + ", ");
		 * rev = rev.next; }
		 */
		System.out.println();
		System.out.println("-----reverse part----------");
		Node reverse = list.reverseBetween_1(ln, 2, 4);
		while (reverse != null) {
			System.out.print(reverse.val + ", ");
			reverse = reverse.next;
		}
	}
}