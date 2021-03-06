package binnarytree.another;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class inorderiteration {
	public class BinaryTree {

		private class Node {
			int data;
			Node left;
			Node right;

			Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;

			}

		}

		private Node root = null;
		private int size = 0;

		BinaryTree() {
			Scanner scn = new Scanner(System.in);
			this.root = input(scn, null, false);

		}

		private Node input(Scanner scn, Node parent, Boolean isleftorright) {
			if (parent == null) {
				System.out.println("Enter data for the parent node");
			} else {

				if (isleftorright) {
					System.out.println("Enter data for the left child of " + parent.data);
				} else {
					System.out.println("Enter data for the right child of " + parent.data);
				}
			}

			int data = scn.nextInt();
			Node node = new Node(data, null, null);
			this.size++;
			System.out.println("does " + node.data + " has left child");
			Boolean choice = false;
			choice = scn.nextBoolean();
			if (choice) {
				node.left = input(scn, node, true);
			}

			choice = false;
			System.out.println("does " + node.data + " has right child");
			choice = scn.nextBoolean();
			if (choice) {
				node.right = input(scn, node, false);
			}

			return node;

		}

		public void display() {
			display(this.root);
		}

		private void display(Node parent) {

			String str = "";
			if (parent.left != null) {
				str += parent.left.data + " => ";
			} else {
				str += "End => ";
			}
			str += parent.data;
			if (parent.right != null) {
				str += " <= " + parent.right.data;
			} else {
				str += " <= End";
			}
			System.out.println(str);
			if (parent.left != null) {
				display(parent.left);
			}
			if (parent.right != null) {
				display(parent.right);
			}

		}

		public void inorder() {
			inorder(this.root);
		}

		private void inorder(Node parent) {
			if (parent == null) {
				return;
			}
			inorder(parent.left);
			System.out.print(parent.data + " ");
			inorder(parent.right);

		}

		public void inorderiterative() {
			inorderiterative(this.root);
		}

		private void inorderiterative(Node parent) {
			ArrayList<Integer> ans = new ArrayList<>();
			Stack<Node> stack = new Stack<>();
			stack.push(parent);
			Node node = parent;
			while (node != null) {
				node = node.left;
				while (node == null) {
					if (!stack.isEmpty()) {
						node = stack.pop();
						ans.add(node.data);
						node = node.right;
					} else {
						break;
					}
				}
				stack.push(node);
			}
			for (int val : ans) {
				System.out.print(val + " ");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
		// false true 73 false false
		inorderiteration m = new inorderiteration();
		BinaryTree tree = m.new BinaryTree();
//		tree.display();
		tree.inorder();
		System.out.println();
		tree.inorderiterative();

	}

}
