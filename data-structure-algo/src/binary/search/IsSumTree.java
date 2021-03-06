package binary.search;

public class IsSumTree {

	static int isSumTree(Node node) {
		System.out.println("hello");
		int ls, rs;
		if (node == null || (node.left == null && node.right == null)) {
			return 1;
		}

		ls = sum(node.left);
		rs = sum(node.right);
		if ((node.val == ls + rs) && isSumTree(node.left) != 0 && isSumTree(node.right) != 0) {
			return 1;
		}
		return 0;
	}

	static int sum(Node node) {
		if (node == null) {
			return 0;
		}
		int ans = (sum(node.left) + node.val + sum(node.right));
		return ans;
	}

	public static void main(String[] args) {
		Node root = new Node(70);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(10);
		root.left.right = new Node(10);
		System.out.println(isSumTree(root));
	}
}
