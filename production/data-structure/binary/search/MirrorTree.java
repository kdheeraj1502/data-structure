package binary.search;

public class MirrorTree {
   void mirror(Node node) {
      this.convert(node);
   }

   Node convert(Node node) {
      if (node == null) {
         return null;
      } else {
         Node left = this.convert(node.left);
         Node right = this.convert(node.right);
         node.left = right;
         node.right = left;
         return node;
      }
   }

   public static void main(String[] args) {
   }
}
