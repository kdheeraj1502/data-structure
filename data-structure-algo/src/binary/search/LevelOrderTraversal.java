package binary.search;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

	public static void levelOrderTopToDown(Node root) {
		Queue<Node> que = new ArrayDeque<>();
		Node temp = null;
		if (root != null)
			que.add(root);
		while (!que.isEmpty()) {
			int j = que.size();
			System.out.print("[ ");
			while (j > 0) {
				if (!que.isEmpty())
					temp = que.remove();
				else
					j = 0;
				System.out.print(" " + temp.val);
				if (temp.left != null)
					que.add(temp.left);
				if (temp.right != null)
					que.add(temp.right);
				j--;
				if (j > 0)
					System.out.print(",");
			}
			System.out.print(" ]");
			System.out.println();
		}
	}

	public static void levelOrderTopToDownLineByLine(Node root) {
		Queue<Node> que1 = new ArrayDeque<>();
		Queue<Node> que2 = new ArrayDeque<>();
		Node temp = root;
		if (root != null)
			que1.add(temp);
		while (que1.size() > 0 || que2.size() > 0) {
			System.out.print("[ ");
			while (!que1.isEmpty()) {
				temp = que1.remove();
				System.out.print(temp.val + ", ");
				if (temp.left != null) {
					que2.add(temp.left);
				}
				if (temp.right != null) {
					que2.add(temp.right);
				}
			}
			System.out.print("]");
			System.out.println();
			System.out.print("[ ");
			while (!que2.isEmpty()) {
				temp = que2.remove();
				System.out.print(temp.val + ", ");
				if (temp.left != null) {
					que1.add(temp.left);
				}
				if (temp.right != null) {
					que1.add(temp.right);
				}
			}
			System.out.println(" ]");
		}
	}

	public static void levelOrderDownToTop(Node root) {
		Stack<Node> stack = new Stack<>();
		Queue<Node> que = new ArrayDeque<>();
		if (root != null)
			que.add(root);
		Node temp;
		int j;
		while (!que.isEmpty()) {
			j = que.size();
			while (j > 0) {
				if (!que.isEmpty()) {
					temp = que.remove();
					stack.push(temp);
					if (temp.right != null) {
						que.add(temp.right);
					}
					if (temp.left != null) {
						que.add(temp.left);
					}
					j--;
				}
			}
			
			while (!stack.isEmpty()) {
				int val = stack.pop().val;
				if (val == Integer.MIN_VALUE) {
					System.out.println("");
				} else {
					System.out.print(val + ", ");
				}
			}
			System.out.println();
		}

		/*
		 * public static void levelOrderDownToTopRecursion(Node root) { if (root.left !=
		 * null) { levelOrderDownToTopRecursion(root.left); } if (root.right != null) {
		 * levelOrderDownToTopRecursion(root.right); }
		 * 
		 * }
		 */
	}
}
