package recursion;

public class MergeTwoSortedListsNode {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode result = new ListNode(-1);
		ListNode curr = result;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				result.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				result.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			result = result.next;
		}
		if (l1 == null) {
			result.next = l2;
		}
		if (l2 == null) {
			result.next = l1;
		}
		return curr.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode result = mergeTwoLists(l1, l2);
		while(result != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return " " + val + " ";
	}
}