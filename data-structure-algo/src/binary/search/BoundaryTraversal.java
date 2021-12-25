package binary.search;

import java.util.*;

public class BoundaryTraversal {

	static Node root;

	static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static void printLeaves(Node node, ArrayList<Integer> result) {
		if (node == null)
			return;

		printLeaves(node.left, result);
		if (node.left == null && node.right == null)
			result.add(node.data);
		printLeaves(node.right, result);
	}

	static void printBoundaryLeft(Node node, ArrayList<Integer> result) {
		if (node == null)
			return;

		if (node.left != null) {
			result.add(node.data);
			printBoundaryLeft(node.left, result);
		} else if (node.right != null) {
			result.add(node.data);
			printBoundaryLeft(node.right, result);
		}
	}

	static void printBoundaryRight(Node node, ArrayList<Integer> result) {
		if (node == null)
			return;

		if (node.right != null) {
			printBoundaryRight(node.right, result);
			result.add(node.data);
		} else if (node.left != null) {
			printBoundaryRight(node.left, result);
			result.add(node.data);
		}
	}

	static ArrayList<Integer> boundary(Node node) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (node == null)
			return result;

		result.add(node.data);

		printBoundaryLeft(node.left, result);
		printLeaves(node.left, result);
		printLeaves(node.right, result);

		printBoundaryRight(node.right, result);
		return result;
	}

//4 10 N 5 5 N 6 7 N 8 8 N 8 11 N 3 4 N 1 3 N 8 6 N 11 11 N 5 8
	public static void main(String[] args) {

		root = new Node(4);

		root.left = new Node(10);

		root.left.left = new Node(5);
		root.left.right = new Node(5);

		root.left.left.right = new Node(6);
		root.left.right.left = new Node(7);

		root.left.left.right.left = new Node(8);
		root.left.left.right.right = new Node(8);
		root.left.right.left.right = new Node(8);

		root.left.left.right.left.left = new Node(11);
		root.left.left.right.right.left = new Node(3);
		root.left.left.right.right.right = new Node(4);
		root.left.right.left.right.right = new Node(1);

		root.left.left.right.left.left.left = new Node(3);
		root.left.left.right.right.left.left = new Node(8);
		root.left.left.right.right.left.right = new Node(6);
		root.left.left.right.right.right.right = new Node(11);
		root.left.right.left.right.right.left = new Node(11);

		root.left.left.right.left.left.left.left = new Node(5);
		root.left.left.right.left.left.left.right = new Node(8);

		System.out.println(boundary(root));
	}
}
