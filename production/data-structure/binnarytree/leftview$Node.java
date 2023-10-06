package binnarytree;

class leftview$Node {
   public int data;
   public leftview$Node left;
   public leftview$Node right;

   leftview$Node(int data) {
      this.data = data;
   }

   leftview$Node(int data, leftview$Node left, leftview$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
