package binnarytree;

class MaxWidthBinaryTree$Pair<K, V> {
   int index;
   MaxWidthBinaryTree.Node node;

   MaxWidthBinaryTree$Pair(MaxWidthBinaryTree.Node node, int index) {
      this.index = index;
      this.node = node;
   }

   public int getValue() {
      return this.index;
   }

   public MaxWidthBinaryTree.Node getKey() {
      return this.node;
   }
}
