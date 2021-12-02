package backtracking;

import java.util.*;

import binary.search.LevelOrderTraversal;
import binary.search.Node;

public class UniqueBinarySearchTree2 {

	public static List<Node> generateTrees(int n, int nums[]) {
		if (n == 0)
			return new ArrayList<>();
		return dfs(0, n - 1, nums);
	}

	public static List<Node> dfs(int start, int end, int nums[]) {
		List<Node> res = new ArrayList<>();
		if (start > end) {
			res.add(null);
			return res;
		}
		// i is start value of the node , which is the smallest value
		// end is the value n which was input value or the maximum value
		
		// i is root
		for (int i = start; i <= end; i++) {
			
			// FIRST HALF OR STARTING FIRST PART 
			List<Node> l = dfs(start, i - 1, nums);
			// SECOND HALF OR LAST ENDING PART 
			List<Node> r = dfs(i + 1, end, nums);

			for (Node ln : l) {
				for (Node rn : r) {
					// CEATING root
					Node root = new Node(nums[i]);
					root.left = ln;
					root.right = rn;
					res.add(root);
				}
			}

		}

		return res;
	}

	public static void main(String[] args) {
		int nums[] = { 10, 20, 30};
		List<Node> nodeList = generateTrees(3, nums);
		for(int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);
			if(node != null) {
				LevelOrderTraversal.levelOrder(node);
			}
		}
	}
}
