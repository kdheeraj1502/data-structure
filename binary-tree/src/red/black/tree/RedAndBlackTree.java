package red.black.tree;

public class RedAndBlackTree implements Tree {

	private Node root;

	@Override
	public void traverse() {
		if (root != null)
			inOrderTraversal(root);

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
		System.out.println("Rotating to the right on " + root);
		Node node = root;
		Node left = node.getLeft();
		node.setLeft(left.getRight());
		left.setParent(node.getParent());
		left.setRight(node);
		node.setParent(left);
		root = left;
		return root;
	}
	
	private Node leftRotate(Node root) {
		System.out.println("Rotating to the left on " + root);
		Node node = root;
		Node right = node.getRight();
		node.setRight(right.getLeft());
		right.setParent(node.getParent());
		right.setLeft(node);
		node.setParent(right);
		root = right;
		return root;
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
		if (node.getVal() < root.getVal()) {
			root.setLeft(insertIntoTree(root.getLeft(), node));
			root.getLeft().setParent(root);
		} else if (node.getVal() > root.getVal()) {
			root.setRight(insertIntoTree(root.getRight(), node));
			root.getRight().setParent(root);
		}
		return root;
	}

	private void fixViolation(Node node) {
		
		Node parent = null;
		Node grand = null;
		
		while(node != this.root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {
			parent = node.getParent();
			grand = node.getParent().getParent();
			
			if(parent == grand.getLeft()) {
				Node uncle = grand.getRight();
				if(uncle != null && uncle.getColor() == NodeColor.RED) {
					uncle.setColor(NodeColor.BLACK);
					parent.setColor(NodeColor.BLACK);
					grand.setColor(NodeColor.RED);
					node = grand;
				}
				else {
					if(node == parent.getRight()) {
						root = leftRotate(parent);
						node = parent;
						parent = node.getParent();
					}
					root = rightRotate(grand);
					NodeColor tempColor = parent.getColor();
					parent.setColor(grand.getColor());
					grand.setColor(tempColor);
					node = parent;
				}
			}
			else {
				Node uncle = grand.getLeft();
				if(uncle != null && uncle.getColor() == NodeColor.RED) {
					uncle.setColor(NodeColor.BLACK);
					parent.setColor(NodeColor.BLACK);
					grand.setColor(NodeColor.RED);
					node = grand;
				}
				else {
					if(node == parent.getLeft()) {
						root = rightRotate(parent);
						node = parent;
						parent = node.getParent();
					}
					root = leftRotate(grand);
					NodeColor tempColor = parent.getColor();
					parent.setColor(grand.getColor());
					grand.setColor(tempColor);
					node = parent;
				}
			}
		}
		if(root.getColor() == NodeColor.RED)
			root.setColor(NodeColor.BLACK);
	}

}
