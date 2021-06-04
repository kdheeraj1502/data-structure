package binary.tree;

public class BinarySearchTree {

	private Node head;

	public BinarySearchTree() {
		head = null;
	}

	static class Node {
		Node left;
		Node right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	private Node insert(int val, Node root) {
		if (root == null) {
			root = new Node(val);
		} else if (val < root.val) {
			root.left = insert(val, root.left);
		} else {
			root.right = insert(val, root.right);
		}
		return root;
	}

	public void insert(int val) {
		head = insert(val, this.head);
	}

	public void displayPreOrder(Node root) {
		if (root != null) {
			System.out.print(root.val + ", ");
			displayPreOrder(root.left);
			displayPreOrder(root.right);
		}
	}

	public void displayPostOrder(Node root) {
		if (root != null) {
			displayPostOrder(root.left);
			displayPostOrder(root.right);
			System.out.print(root.val + ", ");
		}
	}

	public void displayInOrder(Node root) {
		if (root != null) {
			displayInOrder(root.left);
			System.out.print(root.val + ", ");
			displayInOrder(root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(15);
		bst.insert(18);
		bst.insert(7);
		bst.insert(5);
		bst.insert(9);
		bst.insert(17);
		bst.displayInOrder(bst.head);
	}
}
