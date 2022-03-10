package binary.avl.tree;

public class AVLTree {

	static BinaryTree root;

	public static BinaryTree insert(int val) {
		root = insert(root, val);
		return root;
	}

	public static BinaryTree insert(BinaryTree root, int val) {
		if (root == null)
			return new BinaryTree(val);
		else if (val < root.val) {
			root.left = insert(root.left, val);
		}
		else if (val > root.val) {
			root.right = insert(root.right, val);
		} else {
			throw new RuntimeException("Duplicate val");
		}
		return rebalance(root, val);
	}

	public static BinaryTree rebalance(BinaryTree root, int val) {
		updateHeight(root);
		int balance = getBalance(root);
		if(balance > 1) {
			if (height(root.right.right) > height(root.right.left)) {
				root = rotateLeft(root);
	        } else {
	        	root.right = rotateRight(root.right);
	        	root = rotateLeft(root);
	        }
		}else if(balance < -1) {
			if (height(root.left.left) > height(root.left.right))
				root = rotateRight(root);
	        else {
	        	root.left = rotateLeft(root.left);
	        	root = rotateRight(root);
	        }
		}
		return root;
	}

	public static void updateHeight(BinaryTree root) {
		//root.height = Math.max(height(root.left), height(root.right)) + 1;
		root.height = height(root);
	}

	public static int height(BinaryTree root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public static int getBalance(BinaryTree root) {
		return root == null ? null : height(root.left) - height(root.right);
	}

	public static BinaryTree rotateRight(BinaryTree root) {
		BinaryTree left = root.left;
		BinaryTree right = left.right;
		left.right = root;
		root.left = right;
		updateHeight(root);
		updateHeight(left);
		return left;
	}

	public static BinaryTree rotateLeft(BinaryTree root) {
		BinaryTree right = root.right;
		BinaryTree left = right.left;
		right.left = root;
		root.right = left;
		updateHeight(root);
		updateHeight(right);
		return right;
	}
	public static void inOrder(BinaryTree root) {
		if (root != null) {
			System.out.println(root.val + ": root left height " + 
		(height(root.left) + " and root right height:" + (height(root.right))));
			inOrder(root.left);
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		int nums[] = { 40, 20, 10, 25, 30, 22, 50 };
		for (int num : nums) {
			insert(num);
		}
		inOrder(root);
	}
}

class BinaryTree {
	public BinaryTree left;
	public BinaryTree right;
	public int val;
	public int height;

	public BinaryTree(int val) {
		this.left = this.right = null;
		this.val = val;
	}
	

	@Override
	public String toString() {
		return "val=" + val + " [left=" + left + ", right=" + right + ", height=" + height + "]";
	}



	public BinaryTree() {
	}
}
