package binary.search;

public class IsBalancedBinaryTree {

	/**
	 * SOLUTION 1
	 * @param root
	 * @return
	 */
    public boolean isBalanced_1(TreeNode root) {
        if(root == null) return true;
        int left = height_1(root.left);
        int right = height_1(root.right);
        return ((Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right));
    }
    
    private int height_1(TreeNode root){
        return root != null ? Math.max(height_1(root.left), height_1(root.right)) + 1 : 0;
    }
    
    /**
     * solution 2
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return check(root) != -1;
	}

	public int check(TreeNode root) {
		if (root == null)
			return 0;
		int left = check(root.left);
		if (left == -1)
			return -1;
		int right = check(root.right);
		if (right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		int a = Math.max(left, right) + 1;
		return a;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);

		root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		IsBalancedBinaryTree ib = new IsBalancedBinaryTree();
		System.out.println(ib.isBalanced(root));
	}
}
