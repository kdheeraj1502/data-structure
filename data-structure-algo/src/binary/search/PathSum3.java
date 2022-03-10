package binary.search;

import java.util.*;

public class PathSum3 {

	int count = 0;

	public int pathSum(List<List<Integer>> result, TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		List<Integer> sumList = new ArrayList<>();
		getCount(result, sumList, root, targetSum, 0);
		pathSum(result, root.left, targetSum);
		pathSum(result, root.right, targetSum);
		return count;
	}

	public void getCount(List<List<Integer>> result, List<Integer> sumList, TreeNode root, int targetSum, int sum) {
		if (root == null)
			return;
		sum += root.val;
		sumList.add(root.val);
		if (targetSum == sum) {
			result.add(new ArrayList<>(sumList));
			count++;
			return;
		}
		getCount(result, sumList, root.left, targetSum, sum);
		if(root.left != null) {
			sumList.remove(sumList.size() - 1);
		}
		getCount(result, sumList, root.right, targetSum, sum);
		if(root.right != null) {
			sumList.remove(sumList.size() - 1);
		}
	}

	public static void main(String[] args) {

		TreeNode node = new TreeNode(5);

		node.left = new TreeNode(4);
		node.right = new TreeNode(8);
		node.left.left = new TreeNode(11);
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);
		node.right.right.left = new TreeNode(5);

		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);
		node.right.right.right = new TreeNode(1);

		PathSum3 pm = new PathSum3();
		List<List<Integer>> result = new ArrayList<>();
		System.out.println(pm.pathSum(result, node, 22));
		System.out.println(result);
	}
}
