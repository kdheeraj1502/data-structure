package binary.search;

class BinarySearchTree$Node {
   BinarySearchTree$Node left;
   BinarySearchTree$Node right;
   int val;

   BinarySearchTree$Node(int val) {
      this.val = val;
      this.left = this.right = null;
   }
}
