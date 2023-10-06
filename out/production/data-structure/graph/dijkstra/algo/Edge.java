package graph.dijkstra.algo;

public class Edge {
   private double weight;
   private Vertex startVertex;
   private Vertex targetVertex;

   public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
      this.weight = weight;
      this.startVertex = startVertex;
      this.targetVertex = targetVertex;
   }

   public double getWeight() {
      return this.weight;
   }

   public void setWeight(double weight) {
      this.weight = weight;
   }

   public Vertex getStartVertex() {
      return this.startVertex;
   }

   public void setStartVertex(Vertex startVertex) {
      this.startVertex = startVertex;
   }

   public Vertex getTargetVertex() {
      return this.targetVertex;
   }

   public void setTargetVertex(Vertex targetVertex) {
      this.targetVertex = targetVertex;
   }
}
