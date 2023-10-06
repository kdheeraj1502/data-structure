package graph.DAG;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
   private String name;
   private List<Edge> adjacencyList;
   private boolean visited;
   private int minDistance;
   private Vertex predecessor;

   public Vertex(String name) {
      this.name = name;
      this.adjacencyList = new ArrayList();
      this.minDistance = Integer.MAX_VALUE;
   }

   public List<Edge> getNeighbors() {
      return this.adjacencyList;
   }

   public void addNeighbors(Edge edge) {
      this.adjacencyList.add(edge);
   }

   public boolean isVisited() {
      return this.visited;
   }

   public void setVisited(boolean visited) {
      this.visited = visited;
   }

   public int getMinDistance() {
      return this.minDistance;
   }

   public void setMinDistance(int minDistance) {
      this.minDistance = minDistance;
   }

   public Vertex getPredecessor() {
      return this.predecessor;
   }

   public void setPredecessor(Vertex predecessor) {
      this.predecessor = predecessor;
   }

   public String toString() {
      return "" + this.name + " - " + this.predecessor;
   }
}
