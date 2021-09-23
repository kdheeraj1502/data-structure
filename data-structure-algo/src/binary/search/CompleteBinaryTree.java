package binary.search;

public class CompleteBinaryTree {

	static private Node root;

	public static Node getRoot() {
		return root;
	}
	
	public static void levelOrderBinaryTree(int num[]) {
		root = levelOrderBinaryTree(num, 0);
	}

	private static Node levelOrderBinaryTree(int[] num, int start) {
		int size = num.length;
		Node curr = new Node(num[start]);
		int leftIndex = 2 * start + 1;
		int rightIndex = 2 * start + 2;
		if (leftIndex < size) {
			curr.left = levelOrderBinaryTree(num, leftIndex);
		}
		if (rightIndex < size) {
			curr.right = levelOrderBinaryTree(num, rightIndex);
		}
		return curr;
	}
}
