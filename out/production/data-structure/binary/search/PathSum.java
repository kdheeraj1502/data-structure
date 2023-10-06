package binary.search;

public class PathSum {
   static int recursionCount = 1;

   public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
         ++recursionCount;
         return false;
      } else if (targetSum == root.val && root.left == null && root.right == null) {
         System.out.println("Node : " + root.val + ", recursionCount : " + recursionCount++ + " targetSum : " + targetSum);
         return true;
      } else {
         System.out.println("Node : " + root.val + ", recursionCount : " + recursionCount++ + " targetSum : " + targetSum);
         return this.hasPathSum(root.left, targetSum - root.val) || this.hasPathSum(root.right, targetSum - root.val);
      }
   }

   public static void main(String[] args) {
      TreeNode node = new TreeNode(5);
      node.left = new TreeNode(4);
      node.right = new TreeNode(8);
      node.left.left = new TreeNode(11);
      node.right.left = new TreeNode(13);
      node.right.right = new TreeNode(4);
      node.left.left.left = new TreeNode(7);
      node.left.left.right = new TreeNode(2);
      node.right.right.right = new TreeNode(1);
      PathSum pm = new PathSum();
      System.out.println(pm.hasPathSum(node, 18));
   }
}
