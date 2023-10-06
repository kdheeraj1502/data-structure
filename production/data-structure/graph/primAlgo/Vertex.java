package graph.primAlgo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
   private String name;
   private boolean visited;
   private Vertex previousVertex;
   private List<Edge> adjacencies;

   public Vertex(String name) {
      this.name = name;
      this.adjacencies = new ArrayList();
   }

   public Vertex getPreviousVertex() {
      return this.previousVertex;
   }

   public void addEdge(Edge edge) {
      this.adjacencies.add(edge);
   }

   public List<Edge> getAdjacencies() {
      return this.adjacencies;
   }

   public void setPreviousVertex(Vertex previousVertex) {
      this.previousVertex = previousVertex;
   }

   public boolean isVisited() {
      return this.visited;
   }

   public void setVisited(boolean visited) {
      this.visited = visited;
   }

   public String toString() {
      return "" + this.name;
   }
}
