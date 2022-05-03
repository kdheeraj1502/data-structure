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
	
	static ArrayList<Integer> zigZagTraversalQueue(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return result;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int even = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Node temp = queue.remove();
				result.add(temp.val);
				if (even % 2 == 0) {
					if (temp.left != null) {
						queue.add(temp.left);
					}
					if (temp.right != null) {
						queue.add(temp.right);
					}
				} else {
					if (temp.right != null) {
						queue.add(temp.right);
					}
					if (temp.left != null) {
						queue.add(temp.left);
					}
				}
			}
			even++;
		}
		return result;
	}

	public static void main(String[] args) {
		root = new Node(7);
		root.left = new Node(9);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(8);
		root.right.left = new Node(6);
		root.left.left.left = new Node(10);
		root.left.left.right = new Node(9);
		System.out.println("-----Using Stck--------");
		System.out.println(zigZagTraversal(root));
		System.out.println("-----Using Queue--------");
		System.out.println(zigZagTraversalQueue(root));
	}
}
