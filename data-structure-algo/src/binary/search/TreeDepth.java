package binary.search;

public class TreeDepth {

	public static int treeDepth(Node root) {
		int left, right;
		if(root == null) return 0;
		left = treeDepth(root.left);
		right = treeDepth(root.right);
		return Math.max(left, right) + 1;
	}
}
