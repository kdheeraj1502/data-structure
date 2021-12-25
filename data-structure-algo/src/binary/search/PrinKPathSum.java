package binary.search;

import java.util.*;

public class PrinKPathSum {

	static List<List<Integer>> result = new ArrayList<>();

	static void printKPath(Node root, List<Integer> path, int k) {
		if(root == null) {
			return;
		}
		// dont stop adding
		path.add(root.val);
		printKPath(root.left, path, k);
		printKPath(root.right, path, k);
		int sum = 0;
		List<Integer> temp = new ArrayList<>();
		for(int i = path.size() - 1; i >= 0; i--) {
			temp.add(path.get(i));
			sum += path.get(i);
			if(sum == k) {
				result.add(new ArrayList<>(temp));
			}
		}
		
		// After end of recursion remove last element
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);

		int k = 5;
		List<Integer> path = new ArrayList<>();
		printKPath(root, path, k);
		System.out.println(result);
	}
}
