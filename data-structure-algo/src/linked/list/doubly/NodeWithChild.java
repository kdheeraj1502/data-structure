package linked.list.doubly;

public class NodeWithChild {
	NodeWithChild next;
	NodeWithChild prev;
	NodeWithChild child;
	int val;

	NodeWithChild() {
	}

	NodeWithChild(int val) {
		next = prev = child = null;
		this.val = val;
	}

	NodeWithChild(int val, NodeWithChild prev, NodeWithChild next, NodeWithChild child) {
		this.val = val;
		this.next = next;
		this.prev = prev;
		this.child = child;
	}
}
