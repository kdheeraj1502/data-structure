package binary.search;

public class IsBalancedBinaryTree {
   public boolean isBalanced_1(TreeNode root) {
      if (root == null) {
         return true;
      } else {
         int left = this.height_1(root.left);
         int right = this.height_1(root.right);
         return Math.abs(left - right) <= 1 && this.isBalanced(root.left) && this.isBalanced(root.right);
      }
   }

   private int height_1(TreeNode root) {
      return root != null ? Math.max(this.height_1(root.left), this.height_1(root.right)) + 1 : 0;
   }

   public boolean isBalanced(TreeNode root) {
      if (root == null) {
         return true;
      } else {
         return this.check(root) != -1;
      }
   }

   public int check(TreeNode root) {
      if (root == null) {
         return 0;
      } else {
         int left = this.check(root.left);
         if (left == -1) {
            return -1;
         } else {
            int right = this.check(root.right);
            if (right == -1) {
               return -1;
            } else if (Math.abs(left - right) > 1) {
               return -1;
            } else {
               int a = Math.max(left, right) + 1;
               return a;
            }
         }
      }
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
      IsBalancedBinaryTree ib = new IsBalancedBinaryTree();
      System.out.println(ib.isBalanced(root));
   }
}
