package binary.search;

public class TrimOutSodeRange {
   public static Node tripOutsideRange(Node root, int min, int max) {
      if (root == null) {
         return null;
      } else {
         root.left = tripOutsideRange(root.left, min, max);
         root.right = tripOutsideRange(root.right, min, max);
         if (root.val < min) {
            return root.right;
         } else {
            return root.val > max ? root.left : root;
         }
      }
   }
}
