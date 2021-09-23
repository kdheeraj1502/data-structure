package binary.search;

public class AVLTree {

	private Node head;

	static class Node {
		Node left;
		Node right;
		int val;
		int height;

		Node(int val) {
			this.val = val;
			this.height = 1;
			left = right = null;
		}
	}

	public int height(Node root) {
		return root != null ? Math.max(height(root.left), height(root.right)) + 1 : 0;
	}

	public int balanceFactor(Node root) {
		return (height(root.left) - height(root.right));
	}

	public Node insert(int val, Node root) {
		if (root == null) {
			root = new Node(val);
		} else if (val < root.val) {
			root.left = insert(val, root.left);
		} else {
			root.right = insert(val, root.right);
		}
		if (balanceFactor(root) < -1 && val > root.right.val) {
			return leftRotate(root);
		}
		if (balanceFactor(root) < -1 && val < root.right.val) {
			root.right = rightRotate(root);
			leftRotate(root);
		}
		if (balanceFactor(root) > 1 && val > root.left.val) {
			root.left = leftRotate(root);
			rightRotate(root);
		}
		if (balanceFactor(root) > 1 && val < root.left.val) {
			return rightRotate(root);
		}
		return root;
	}

	public void insert(int val) {
		this.head = insert(val, this.head);
	}

	public Node leftRotate(Node root) {
		Node node = root;
		Node right = node.right;
		node.right = right.left;
		right.left = node;
		root = right;
		return root;
	}

	public Node rightRotate(Node root) {
		Node node = root;
		Node left = node.left;
		node.left = left.right;
		left.right = node;
		root = left;
		return root;
	}

	public void displayInOrder(Node root) {
		if (root != null) {
			displayInOrder(root.left);
			System.out.print(root.val + ", ");
			displayInOrder(root.right);
		}
	}

	public int maxHeight(Node root) {
		return root != null ? Math.max(maxHeight(root.left), maxHeight(root.right)) + 1 : 0;
	}

	public void inLineDisplay(Node root) {
		int height = maxHeight(root);
		inLineDisplay(root, height);
	}

	public Node inLineDisplay(Node root, int h) {
		int j = h;
		if(root != null) {
			for (int i = h; i > 0; i++) {
				root = inLineDisplay(root.left, h - 1);
				root = inLineDisplay(root.right, h - 1);
			}
		}
		System.out.println(root.val);
		return null;
	}

	public static void main(String[] args) {
		AVLTree bst = new AVLTree();
		bst.insert(10);//
		bst.insert(20);
		bst.insert(30);
		bst.insert(40);
		bst.insert(19);//
		bst.insert(15);//-------
		bst.insert(25);//
		bst.insert(13);//
		bst.insert(23);//
		bst.insert(33);
		bst.insert(35);
		bst.insert(45);
		bst.insert(05);
		bst.insert(55);
		bst.insert(12);
		bst.insert(11);
		bst.insert(67);
		bst.insert(43);
		bst.insert(17);
		bst.displayInOrder(bst.head);
		System.out.println();
		bst.inLineDisplay(bst.head);
	}
}
