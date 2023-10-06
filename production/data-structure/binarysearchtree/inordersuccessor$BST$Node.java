package binarysearchtree;

class inordersuccessor$BST$Node {
   int data;
   inordersuccessor$BST$Node left;
   inordersuccessor$BST$Node right;
   inordersuccessor$BST$Node next;
   // $FF: synthetic field
   final inordersuccessor.BST this$0;

   inordersuccessor$BST$Node(inordersuccessor.BST var1, int data, inordersuccessor$BST$Node left, inordersuccessor$BST$Node right) {
      this.this$0 = var1;
      this.data = data;
      this.left = left;
      this.right = right;
   }
}
