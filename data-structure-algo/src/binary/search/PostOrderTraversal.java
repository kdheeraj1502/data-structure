package binary.search;

import java.util.Stack;

public class PostOrderTraversal {

	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + ", ");
		}
	}

	public static void postOrderWithoutRecursion(Node root) {
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while (temp != null || !stack.isEmpty()) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				Node temp2 = stack.peek().right;
				if (temp2 == null) {
					temp2 = stack.pop();
					System.out.print(temp2.val + ", ");
					while (!stack.isEmpty() && temp2 == stack.peek().right) {
						temp2 = stack.pop();
						System.out.print(temp2.val + ", ");
					}
				} else {
					temp = temp2;
				}
			}
		}
	}
	
	public static void postOrderWithoutRecursion_self(Node root) {
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while (temp != null || !stack.isEmpty()) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				Node temp2 = stack.peek().right;
				if(temp2 == null) {
					temp2 = stack.pop();
					System.out.print(temp2.val + ", ");
					while(!stack.isEmpty() && temp2 == stack.peek().right) {
						temp2 = stack.pop();
						System.out.print(temp2.val + ", ");
					}
				}
				else {
					temp = temp2;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.right = new Node(8);
		root.left.left.right.left = new Node(9);
		root.left.left.right.right = new Node(10);
		root.left.left.right.right.right = new Node(11);
		postOrderWithoutRecursion(root);
		System.out.println();
		postOrderWithoutRecursion_self(root);
	}
	
}
