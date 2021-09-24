package binary.search;

import java.util.Stack;

public class PreOrderTraversal {

	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.val + ", ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void preOrderIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		Node temp;
		stack.push(root);
		while (stack.size() > 0) {
			temp = stack.pop();
			System.out.print(temp.val + ", ");
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
	}
}
