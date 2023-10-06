package binary.search;

class StringBinaryTree$Node {
   public int data;
   public StringBinaryTree$Node left;
   public StringBinaryTree$Node right;

   StringBinaryTree$Node(int data) {
      this.data = data;
   }

   StringBinaryTree$Node(int data, StringBinaryTree$Node left, StringBinaryTree$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }

   public String toString() {
      return "Node [data=" + this.data + ", left=" + this.left + ", right=" + this.right + "]";
   }
}
