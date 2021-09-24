package binary.search;

public class BinaryTreeFromSortedList {

	public static Node createBinaryTree(int num[]) {
		return createBinaryTree(num, 0, num.length - 1);
	}
	
	private static Node createBinaryTree(int num[], int start, int end) {
		Node root = null;
		if(start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		root = new Node(num[mid]);
		root.left = createBinaryTree(num, start, mid - 1);
		root.right = createBinaryTree(num, mid + 1, end);
		return root;
	}
}
