import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListSwap {

	public static void main(String[] args) {
		Solution s = new Solution();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		List<ListNode> curr = new ArrayList<>();
		// System.out.println(s.swapPairs(head, 3, curr));
		System.out.println(Solution.reverseKGroup(head, 3));
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

	static int size = 0;

	@Override
	public String toString() {
		return (val + " -> " + next);
	}
}

class Solution {

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode prev = null;
		ListNode node = head;
		ListNode next = null;
		ListNode output = null;
		ListNode p = null;// p and pp pointer are used as a place holder for previously reversed list
							// ending point
		ListNode pp = null;
		int i = 0;

		int count = count(head);
		count = count / k;
		// mod with k to skip changing last elements which can not entirely reverse as
		// they not a factor of k
		while (count-- > 0) {
			pp = p;
			p = node;
			i = 0;
			while (i++ != k) {
				next = node.next;
				node.next = prev;
				prev = node;
				node = next;
			}
			if (pp == null) {
				output = prev;
			}
			// keep this pointer as it will be the first head pointer after first reversal,
			// as pp will never be null again after first reversal
			if (p != null) // these two steps will straighten the reversed list to forward direction
			{
				p.next = node;
			}
			if (pp != null) {
				pp.next = prev;
			}
		}

		return output;
	}

	private static int count(ListNode node) {
		ListNode temp = node;
		int c = 0;
		while (temp != null) {
			temp = temp.next;
			c++;
		}
		return c;
	}

	public void assign(List<ListNode> curr, ListNode head) {
		ListNode node = null;
		for (int i = curr.size() - 1; i > 0; i--) {
			node = curr.get(i);
			node.next = curr.get(i - 1);
		}
	}

	public ListNode swapPairs(ListNode head, int k, List<ListNode> curr) {
		if (head == null || head.next == null)
			return head;
		ListNode node = head;
		int count = k;
		boolean assigned = false;
		while (node != null && count > 0) {
			curr.add(node);
			node = node.next;
			count--;
		}
		if (curr.size() >= k) {
			assigned = true;
			assign(curr, head);
		} else
			assigned = false;
		ListNode next = swapPairs(node, k, new ArrayList<>());
		head.next = next;
		int index = curr.size() - 1 > 0 ? curr.size() - 1 : 0;
		if (assigned)
			return curr.get(index);
		else {
			curr.get(0).next = curr.get(index - 1);
			return curr.get(0);
		}
	}

	public ListNode swapPairsR(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next;
		ListNode third = second.next;
		second.next = head;
		head.next = swapPairsR(third);
		return second;

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		if (head != null) {
			ListNode node = head;
			head = head.next;
			while (node.next != null && node.next.next != null) {
				ListNode first = node;
				ListNode second = node.next;
				ListNode third = node.next.next;
				first.next = third;
				second.next = first;
				node = second.next.next;
			}
			if (node.next != null) {
				int a = node.val;
				node.val = node.next.val;
				node.next.val = a;
				System.out.println(a);
			}
		}
		return head;
	}
}
