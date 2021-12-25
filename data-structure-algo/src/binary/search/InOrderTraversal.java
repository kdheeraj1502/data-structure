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

	public static void inOrder_self(Node root) {
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.val + ", ");
				temp = temp.right;
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(11);

		root.left = new Node(27);
		root.right = new Node(30);

		root.left.left = new Node(19);
		root.left.right = new Node(15);

		root.right.left = new Node(14);
		root.right.right = new Node(23);
		inOrder_self(root);
	}
}
