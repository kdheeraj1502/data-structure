package binary.search.book.excercise;

import binary.search.LevelOrderTraversal;
import binary.search.Node;

public class CreateTreeUsingInOrderPostOrderTraversal {
	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	// 1, 3, 2, 5, 4, 7, 10, 9, 8, 6
	public static Node createTree(int inOrder[], int postOrder[], int inStart, int inEnd, int postStrt, int postEnd) {
		if (inStart > inEnd) {
			return null;
		}
		Node node = new Node(postOrder[postEnd]);
		if (inStart == inEnd)
			return node;
		int inOrderIndex = search(inOrder, inStart, inEnd, node.val);
		node.left = createTree(inOrder, postOrder, inStart, inOrderIndex - 1, postStrt,
				postStrt - inStart + inOrderIndex - 1);
		node.right = createTree(inOrder, postOrder, inOrderIndex + 1, inEnd, postEnd - inEnd + inOrderIndex,
				postEnd - 1);

		return node;
	}

	private static int search(int inOrder[], int inStart, int inEnd, int val) {
		int result = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == val) {
				result = i;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int inOrder[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // LPR
		int postOrder[] = { 1, 3, 2, 5, 4, 7, 10, 9, 8, 6 }; // PLR
		Node n = createTree(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
		LevelOrderTraversal.levelOrderTopToDown(n);
	}
}
