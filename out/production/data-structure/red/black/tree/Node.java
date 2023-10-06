package red.black.tree;

public class Node {
   private int val;
   private NodeColor color;
   private Node left;
   private Node right;
   private Node parent;

   public Node(int val) {
      this.val = val;
      this.color = NodeColor.RED;
   }

   public String toString() {
      StringBuilder result = new StringBuilder("Node [ val=" + this.val + ", color=" + this.color + "]");
      if (this.left != null) {
         result.append("\n");
         result.append(" Left val is ");
         result.append(this.left.val);
         result.append("\n");
      }

      if (this.right != null) {
         result.append("\n");
         result.append(" right val is ");
         result.append(this.right.val);
         result.append("\n");
      }

      if (this.left == null) {
         result.append("\n");
         result.append(" Left val is ");
         result.append(" null ");
         result.append("\n");
      }

      if (this.right == null) {
         result.append("\n");
         result.append(" right val is ");
         result.append(" null ");
         result.append("\n");
      }

      return result.toString();
   }

   public int getVal() {
      return this.val;
   }

   public void setVal(int val) {
      this.val = val;
   }

   public NodeColor getColor() {
      return this.color;
   }

   public void setColor(NodeColor color) {
      this.color = color;
   }

   public Node getLeft() {
      return this.left;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public Node getRight() {
      return this.right;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public Node getParent() {
      return this.parent;
   }

   public void setParent(Node parent) {
      this.parent = parent;
   }
}
