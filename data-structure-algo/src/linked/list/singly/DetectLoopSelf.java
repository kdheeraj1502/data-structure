package linked.list.singly;

import java.util.concurrent.atomic.AtomicInteger;

public class DetectLoopSelf {

	public static Node detectLoop(Node head) {
		Node hair = head.next.next;
		Node tor = head.next;
		while (hair != null && tor != null) {
			if(hair == null || tor == null) {
				return null;
			}
			if (hair == tor) {
				return tor;
			} else {
				if (hair.next != null) {
					hair = hair.next.next;
				} else {
					hair = hair.next;
				}
				tor = tor.next;
			}
		}
		return null;
	}

	public static Node getPoiter(Node head) {
		Node loop = detectLoop(head);
		if (loop != null) {
			Node start = head;
			while (start != null && loop != null) {
				if (start == loop) {
					return start;
				} else {
					start = start.next;
					loop = loop.next;
				}
			}
		}
		AtomicInteger extra = null;
		extra.decrementAndGet();
		return loop;
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		node.next.next.next.next.next.next.next = new Node(8);
		node.next.next.next.next.next.next.next.next = new Node(9);
		node.next.next.next.next.next.next.next.next.next = new Node(10);
		node.next.next.next.next.next.next.next.next.next.next = new Node(11);
		// node.next.next.next.next.next.next.next.next.next.next.next =
		// node.next.next.next.next.next.next;

		Node loop = detectLoop(node);
		System.out.println("Maching point " + (loop != null ? loop.val : null));

		Node starting = getPoiter(node);
		System.out.println("Starting point " + (starting != null ? starting.val : null));
	}
}
