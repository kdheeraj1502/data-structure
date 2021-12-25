package binary.search;

import java.util.*;

public class StringBinaryTree {

	static Node root;

	static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
	}

	static public int findIndex(String str, int start, int end) {
		if (start > end)
			return -1;
		Stack<Character> stack = new Stack<>();
		for (int i = start; i <= end; i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				if (stack.peek() == '(') {
					stack.pop();
				}
				if (stack.isEmpty()) {
					return i;
				}
			}
		}
		return -1;
	}

	static public Node stringToTree(String str, int start, int end) {
		if(start > end) {
			return null;
		}
		Node root = new Node(str.charAt(start) - '0');
		int index = -1;
		if(str.charAt(start + 1) == '(' && start + 1 <= end) {
			index = findIndex(str, start + 1, end);
		}
		if(index != -1) {
			root.left = stringToTree(str, start + 2, index - 1);
			root.right = stringToTree(str, index + 2, end - 1);
		}
		return root;
	}

	public static void main(String[] args) {
		String str = "4(2(3)(1))(6(5))";
		System.out.println(stringToTree(str, 0, str.length() - 1));
	}
}
