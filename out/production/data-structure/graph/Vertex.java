package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex {
   private String name;
   private List<Vertex> adjacencyList;

   public Vertex(String name) {
      this.name = name;
      this.adjacencyList = new ArrayList();
   }

   public void addNeighbor(Vertex vertex) {
      this.adjacencyList.add(vertex);
   }

   public void showNeighbors() {
      Iterator var1 = this.adjacencyList.iterator();

      while(var1.hasNext()) {
         Vertex v = (Vertex)var1.next();
         System.out.println(v);
      }

   }

   public String toString() {
      return "Vertex [name=" + this.name + "]";
   }
}
