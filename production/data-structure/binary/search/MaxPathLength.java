package binary.search;

public class MaxPathLength {
   public static int maxPathLength(Node root) {
      if (root == null) {
         return 0;
      } else {
         int leftDepth = TreeDepth.treeDepth(root.left);
         int rightDepth = TreeDepth.treeDepth(root.right);
         int max = leftDepth + rightDepth + 1;
         int leftPath = maxPathLength(root.left);
         int rightPath = maxPathLength(root.right);
         if (max < leftPath) {
            max = leftPath;
         }

         if (max < rightPath) {
            max = rightPath;
         }

         return max;
      }
   }

   public static int maxPathLength_self(Node root) {
      if (root == null) {
         return 0;
      } else {
         int leftDepth = TreeDepth.treeDepth(root.left);
         int rightDepth = TreeDepth.treeDepth(root.right);
         int max = leftDepth + rightDepth + 1;
         int leftPath = maxPathLength_self(root.left);
         int rightPath = maxPathLength_self(root.right);
         max = Math.max(leftPath, max);
         max = Math.max(rightPath, max);
         return max;
      }
   }
}
