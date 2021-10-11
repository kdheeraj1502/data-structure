package binary.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringTree {

	private Node root;

	private class Node {
		private String value;
		private int count;
		private Node left;
		private Node right;

		private Node() {
		}

		private Node(String value) {
			this.value = value;
			this.count = 0;
			this.left = this.right = null;
		}
	}

	public static void print(Node curr) {
		if (curr != null) {
			System.out.print("[ Value : " + curr.value);
			System.out.println(", Count : " + curr.count + " ]");
			print(curr.left);
			print(curr.right);
		}
	}

	public void add(String value) {
		this.root = add(value, this.root);
	}

	private Node add(String value, Node curr) {
		int compare;
		if (curr == null) {
			curr = new Node(value);
			curr.count = 1;
			curr.left = curr.right = null;
		} else {
			compare = curr.value.compareTo(value);
			if (compare == 0)
				curr.count++;
			else if (compare == 1)
				curr.left = add(value, curr.left);
			else
				curr.right = add(value, curr.right);
		}
		return curr;
	}

	public boolean find(String value) {
		return find(this.root, value);
	}

	private boolean find(Node curr, String value) {
		int compare;
		if (curr == null)
			return false;
		compare = curr.value.compareTo(value);
		if (compare == 0)
			return true;
		else {
			if (compare == 1)
				return find(curr.left, value);
			else
				return find(curr.right, value);
		}
	}

	public int frequencey(String value) {
		return frequencey(this.root, value);
	}

	private int frequencey(Node curr, String value) {
		int compare;
		if (curr == null)
			return 0;
		compare = curr.value.compareTo(value);
		if (compare == 0)
			return curr.count;
		else {
			if (compare > 1)
				return frequencey(curr.left, value);
			else
				return frequencey(curr.right, value);
		}
	}

	public void freeTree() {
		this.root = null;
	}

	public void levelOrder(Node curr) {
		Queue<Node> queue = new ArrayDeque<>();
		Node temp = null;
		if (curr != null)
			queue.add(curr);
		while (!queue.isEmpty()) {
			if (!queue.isEmpty())
				temp = queue.remove();
			System.out.println(temp.value);
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
	}

	public static void main(String[] args) {
		StringTree st = new StringTree();
		st.add("Parth");
		st.add("Ayansh");
		st.add("Ryan");
		st.add("Samar");
		st.add("Pranav");
		st.add("Aditya");
		st.add("Daksh");

		st.print(st.root);
		
		st.levelOrder(st.root);
	}
}
