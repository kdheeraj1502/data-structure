package binary.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeDepth {

	public static int treeDepth(Node root) {
		int left, right;
		if (root == null)
			return 0;
		left = treeDepth(root.left);
		right = treeDepth(root.right);
		return Math.max(left, right) + 1;
	}

	public static int treeDepthWithoutRecursion(Node root) {
		Node curr = root;
		Queue<Node> que = new ArrayDeque<>();
		que.add(curr);
		int depth = 0;
		while (!que.isEmpty()) {
			int j = que.size();
			while (j > 0) {
				if (!que.isEmpty()) {
					curr = que.remove();
				}
				j--;
			}
			if (curr.left != null) {
				que.add(curr.left);
			}
			if (curr.right != null) {
				que.add(curr.right);
			}
			depth++;
		}
		return depth;
	}
}
