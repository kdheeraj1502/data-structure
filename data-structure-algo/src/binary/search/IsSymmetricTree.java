package binary.search;

import java.util.*;

public class IsSymmetricTree {

	public boolean isSymmetricIteration(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> leftQueue = new LinkedList<>();
		Queue<TreeNode> rightQueue = new LinkedList<>();
		leftQueue.add(root.left);
		rightQueue.add(root.right);
		while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			TreeNode nodeLeft = leftQueue.peek();
			TreeNode nodeRight = rightQueue.peek();
			leftQueue.remove();
			rightQueue.remove();
			if (nodeLeft == null && nodeRight == null)
				return true;
			if (nodeLeft == null || nodeRight == null)
				return false;
			if (nodeLeft.val != nodeRight.val)
				return false;

			if (nodeLeft.left != null && nodeRight.right != null) {
				leftQueue.add(nodeLeft.left);
				rightQueue.add(nodeRight.right);
			} else if (nodeLeft.left != null || nodeRight.right != null)
				return false;

			if (nodeLeft.right != null && nodeRight.left != null) {
				leftQueue.add(nodeLeft.right);
				rightQueue.add(nodeRight.left);
			} else if (nodeLeft.right != null || nodeRight.left != null)
				return false;
		}
		return true;

	}

	public boolean isSymmetriRecursion(TreeNode root) {
		return isSymmetriRecursion(root.left, root.right);
	}

	public boolean isSymmetriRecursion(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return (root1.val == root2.val && isSymmetriRecursion(root1.left, root2.right)
				&& isSymmetriRecursion(root1.right, root2.left));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(0);

		/*
		 * root.left = new TreeNode(2); root.right = new TreeNode(2);
		 * 
		 * root.left.left = new TreeNode(3); root.left.right = new TreeNode(4);
		 * 
		 * root.right.left = new TreeNode(4); root.right.right = new TreeNode(3);
		 * 
		 * IsSymmetricTree ist = new IsSymmetricTree();
		 * System.out.println(ist.isSymmetric(root));
		 */

		IsSymmetricTree ist = new IsSymmetricTree();
		System.out.println(ist.isSymmetriRecursion(root));
	}
}
