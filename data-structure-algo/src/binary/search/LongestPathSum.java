package binary.search;

import java.util.*;
import java.util.Map.Entry;

import binary.search.BoundaryTraversal.Node;

public class LongestPathSum {

	public static int sumOfLongRootToLeafPath(TreeNode root) {
		Queue<SumLevel> queue = new LinkedList<>();
		queue.add(new SumLevel(root, root.val, 1));
		int level = 0;
		int max = Integer.MIN_VALUE;
		Map<Integer, List<Integer>> result = new HashMap<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while (size-- > 0) {
				SumLevel temp = queue.remove();
				result.put(level, result.getOrDefault(level, new ArrayList<>()));
				result.get(level).add(temp.sum);
				if (temp.node.left != null) {
					int sum = temp.sum + temp.node.left.val;
					queue.add(new SumLevel(temp.node.left, sum, level));
				}
				if (temp.node.right != null) {
					int sum = temp.sum + temp.node.right.val;
					queue.add(new SumLevel(temp.node.right, sum, level));
				}
			}
		}//{1=[1], 2=[3, 4], 3=[7, 8, 10, 11]}

		int large = Integer.MIN_VALUE;
		for (Map.Entry<Integer, List<Integer>> map : result.entrySet()) {
			if (map.getKey() > large) {
				large = map.getKey();
			}
		}
		List<Integer> largest = result.get(large);
		for (int in : largest) {
			if (max < in) {
				max = in;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(sumOfLongRootToLeafPath(root));
	}
}

class SumLevel {
	int sum;
	int level;
	TreeNode node;

	SumLevel(TreeNode node, int sum, int level) {
		this.node = node;
		this.sum = sum;
		this.level = level;
	}

	@Override
	public String toString() {
		return "[sum = " + sum + ", level = " + level + ", node val = " + node.val + "]";
	}

}