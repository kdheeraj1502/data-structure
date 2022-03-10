import java.util.*;

class Node {
	int val;
	Node left, right;

	public Node(int data) {
		this.val = data;
		left = right = null;
	}
}

public class BinaryTree {
	static Node root;
	static List<Node> nodes;
	static void storeBSTNodes(Node root, List<Node> nodes) {
		if (root == null)
			return;
		storeBSTNodes(root.left, nodes);
		nodes.add(root);
		storeBSTNodes(root.right, nodes);
	}

	static Node buildTreeUtil(List<Node> nodes, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node node = nodes.get(mid);
		node.left = buildTreeUtil(nodes, start, mid - 1);
		node.right = buildTreeUtil(nodes, mid + 1, end);

		return node;
	}
	static Node buildAVLTree(Node root) {
		nodes = new Vector<>();
		storeBSTNodes(root, nodes);
		int n = nodes.size();
		return buildTreeUtil(nodes, 0, n - 1);
	}

	static void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static Node createTree(Node root, int val) {
		if (root == null) {
			root = new Node(val);
		} else if (val < root.val) {
			root.left = createTree(root.left, val);
		} else {
			root.right = createTree(root.right, val);
		}
		return root;
	}
	public static Node createTree(int val) {
		root = createTree(root, val);
		return root;
	}

	public static void main(String[] args) {
		/*
		 * tree.root = new Node(10); tree.root.left = new Node(8); tree.root.left.left =
		 * new Node(7); tree.root.left.left.left = new Node(6);
		 * tree.root.left.left.left.left = new Node(5);
		 */
		
		int nums[] = { 40, 20, 10, 25, 30, 22, 50 };
		for (int num : nums) {
			createTree(num);
		}
		
		System.out.print("Preorder traversal of BST is :");
		preOrder(root);
		System.out.println();
		root = buildAVLTree(root);
		System.out.print("Nodes in vector are :" + "\n");
		for(int i = 0; i < nodes.size(); i++) {
			System.out.print(nodes.get(i).val + ", ");
		}
		System.out.println();
		System.out.print("Preorder traversal of balanced BST is :");
		preOrder(root);
	}
}