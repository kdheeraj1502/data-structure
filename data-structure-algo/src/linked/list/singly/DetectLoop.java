package linked.list.singly;

import java.util.HashSet;

public class DetectLoop {
	
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            if(fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

	public static void detectLoop(Node node) {
		HashSet<Node> set = new HashSet<>();

		while (node.next != null) {
			if (set.contains(node)) {
				System.out.println("loop found");
				break;
			}
			set.add(node);
			node = node.next;
		}
		if (set.contains(node)) {
			System.out.println("loop found");
		} else {
			set.add(node);
			System.out.println("loop not found");
		}
	}

	public static Node detectLoop_SPFP(Node node) {
		Node slow = node;
		Node fast = node;
		while (slow.next != null && fast.next.next != null) {
			if (node == slow.next || node == fast.next.next) {
				System.out.println("circular loop");
				return node;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("loop found");
				return fast;
			}
		}
		System.out.println("loop not found");
		return null;
	}

}
