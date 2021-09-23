package binary.search;

public class SearchValInTree {

	public static boolean search(Node root, int val) {
		boolean status;
		if (root == null) {
			status = false;
			return status;
		}
		if (root.val == val) {
			status = true;
			return status;
		}
		status = search(root.left, val);
		if (status)
			return status;
		status = search(root.right, val);
		if (status)
			return status;
		return false;
	}
}
