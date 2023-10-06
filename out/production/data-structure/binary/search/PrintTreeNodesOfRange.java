package binary.search;

public class PrintTreeNodesOfRange {
   public static void print(Node root, int min, int max) {
      if (root != null) {
         print(root.left, min, max);
         if (root.val >= min && root.val <= max) {
            System.out.print(root.val + ", ");
         }

         print(root.right, min, max);
      }

   }
}
