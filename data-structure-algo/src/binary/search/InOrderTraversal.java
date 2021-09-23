package binary.search;

import java.util.Stack;

public class InOrderTraversal {

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + ", ");
			inOrder(root.right);
		}
	}

	public static void inOrderWithOutRecursion(Node root) {
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (temp != null || stack.size() > 0) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			System.out.print(temp.val + ", ");
			temp = temp.right;
		}
	}
}
