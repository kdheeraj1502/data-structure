package binary.search;

class TopView$Pair<K, V> {
   Node node;
   int index;

   TopView$Pair(Node node, int index) {
      this.node = node;
      this.index = index;
   }

   public Node getNode() {
      return this.node;
   }

   public int getIndex() {
      return this.index;
   }
}
