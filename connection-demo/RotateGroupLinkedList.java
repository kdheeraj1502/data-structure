
public class RotateGroupLinkedList {

	static SingleLinkedList head;

	public static SingleLinkedList roatateKGroup(SingleLinkedList head, int k) {

		int size = 0;
		SingleLinkedList node = head;
		while (node != null) {
			node = node.next;
			size++;
		}

		node = head;
		SingleLinkedList prev = null;
		SingleLinkedList next = null;
		SingleLinkedList output = null;
		SingleLinkedList p = null;
		SingleLinkedList pp = null;
		int quotient = size / k;

		while (quotient-- > 0) {
			int i = 0;
			pp = p;
			p = node;
			while (i++ < k) {
				next = node.next;
				node.next = prev;
				prev = node;
				node = next;
			}
			if (pp == null)
				output = prev;
			if (p != null)
				p.next = node;
			if (pp != null)
				pp.next = prev;
		}
		return output;
	}

	public static void main(String[] args) {
		head = new SingleLinkedList(1);
		head.next = new SingleLinkedList(2);
		head.next.next = new SingleLinkedList(3);
		head.next.next.next = new SingleLinkedList(4);
		head.next.next.next.next = new SingleLinkedList(5);
		head.next.next.next.next.next = new SingleLinkedList(6);
		head.next.next.next.next.next.next = new SingleLinkedList(7);
		SingleLinkedList result = roatateKGroup(head, 3);
		System.out.println(result.toString());
	}

}

class SingleLinkedList {
	int val;
	SingleLinkedList next;

	SingleLinkedList(int val) {
		this.val = val;
		next = null;
	}

	@Override
	public String toString() {
		return "[val=" + val + ", next=" + next + "]";
	}

	SingleLinkedList() {
	}
}