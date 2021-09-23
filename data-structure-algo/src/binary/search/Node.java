package binary.search;

public class Node {

	public int val;
	public Node left;
	public Node right;

	public int getVal() {
		return val;
	}
	
	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

	Node(int val) {
		this.val = val;
		this.left = this.right = null;
	}

	Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
