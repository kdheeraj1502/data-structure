package binary.search;

public class SumAllNodes {
   public static int sumAllNodes(Node root) {
      return root == null ? 0 : root.val + sumAllNodes(root.left) + sumAllNodes(root.right);
   }
}
