package graph.kruskalAlgo;

public class Node {
   private int height;
   private int id;
   private Node parent;

   public Node(int rank, int id, Node parent) {
      this.height = rank;
      this.id = id;
      this.parent = parent;
   }

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Node getParent() {
      return this.parent;
   }

   public void setParent(Node parent) {
      this.parent = parent;
   }
}
