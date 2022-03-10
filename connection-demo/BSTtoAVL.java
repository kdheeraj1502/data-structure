
public class BSTtoAVL {

	static private BSTTree root;

	static class BSTTree {

		int val;
		BSTTree left;
		BSTTree right;
		public int height;

		BSTTree(int val) {
			this.val = val;
		}
	}

	public static BSTTree createTree(int val) {
		root = createTree(root, val);
		return root;
	}

	public static BSTTree createTree(BSTTree root, int val) {
		if (root == null) {
			root = new BSTTree(val);
		} else if (val < root.val) {
			root.left = createTree(root.left, val);
		} else {
			root.right = createTree(root.right, val);
		}
		return root;
	}

	public BSTTree ceateAVLTree(BSTTree node) {
		updateHeight(node);
		if (getBalance(node) > 1) {
			if(height(node.right.right) > height(node.right.left)) {
				node = rotateLeft(node);
			}
			else {
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			}
		}
		if (height(node.left) - height(node.right) < -1) {
			if (height(node.left.left) > height(node.left.right))
	            node = rotateRight(node);
	        else {
	            node.left = rotateLeft(node.left);
	            node = rotateRight(node);
	        }
		}
		return null;
	}
	
	private BSTTree rotateLeft(BSTTree y) {
		BSTTree x = y.right;
		BSTTree z = x.left;
	    x.left = y;
	    y.right = z;
	    updateHeight(y);
	    updateHeight(x);
	    return x;
	}

	private BSTTree rotateRight(BSTTree y) {
		BSTTree x = y.left;
		BSTTree z = x.right;
	    x.right = y;
	    y.left = z;
	    updateHeight(y);
	    updateHeight(x);
	    return x;
	}
	
	 void updateHeight(BSTTree n) {
	        n.height = 1 + Math.max(height(n.left), height(n.right));
	    }


	private int getBalance(BSTTree node) {
		return node == null ? 0 : height(node.left) - height(node.right);
	}

	public static int height(BSTTree node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public static void inOrder(BSTTree root) {
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
			createTree(num);
		}
		inOrder(root);
		System.out.println("-------------------------------------------------------------");
		System.out.println(root.val + ": root left height " + 
				(height(root) + " and root right height:" + (height(root) + ", ")));
		BSTtoAVL bta = new BSTtoAVL();
	//	bta.ceateAVLTree(root);
		inOrder(root);
	}

}
