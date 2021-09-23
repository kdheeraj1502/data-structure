package binary.search;

import java.util.Stack;

public class PrintAllPath {

	public static void printAllPath(Node root) {
		Stack<Integer> stack = new Stack<>();
		printAllPathSelf(root, stack);
	}
	
//	--------Level Order Top To Down---------
//	[  1 ]
//	[  2, 3 ]
//	[  4, 5, 6, 7 ]
//	[  8, 9, 10 ]

	private static void printAllPath(Node root, Stack<Integer> stack) {
		if (root == null)
			return;
		stack.push(root.val);
		if (root.left == null && root.right == null) {
			System.out.println(stack);
			stack.pop();
			return;
		}
		printAllPath(root.right, stack);
		printAllPath(root.left, stack);
		stack.pop();
	}
	
	private static void printAllPathSelf(Node root, Stack<Integer> stack) {
		if(root == null) return;
		stack.push(root.val);
		if(root.left == null && root.right == null) {
			System.out.println(stack);
			stack.pop();
			return;
		}
		printAllPathSelf(root.right, stack);
		printAllPathSelf(root.left, stack);
		stack.pop();
	}
}
