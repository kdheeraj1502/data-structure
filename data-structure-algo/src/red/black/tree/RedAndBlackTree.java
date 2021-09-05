package red.black.tree;

public class RedAndBlackTree implements Tree {

	private Node root;

	@Override
	public void traverse() {
		if (root != null)
			inOrderTraversal(root);
	}

	public Node getRoot() {
		if (root != null)
			return this.root;
		return null;
	}

	private void inOrderTraversal(Node node) {
		if (node.getLeft() != null) {
			inOrderTraversal(node.getLeft());
		}
		System.out.print(node + ", ");
		if (node.getRight() != null) {
			inOrderTraversal(node.getRight());
		}
	}

	private Node rightRotate(Node root) {
	//	System.out.println("Rotating to the right on " + root);
		Node node = root;
		Node left = node.getLeft();
		node.setLeft(left.getRight());
		if(node.getParent() != null)
			node.getParent().setRight(left);
		left.setParent(node.getParent());
		left.setRight(node);
		node.setParent(left);
		return left;
	}

	private Node leftRotate(Node root) {
	//	System.out.println("Rotating to the left on " + root);
		Node node = root;
		Node right = node.getRight();
		node.setRight(right.getLeft());
		if(node.getParent() != null)
			node.getParent().setLeft(right);
		right.setParent(node.getParent());
		right.setLeft(node);
		node.setParent(right);
		return right;
	}

	@Override
	public void insert(int val) {
		Node node = new Node(val);
		root = insertIntoTree(root, node);
		fixViolation(node);
	}

	private Node insertIntoTree(Node root, Node node) {
		if (root == null)
			return node;
		if (node.getVal() == root.getVal()) {
			return node;
		}
		if (node.getVal() < root.getVal()) {
			Node node2 = insertIntoTree(root.getLeft(), node);
			root.setLeft(node2);
			root.getLeft().setParent(root);
		} else if (node.getVal() > root.getVal()) {
			Node node2 = insertIntoTree(root.getRight(), node);
			root.setRight(node2);
			node2.setParent(root);
		}
		return root;
	}

	private void fixViolation(Node node) {
		Node parent = null;
		Node grand = null;
		while (node != this.root && node.getColor() != NodeColor.BLACK
				&& node.getParent().getColor() == NodeColor.RED) {
			System.out.println(root.getVal());
			parent = node.getParent();
			grand = node.getParent().getParent();

			if (parent == grand.getLeft()) {
				Node uncle = grand.getRight();
				if (uncle != null && uncle.getColor() == NodeColor.RED) {
					uncle.setColor(NodeColor.BLACK);
					parent.setColor(NodeColor.BLACK);
					grand.setColor(NodeColor.RED);
					node = grand;
				} else {                               /// uncle is black
					if (node == parent.getRight()) {
						grand.setLeft(leftRotate(parent));
						node = parent;
						parent = node.getParent();
					}
					parent.setRight(rightRotate(grand));
					NodeColor tempColor = parent.getColor();
					parent.setColor(grand.getColor());
					grand.setColor(tempColor);
					node = parent;
				}
			} else {
				Node uncle = grand.getLeft();
				if (uncle != null && uncle.getColor() == NodeColor.RED) {
					uncle.setColor(NodeColor.BLACK);
					parent.setColor(NodeColor.BLACK);
					grand.setColor(NodeColor.RED);
					node = grand;
				} else {
					if (node == parent.getLeft()) {
						grand.setRight(rightRotate(parent));
						System.out.println(root.getVal());
						node = parent;
						parent = node.getParent();
					}
					parent.setLeft(leftRotate(grand));
					NodeColor tempColor = parent.getColor();
					parent.setColor(grand.getColor());
					grand.setColor(tempColor);
					node = parent;
				}
			}
		}
		if (root.getColor() == NodeColor.RED)
			root.setColor(NodeColor.BLACK);
	}

}
