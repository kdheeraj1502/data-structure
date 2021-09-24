package binary.search;

public class TrimOutSodeRange {

	public static Node tripOutsideRange(Node root, int min, int max) {
		if (root == null)
			return null;
		root.left = tripOutsideRange(root.left, min, max);
		root.right = tripOutsideRange(root.right, min, max);
		if (root.val < min) {
			return root.right;
		}
		if (root.val > max) {
			return root.left;
		}
		return root;
	}
}
