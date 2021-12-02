package binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class MnimumDepthBinaryTree {

	public int minDepth_recursion(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int leftD = minDepth_recursion(root.left);
		int rightD = minDepth_recursion(root.right);

		if (root.left == null && root.right != null) {
			return 1 + rightD;
		} else if (root.left != null && root.right == null) {
			return 1 + leftD;
		}

		return 1 + Math.min(rightD, leftD);
	}

	// LEVEL COUNT to find depth min
	public int minDepth_BFS(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
                while(size > 0){
                    TreeNode curr = queue.remove();
                    if(curr.left == null && curr.right == null) return levelCount;
                    if(curr.left != null){
                        queue.add(curr.left);
                    }
                    if(curr.right != null){
                        queue.add(curr.right);
                    }
                    size--;
                }
            levelCount++;
        }
        return levelCount;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);

		root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		MnimumDepthBinaryTree mbt = new MnimumDepthBinaryTree();
		System.out.println(mbt.minDepth_BFS(root));
		System.out.println(mbt.minDepth_recursion(root));

	}
}
