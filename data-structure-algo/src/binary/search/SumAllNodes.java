package binary.search;

public class SumAllNodes {

	public static int sumAllNodes(Node root) {
		if (root == null)
			return 0;
		return root.val + sumAllNodes(root.left) + sumAllNodes(root.right);
	}
}
