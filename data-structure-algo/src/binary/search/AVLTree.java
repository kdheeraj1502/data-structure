package binary.search;

public class AVLTree {

	private Node head;

	AVLTreeGeek avl1 = new AVLTreeGeek();

	/*
	 * public int height(Node root) { return root != null ?
	 * Math.max(height(root.left), height(root.right)) + 1 : 0; }
	 * 
	 * public int balanceFactor(Node root) { int left = height(root.left); int right
	 * = height(root.right); return left - right; }
	 */

	public int height(Node root) {
		return root != null ? Math.max(height(root.left), height(root.right)) + 1 : 0;
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
		}
		if (bf > 1 && val < node.left.val)
			return rightRotate(node);
		return node;
	}

	public Node leftRotate(Node root) {
		Node newRoot = root.right;
		Node left = newRoot.left;
		newRoot.left = root;
		root.right = left;
		return newRoot;
	}


	public Node rightRotate(Node root) {
		Node newRoot = root.left;
		Node right = newRoot.right;
		root.left = right;
		newRoot.right = root;
		return newRoot;
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
		if (root != null) {
			for (int i = h; i > 0; i++) {
				root = inLineDisplay(root.left, h - 1);
				root = inLineDisplay(root.right, h - 1);
			}
		}
		System.out.println(root.val);
		return null;
	}

	public static void main(String[] args) {
		AVLTree_1 bst = new AVLTree_1();
		AVLTreeGeek avl = new AVLTreeGeek();

		bst.head = bst.insert(bst.head, 10);//
		bst.head = bst.insert(bst.head, 20);
		bst.head = bst.insert(bst.head, 30);
		bst.head = bst.insert(bst.head, 40);
		bst.head = bst.insert(bst.head, 19);
		bst.head = bst.insert(bst.head, 15);
		bst.head = bst.insert(bst.head, 25);
		bst.head = bst.insert(bst.head, 13);
		bst.head = bst.insert(bst.head, 23);
		bst.head = bst.insert(bst.head, 33);
		bst.head = bst.insert(bst.head, 35);
		bst.head = bst.insert(bst.head, 45);
		bst.head = bst.insert(bst.head, 05);
		bst.head = bst.insert(bst.head, 55);
		bst.head = bst.insert(bst.head, 12);
		bst.head = bst.insert(bst.head, 11);
		bst.head = bst.insert(bst.head, 67);
		bst.head = bst.insert(bst.head, 43);
		bst.head = bst.insert(bst.head, 17);

		avl.root = avl.insert(avl.root, 10);//
		avl.root = avl.insert(avl.root, 20);
		avl.root = avl.insert(avl.root, 30);
		avl.root = avl.insert(avl.root, 40);
		avl.root = avl.insert(avl.root, 19);//
		avl.root = avl.insert(avl.root, 15);// -------
		avl.root = avl.insert(avl.root, 25);//
		avl.root = avl.insert(avl.root, 13);//
		avl.root = avl.insert(avl.root, 23);//
		avl.root = avl.insert(avl.root, 33);
		avl.root = avl.insert(avl.root, 35);
		avl.root = avl.insert(avl.root, 45);
		avl.root = avl.insert(avl.root, 05);
		avl.root = avl.insert(avl.root, 55);
		avl.root = avl.insert(avl.root, 12);
		avl.root = avl.insert(avl.root, 11);
		avl.root = avl.insert(avl.root, 67);
		avl.root = avl.insert(avl.root, 43);
		avl.root = avl.insert(avl.root, 17);

		LevelOrderTraversal.levelOrderTopToDown(bst.head);
		System.out.println("geek");
		LevelOrderTraversal.levelOrderTopToDown(avl.root);
		// bst.displayInOrder(bst.head);
		System.out.println();
		// bst.inLineDisplay(bst.head);
	}
}
