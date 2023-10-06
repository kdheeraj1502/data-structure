package binary.search;

public class NumberOfFullNodes {
   public static int numOfFullNodes(Node root) {
      if (root == null) {
         return 0;
      } else {
         int count = numOfFullNodes(root.left) + numOfFullNodes(root.right);
         if (root.left != null && root.right != null) {
            ++count;
         }

         return count;
      }
   }
}
