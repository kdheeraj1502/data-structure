package binary.search;

import java.util.ArrayDeque;

public class IsCompleteTree {

	public static boolean isCompleteTree(Node root) {
		ArrayDeque<Node> que = new ArrayDeque<>();
		Node temp;
		int noChild = 0;
		if (root != null)
			que.add(root);
		while (!que.isEmpty()) {
			temp = que.remove();
			if (temp.left != null) {
				if (noChild == 1)
					return false;
				que.add(temp.left);
			} else
				noChild = 1;

			if (temp.right != null) {
				if (noChild == 1)
					return false;
				que.add(temp.right);
			} else
				noChild = 1;

		}
		return true;
	}
}
