package binary.search;

public class CeilBST {
   public static int ceilBST(Node root, int val) {
      int ceil = Integer.MIN_VALUE;
      Node curr = root;
      if (root == null) {
         return ceil;
      } else {
         while(curr != null) {
            if (curr.val == val) {
               ceil = curr.val;
               break;
            }

            if (curr.val > val) {
               ceil = curr.val;
               curr = curr.left;
            } else {
               curr = curr.right;
            }
         }

         return ceil;
      }
   }
}
