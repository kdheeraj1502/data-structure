package binary.search;

class Pair<K, V> {
   Node node;
   Integer index;

   Pair(Node root, Integer index) {
      this.index = index;
      this.node = root;
   }

   public Node getNode() {
      return this.node;
   }

   public Integer getIndex() {
      return this.index;
   }
}
