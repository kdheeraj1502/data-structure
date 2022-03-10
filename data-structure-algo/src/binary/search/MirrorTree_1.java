package binary.search;

import java.util.*;

public class MirrorTree_1 {

	public static Node getMirror(Node root) {
		if (root == null)
			return null;
		Node mirror = createNode(root.val);
		mirror.left = getMirror(root.right);
		mirror.right = getMirror(root.left);
		return mirror;
	}
	
	public static Node getMirror_same_node(Node root) {
		if (root == null)
			return null;
		Node left = getMirror_same_node(root.left);
		Node right = getMirror_same_node(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	static Node createNode(int val) {
		Node newNode = new Node(val);
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	static List<Integer> levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			result.add(temp.val);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		return result;
	}
	
	static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.val);
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		Node node = new Node(5);
		node.left = new Node(3);
		node.right = new Node(6);
		node.left.left = new Node(2);
		node.left.right = new Node(4);
		Node mirror = getMirror(node);
		List<Integer> result = levelOrder(mirror);
		System.out.println(result);
		System.out.println("------------In order-----------");
		inOrder(mirror);
		Node mirror1 = getMirror_same_node(node);
		System.out.println("------------In order-----------");
		inOrder(mirror1);
	}
}
