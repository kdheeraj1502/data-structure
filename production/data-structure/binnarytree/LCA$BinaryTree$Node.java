package binnarytree;

class LCA$BinaryTree$Node {
   int data;
   LCA$BinaryTree$Node left;
   LCA$BinaryTree$Node right;
   // $FF: synthetic field
   final LCA.BinaryTree this$1;

   LCA$BinaryTree$Node(LCA.BinaryTree var1, int data, LCA$BinaryTree$Node left, LCA$BinaryTree$Node right) {
      this.this$1 = var1;
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
