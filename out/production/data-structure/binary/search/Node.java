package binary.search;

public class Node {
   public int val;
   public Node left;
   public Node right;

   public int getVal() {
      return this.val;
   }

   public String toString() {
      return "[ val :" + this.val + ", left :" + (this.left != null ? this.left.val + " " : "_") + ", right : " + (this.right != null ? this.right.val + " " : "_") + "] ";
   }

   public Node(int val) {
      this.val = val;
      this.left = this.right = null;
   }

   public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
   }
}
