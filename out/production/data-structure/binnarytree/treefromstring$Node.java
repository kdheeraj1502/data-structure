package binnarytree;

class treefromstring$Node {
   public int data;
   public treefromstring$Node left;
   public treefromstring$Node right;

   treefromstring$Node(int data) {
      this.data = data;
   }

   treefromstring$Node(int data, treefromstring$Node left, treefromstring$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
