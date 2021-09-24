package binary.search;

public class BST {

	static private Node root;

	public static void insert(int val) {
		root = insert(root, val);
	}

	public static Node getRoot() {
		if (root != null)
			return root;
		else
			return null;
	}

	private static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			if (val < root.val) {
				root.left = insert(root.left, val);
			} else if (val > root.val) {
				root.right = insert(root.right, val);
			}
		}
		return root;
	}

	public static boolean find(Node root, int val) {
		if (root == null)
			return false;
		if (root != null) {
			if (root.val == val)
				return true;
			if (val < root.val) {
				return find(root.left, val);
			} else
				return find(root.right, val);
		}
		return false;
	}

	public static Node findNode(Node root, int val) {
		Node temp = null;
		if (root != null) {
			if (root.val == val) {
				temp = root;
				return temp;
			}
			if (val < root.val) {
				temp = findNode(root.left, val);
				return temp;
			} else {
				temp = findNode(root.right, val);
				return temp;
			}
		}
		return temp;
	}

	public static int findMin(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		Node curr = root;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr.val;
	}

	public static Node findMinNode(Node root) {
		if (root == null)
			return null;
		Node curr = root;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	public static int findMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		Node curr = root;
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr.val;
	}

	public static Node findMaxNode(Node root) {
		if (root == null)
			return null;
		Node curr = root;
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr;
	}
}
