package binary.search;

public class PreOrderTraversal {

	public static void preOrder(Node root) {
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
}
