package graph.kruskalAlgo;

public class Edge implements Comparable<Edge> {
   private double weight;
   private Vertex startVertex;
   private Vertex targetVertex;

   public Edge(Vertex startVertex, Vertex targetVertex, double weight) {
      this.weight = weight;
      this.startVertex = startVertex;
      this.targetVertex = targetVertex;
   }

   public double getWeight() {
      return this.weight;
   }

   public Vertex getStartVertex() {
      return this.startVertex;
   }

   public Vertex getTargetVertex() {
      return this.targetVertex;
   }

   public int compareTo(Edge otherEdge) {
      return Double.compare(this.weight, otherEdge.getWeight());
   }
}
