package graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
   private String name;
   private boolean visited;
   private List<Vertex> adjacencyList;

   public Vertex(String name) {
      this.name = name;
      this.adjacencyList = new ArrayList();
   }

   public boolean isVisited() {
      return this.visited;
   }

   public void setVisited(boolean visited) {
      this.visited = visited;
   }

   public List<Vertex> getAdjacencyList() {
      return this.adjacencyList;
   }

   public void addNeighbors(Vertex vertex) {
      this.adjacencyList.add(vertex);
   }

   public String toString() {
      return "Vertex [name=" + this.name + "]";
   }
}
