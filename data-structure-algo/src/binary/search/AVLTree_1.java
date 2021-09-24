package binary.search;

public class AVLTree_1 {
	
	public Node head;

	public static int height(Node node) {
		return node != null ? Math.max(height(node.left), height(node.right)) + 1 : 0;
	}

	public static int balance(Node node) {
		return height(node.left) - height(node.right);
	}

	public static Node insert(int val) {
		Node node = null;
		return insert(node, val);
	}

	public static Node rightRotate(Node node) {
		Node newRoot = node.left;
		Node right =  newRoot.right;
		node.left = right;
		newRoot.right = node;
		return newRoot;
	}

	public static Node leftRotate(Node node) {
		Node newRoot = node.right;
		Node left = newRoot.left;
		node.right = left;
		newRoot.left = node;
		return newRoot;
	}

	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
		} else if (val < root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		} else
			return root;
		int bf = balance(root);
		if (bf > 1 && val < root.left.val)
			return rightRotate(root);
		else if (bf > 1 && val > root.left.val) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		} else if (bf < -1 && val > root.right.val) {
			return leftRotate(root);
		} else if (bf < -1 && val < root.right.val) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}
}
