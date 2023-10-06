package binary.search;

public class TrasformToSumTree {
   public static void toSumTree(Node root) {
      toSum(root);
   }

   private static int toSum(Node parent) {
      if (parent == null) {
         return 0;
      } else {
         int old = parent.val;
         parent.val = toSum(parent.left) + toSum(parent.right);
         return parent.val + old;
      }
   }

   public static void main(String[] args) {
      Node root = new Node(10);
      root.left = new Node(-2);
      root.right = new Node(6);
      root.left.left = new Node(8);
      root.left.right = new Node(-4);
      root.left.right.left = new Node(-3);
      root.right.left = new Node(7);
      root.right.right = new Node(5);
      System.out.println("---------before-------");
      InOrderTraversal.inOrder(root);
      toSumTree(root);
      System.out.println("-------After----------");
      InOrderTraversal.inOrder(root);
   }
}
