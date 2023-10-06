package binary.search;

public class PathSum3 {
   int count = 0;

   public int pathSum(TreeNode root, int targetSum) {
      if (root == null) {
         return 0;
      } else {
         this.getCount(root, targetSum, 0);
         this.pathSum(root.left, targetSum);
         this.pathSum(root.right, targetSum);
         return this.count;
      }
   }

   public void getCount(TreeNode root, int targetSum, int sum) {
      if (root != null) {
         sum += root.val;
         if (targetSum == sum) {
            ++this.count;
         }

         this.getCount(root.left, targetSum, sum);
         this.getCount(root.right, targetSum, sum);
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
      System.out.println(pm.pathSum(node, 22));
   }
}
