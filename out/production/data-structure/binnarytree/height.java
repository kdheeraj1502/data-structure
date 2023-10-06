package binnarytree;

public class height {
   public int height(Node root) {
      if (root == null) {
         return -1;
      } else {
         int left = this.height(root.left);
         int right = this.height(root.right);
         return Math.max(left, right) + 1;
      }
   }

   public static void main(String[] args) {
   }
}
