package red.black.tree;

public class TraverseBST {

	private static int maxHeight(Node root, int left, int right) {
		if(root == null) return 1;
		if(root != null) {
			left = maxHeight(root.getLeft(), left, right) + 1;
			right = maxHeight(root.getRight(), left, right) + 1;
			return Math.max(left, right);
		}
		return -1;
	}
	
	public static void onLevelTraverse(Node root, int h) {
		
	}
	
	public static void onLevelTraverse(Node root) {
		int height = maxHeight(root, 0, 0);
		System.out.println("max height is " + height);
		onLevelTraverse(root, height);
	}
}
