package graph.kruskalAlgo;

public class Vertex {
   private String name;
   private Node node;

   public Vertex(String name) {
      this.name = name;
   }

   public Node getNode() {
      return this.node;
   }

   public void setNode(Node node) {
      this.node = node;
   }

   public String toString() {
      return this.name;
   }
}
