package linked.list.singly;

public class PalindromSelf {
	public boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node curr = head;

		Node temp = new Node(-1);
		Node dummy = temp;

		while (curr != null) {
			dummy.next = new Node(curr.val);
			dummy = dummy.next;
			curr = curr.next;
		}

		curr = temp.next;

		Node rev = reverse(head);
		while (rev != null && curr != null) {
			if ((int) rev.val != (int) curr.val) {
				return false;
			}
			rev = rev.next;
			curr = curr.next;
		}

		if (rev != null || curr != null)
			return false;
		return true;
	}

	private Node reverse(Node node) {
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

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(2);
		node.next.next.next = new Node(1);

		PalindromSelf ps = new PalindromSelf();
		System.out.println(ps.isPalindrome(node));

	}

	public boolean isUgly(int n) {
		if(n == 1) return true;
		if (n % 2 == 0) {
			n = n / 2;
			return isUgly(n);
		}
		else if (n % 3 == 0) {
			n = n / 3;
			return isUgly(n);
		}
		else if (n % 5 == 0) {
			n = n / 5;
			return isUgly(n);
		}
        else{
            return false;
        }
	}
}
