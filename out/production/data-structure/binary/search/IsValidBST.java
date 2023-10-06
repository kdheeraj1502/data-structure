package binary.search;

public class IsValidBST {
   public static boolean isValidBST(TreeNode root) {
      return isValidBST(root, (Integer)null, (Integer)null);
   }

   static boolean isValidBST(TreeNode root, Integer min, Integer max) {
      if (root == null) {
         return true;
      } else if (min != null && root.val <= min || max != null && root.val >= max) {
         System.out.println("min is " + min + " root val is " + root.val);
         System.out.println("max is " + max + " root val is " + root.val);
         return false;
      } else {
         return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
      }
   }

   public static void main(String[] args) {
      TreeNode node = new TreeNode(10);
      node.left = new TreeNode(6);
      node.right = new TreeNode(16);
      node.left.left = new TreeNode(2);
      node.left.right = new TreeNode(9);
      node.right.left = new TreeNode(12);
      node.right.right = new TreeNode(20);
      System.out.println(isValidBST(node));
   }
}
