package binnarytree;

class MaxWidthBinaryTree$Node {
   public int data;
   public MaxWidthBinaryTree$Node left;
   public MaxWidthBinaryTree$Node right;

   MaxWidthBinaryTree$Node(int data) {
      this.data = data;
   }

   MaxWidthBinaryTree$Node(int data, MaxWidthBinaryTree$Node left, MaxWidthBinaryTree$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }

   public String toString() {
      return "" + this.data + "";
   }
}
