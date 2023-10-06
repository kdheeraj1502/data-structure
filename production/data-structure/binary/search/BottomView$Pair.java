package binary.search;

class BottomView$Pair<K, V> {
   Node node;
   int index;

   BottomView$Pair(Node node, int index) {
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
