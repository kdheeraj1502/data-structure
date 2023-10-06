package binnarytree;

class TopView_self$Node {
   public int data;
   public TopView_self$Node left;
   public TopView_self$Node right;

   TopView_self$Node(int data) {
      this.data = data;
   }

   TopView_self$Node(int data, TopView_self$Node left, TopView_self$Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
