package binary.search;

public class IdenticalBinaryTree {
   public static boolean isEquals(Node root1, Node root2) {
      if (root1 == null && root2 == null) {
         return true;
      } else if (root1 != null && root2 != null) {
         return isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right) && root1.val == root2.val;
      } else {
         return false;
      }
   }
}
