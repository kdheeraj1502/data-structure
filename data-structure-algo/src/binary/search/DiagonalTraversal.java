package binary.search;

import java.util.*;

public class DiagonalTraversal {

	static Node root;

	public static List<List<Integer>> diagonalTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			while (size-- > 0) {
				Node temp = queue.remove();
				while (temp != null) {
					list.add(temp.val);
					if (temp.left != null) {
						queue.add(temp.left);
					}
					temp = temp.right;
				}
				result.add(list);
			}
		}
		return result;
	}
/*
 * 					3
 *         1                 4
 *    0        2       2          8
 * 
 * 
 * 
 */
	public static List<Integer> diagonalTraversal_list(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Node temp = queue.remove();
				while (temp != null) {
					result.add(temp.val);
					if (temp.left != null) {
						queue.add(temp.left);
					}
					temp = temp.right;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(0);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		System.out.println(diagonalTraversal_list(root));
		System.out.println(diagonalTraversal(root));
	}
}
