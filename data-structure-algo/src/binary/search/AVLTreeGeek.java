package binary.search;

public class AVLTreeGeek {
	public Node root;

	/*
	 * public int max(int a, int b) { return (a > b) ? a : b; }
	 */

	public Node rightRotate(Node root) {
		Node newRoot = root.left;
		Node right = newRoot.right;
		newRoot.right = root;
		root.left = right;
		return newRoot;
	}

	public Node leftRotate(Node root) {
		Node newRoot = root.right;
		Node left = newRoot.left;
		newRoot.left = root;
		root.right = left;
		return newRoot;
	}

	public int balanceFactor(Node root) {
		int left = height(root.left);
		int right = height(root.right);
		return left - right;
	}

	public Node insert(Node node, int val) {
		if (node == null)
			return (new Node(val));
		if (val < node.val)
			node.left = insert(node.left, val);
		else if (val > node.val)
			node.right = insert(node.right, val);
		else
			return node;
		int bf = balanceFactor(node);
		if (bf < -1 && val > node.right.val)
			return leftRotate(node);
		if (bf < -1 && val < node.right.val) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		if (bf > 1 && val > node.left.val) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}if (bf > 1 && val < node.left.val)
			return rightRotate(node);
		return node;
	}

	public int height(Node root) {
		return root != null ? Math.max(height(root.left), height(root.right)) + 1 : 0;
	}

}