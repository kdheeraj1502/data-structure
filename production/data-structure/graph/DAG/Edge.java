package graph.DAG;

public class Edge {
   private Vertex target;
   private int weight;

   public Edge(Vertex target, int weight) {
      this.target = target;
      this.weight = weight;
   }

   public Vertex getTarget() {
      return this.target;
   }

   public int getWeight() {
      return this.weight;
   }
}
