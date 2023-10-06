package binary.search;

class BoundaryTraversal$Node {
   public int data;
   public BoundaryTraversal$Node left;
   public BoundaryTraversal$Node right;

   BoundaryTraversal$Node(int data) {
      this.data = data;
   }

   BoundaryTraversal$Node(int data, BoundaryTraversal$Node left, BoundaryTraversal$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
