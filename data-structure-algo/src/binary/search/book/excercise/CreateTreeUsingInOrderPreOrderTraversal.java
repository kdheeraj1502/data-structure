package binary.search.book.excercise;

import java.util.*;

import binary.search.LevelOrderTraversal;
import binary.search.Node;

public class CreateTreeUsingInOrderPreOrderTraversal {

	static int preIndex = 0;
	static Map<Integer, Integer> map = new HashMap<>();

	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	// 6, 4, 2, 1, 3, 5, 8, 7, 9, 10
	public static Node createTree(int inOrder[], int preOrder[], int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		Node node = new Node(preOrder[preIndex++]);
		if (inStart == inEnd)
			return node;
		int inOrderIndex = search(inOrder, inStart, inEnd, node.val);
		node.left = createTree(inOrder, preOrder, inStart, inOrderIndex - 1);
		node.right = createTree(inOrder, preOrder, inOrderIndex + 1, inEnd);
		return node;
	}

	public static Node createTreeUsingHashMap(int inOrder[], int preOrder[], int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		Node node = new Node(preOrder[preIndex++]);
		if (inStart == inEnd)
			return node;
		int inOrderIndex = map.get(node.val);
		//int inOrderIndex = search(inOrder, inStart, inEnd, node.val);
		node.left = createTree(inOrder, preOrder, inStart, inOrderIndex - 1);
		node.right = createTree(inOrder, preOrder, inOrderIndex + 1, inEnd);
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
		int preOrder[] = { 6, 4, 2, 1, 3, 5, 8, 7, 9, 10 }; // PLR

		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		Node n = createTreeUsingHashMap(inOrder, preOrder, 0, inOrder.length - 1);
		LevelOrderTraversal.levelOrderTopToDown(n);
	}
}
