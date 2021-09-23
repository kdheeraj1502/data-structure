package binary.search;

import java.util.Stack;

public class NumOfLeafNodes {

	public static int numOfLeafNodes(Node root) {
		Stack<Node> stack = new Stack<>();
		int result[] = { 0 };
		numOfLeafNodes(root, stack, result);
		return result[0];
	}

	private static void numOfLeafNodes(Node root, Stack<Node> stack, int result[]) {
		if (root == null)
			return;
		stack.push(root);
		if (root.left == null && root.right == null) {
			result[0]++;
			stack.pop();
			return;
		}
		numOfLeafNodes(root.right, stack, result);
		numOfLeafNodes(root.left, stack, result);
		stack.pop();
	}
	
	public static int numOfLeafNodesWithoutStack(Node root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) {
			return 1;
		}
		return numOfLeafNodesWithoutStack(root.left) + numOfLeafNodesWithoutStack(root.right);
	}
}

