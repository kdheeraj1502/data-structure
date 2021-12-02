package binary.search;

import java.util.*;

public class PostOrderNAry {

	static class Node {
		int val;
		List<Node> children;

		Node(int val) {
			this.val = val;
		}

		Node(int val, List<Node> children) {
			this.val = val;
			this.children = children;
		}
	}

	static List<Integer> result = new ArrayList<>();

	public static List<Integer> postorder(Node root) {
		if (root == null)
			return result;
		if (root.children != null) {
			for (Node child : root.children) {
				postorder(child);
			}
		}
		result.add(root.val);
		return result;
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		Node three = new Node(3);
		node.children = Arrays.asList(three, new Node(2), new Node(4));
		three.children = Arrays.asList(new Node(5), new Node(6));
		System.out.println(postorder(node));
	}
}
