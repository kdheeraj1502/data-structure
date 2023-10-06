package binnarytree;

class RightView$Node {
   public int data;
   public RightView$Node left;
   public RightView$Node right;

   RightView$Node(int data) {
      this.data = data;
   }

   RightView$Node(int data, RightView$Node left, RightView$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
