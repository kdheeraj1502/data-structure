package binary.search;

public class DiameterOfBinaryTree {
   static int max;

   static int diameter(Node root) {
      max = Integer.MIN_VALUE;
      dia(root);
      return max;
   }

   static int dia(Node root) {
      if (root == null) {
         return 0;
      } else {
         int left = dia(root.left);
         int right = dia(root.right);
         max = Math.max(max, left + right + 1);
         return Math.max(left, right) + 1;
      }
   }

   public static void main(String[] args) {
      Node root = new Node(10);
      root.left = new Node(20);
      root.right = new Node(30);
      root.left.left = new Node(40);
      root.left.right = new Node(60);
      System.out.println(diameter(root));
   }
}
