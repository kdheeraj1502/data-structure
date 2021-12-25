package binary.search;

import java.util.*;

public class ZigZagTraversal {
	
	static Node root;

	static ArrayList<Integer> zigZagTraversal(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return result;
		}
		Stack<Node> p = new Stack<>();
		Stack<Node> c = new Stack<>();
		p.push(root);
		int even = 0;
		while (!p.isEmpty()) {
			int size = p.size();
			while (size-- > 0) {
				Node temp = p.pop();
				result.add(temp.val);
				if (even % 2 == 0) {
					if (temp.left != null) {
						c.push(temp.left);
					}
					if (temp.right != null) {
						c.push(temp.right);
					}
				} else {
					if (temp.right != null) {
						c.push(temp.right);
					}
					if (temp.left != null) {
						c.push(temp.left);
					}
				}
			}
			even++;
			p = c;
			c = new Stack<>();
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
		System.out.println(zigZagTraversal(root));
	}
}
