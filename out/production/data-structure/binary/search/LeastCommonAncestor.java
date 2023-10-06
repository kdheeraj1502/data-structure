package binary.search;

public class LeastCommonAncestor {
   public static int leastCommonAncestor(Node root, int first, int second) {
      if (root == null) {
         return Integer.MIN_VALUE;
      } else {
         if (root.val > first && root.val > second) {
            leastCommonAncestor(root.left, first, second);
         }

         if (root.val < first && root.val < second) {
            leastCommonAncestor(root.right, first, second);
         }

         return root.val;
      }
   }
}
