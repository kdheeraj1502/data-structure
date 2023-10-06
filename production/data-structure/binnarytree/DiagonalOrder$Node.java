package binnarytree;

class DiagonalOrder$Node {
   public int data;
   public DiagonalOrder$Node left;
   public DiagonalOrder$Node right;

   DiagonalOrder$Node(int data) {
      this.data = data;
   }

   DiagonalOrder$Node(int data, DiagonalOrder$Node left, DiagonalOrder$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
