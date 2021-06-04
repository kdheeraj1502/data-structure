package red.black.tree;

public class Node {

	private int val;
	private NodeColor color;
	private Node left;
	private Node right;
	private Node parent;

	public Node(int val) {
		this.val = val;
		this.color = NodeColor.RED;
	}

	@Override
	public String toString() {
		/*
		 * "Node [Current val=" + val + ", color=" + color + ", left=" + left != null ?
		 * "" + left.val : " null " + ", right=" + right != null ? "" + right.val :
		 * " null " + ", " + "parent=" + parent.val + "]";
		 */
		
		StringBuilder result = new StringBuilder("Node [ val=" + val + ", color=" + color + "]");
		if(left != null) {
			result.append("\n");
			result.append(" Left val is ");
			result.append(left.val);
			result.append("\n");
		}
		if(right != null) {
			result.append("\n");
			result.append(" right val is ");
			result.append(right.val);
			result.append("\n");
		}
		if(left == null) {
			result.append("\n");
			result.append(" Left val is ");
			result.append(" null ");
			result.append("\n");
		}
		if(right == null) {
			result.append("\n");
			result.append(" right val is ");
			result.append(" null ");
			result.append("\n");
		}
		return result.toString();
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}
