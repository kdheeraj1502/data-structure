package binary.search;

import java.util.*;

public class MaxSumOfNodesNotAdjacent {

	static Map<Node, Integer> map = new HashMap<>();

	static public int maxSum(Node root) {
		if (root == null)
			return 0;
		if (map.containsKey(root)) {
			return map.get(root);
		}
		int include = root.val;

		if (root.left != null) {
			include += maxSum(root.left.left) + maxSum(root.left.right);
		}
		if (root.right != null) {
			include += maxSum(root.right.left) + maxSum(root.right.right);
		}
		int a = maxSum(root.left);
		int b= maxSum(root.right);
		int exclude = a + b;
		map.put(root, Math.max(include, exclude));
		return map.get(root);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.left.left = new Node(1);
		System.out.print(maxSum(root));
		System.out.println(map);
	}
}
