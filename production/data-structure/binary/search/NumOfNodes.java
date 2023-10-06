package binary.search;

public class NumOfNodes {
   public static int numOfNodes(Node root) {
      return root == null ? 0 : 1 + numOfNodes(root.left) + numOfNodes(root.right);
   }
}
