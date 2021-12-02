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
		return "[ val :" + val + ", left :" + (left != null ? left.val + " " : "_") + ", right : "
				+ (right != null ? right.val + " " : "_") + "] ";
	}

	public Node(int val) {
		this.val = val;
		this.left = this.right = null;
	}

	public Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
