package binary.avl.tree;

public class AVLTreeBaeldung {

	public class Node {
		int key;
		int height;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;
		}
	}

	private Node root;

	public Node find(int key) {
		Node current = root;
		while (current != null) {
			if (current.key == key) {
				break;
			}
			current = current.key < key ? current.right : current.left;
		}
		return current;
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	public void delete(int key) {
		root = delete(root, key);
	}

	public Node getRoot() {
		return root;
	}

	public int height() {
		return root == null ? -1 : root.height;
	}

	private Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		} else if (node.key > key) {
			node.left = insert(node.left, key);
		} else if (node.key < key) {
			node.right = insert(node.right, key);
		} else {
			throw new RuntimeException("duplicate Key!");
		}
		return rebalance(node);
	}

	private Node delete(Node node, int key) {
		if (node == null) {
			return node;
		} else if (node.key > key) {
			node.left = delete(node.left, key);
		} else if (node.key < key) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null || node.right == null) {
				node = (node.left == null) ? node.right : node.left;
			} else {
				Node mostLeftChild = mostLeftChild(node.right);
				node.key = mostLeftChild.key;
				node.right = delete(node.right, node.key);
			}
		}
		if (node != null) {
			node = rebalance(node);
		}
		return node;
	}

	private Node mostLeftChild(Node node) {
		Node current = node;
		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	private Node rebalance(Node root) {
		updateHeight(root);
		int balance = getBalance(root);
		if (balance > 1) {
			if (height(root.left.left) > height(root.left.right)) {
				root = rotateRight(root);
			} else {
				root.left = rotateLeft(root.left);
				root = rotateRight(root);
			}
		} else if (balance < -1) {
			if (height(root.right.right) > height(root.right.left)) {
				root = rotateLeft(root);
			} else {
				root.right = rotateRight(root.right);
				root = rotateLeft(root);
			}
		}
		return root;
	}

	private Node rotateRight(Node root) {
		Node left = root.left;
		Node leftRight = left.right;
		root.left = leftRight;
		left.right = root;
		updateHeight(root);
		updateHeight(left);
		return left;
	}

	private Node rotateLeft(Node root) {
		Node right = root.right;
		Node rightLeft = right.left;
		root.right = rightLeft;
		right.left = root;
		updateHeight(root);
		updateHeight(right);
		return right;
	}

	/*
	 * private void updateHeight(Node n) { n.height = 1 + Math.max(height(n.left),
	 * height(n.right)); }
	 */

	public static void updateHeight(Node root) {
		/*
		 * if (root == null) return 0; int height = Math.max(updateHeight(root.left) +
		 * 1, updateHeight(root.right) + 1); root.height = height - 1; return height;
		 */
		root.height = 1 + Math.max(height(root.left), height(root.right));
	}

	private static int height(Node n) {
		return n == null ? -1 : n.height;
	}

	public int getBalance(Node n) {
		return (n == null) ? 0 : height(n.left) - height(n.right);
	}

	public void inOrder(Node root) {
		if (root != null) {
			System.out.print(root.key + ", ");
			inOrder(root.left);
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		AVLTreeBaeldung atb = new AVLTreeBaeldung();
		int nums[] = { 40, 20, 10, 25, 30, 22, 50 };
		for (int num : nums) {
			atb.insert(num);
		}
		atb.inOrder(atb.root);
	}
}
