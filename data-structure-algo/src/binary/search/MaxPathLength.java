package binary.search;

public class MaxPathLength {

	public static int maxPathLength(Node root) {
		int max, leftDepth, rightDepth, leftPath, rightPath;
		if (root == null)
			return 0;
		leftDepth = TreeDepth.treeDepth(root.left);
		rightDepth = TreeDepth.treeDepth(root.right);

		max = leftDepth + rightDepth + 1;
		leftPath = maxPathLength(root.left);
		rightPath = maxPathLength(root.right);

		if (max < leftPath)
			max = leftPath;
		if (max < rightPath)
			max = rightPath;
		return max;
	}
	
	public static int maxPathLength_self(Node root) {
		if(root == null) return 0;
		int leftDepth, rightDepth, leftPath, rightPath, max;
		leftDepth = TreeDepth.treeDepth(root.left);
		rightDepth = TreeDepth.treeDepth(root.right);
		max = leftDepth + rightDepth + 1;
		
		leftPath = maxPathLength_self(root.left);
		rightPath = maxPathLength_self(root.right);
		
		max = Math.max(leftPath, max);
		max = Math.max(rightPath, max);
		
		return max;
	}
}
