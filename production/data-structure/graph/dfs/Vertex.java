package graph.dfs;

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

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public boolean isVisited() {
      return this.visited;
   }

   public void setVisited(boolean visited) {
      this.visited = visited;
   }

   public List<Vertex> getNeighbors() {
      return this.adjacencyList;
   }

   public void addNeighbor(Vertex vertex) {
      this.adjacencyList.add(vertex);
   }

   public String toString() {
      return "Vertex [name=" + this.name + "]";
   }
}
