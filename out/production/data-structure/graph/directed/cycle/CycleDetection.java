package graph.directed.cycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CycleDetection {
   public void detectCycle(List<Vertex> graph) {
      Iterator var2 = graph.iterator();

      while(var2.hasNext()) {
         Vertex v = (Vertex)var2.next();
         if (!v.isVisited()) {
            this.dfs(v);
         }
      }

   }

   private void dfs(Vertex vertex) {
      vertex.setBeingVisited(true);
      Iterator var2 = vertex.getNeighbors().iterator();

      while(var2.hasNext()) {
         Vertex v = (Vertex)var2.next();
         if (v.isBeingVisited()) {
            System.out.println("Backward edge .. there is a cycle");
            return;
         }

         if (!v.isVisited()) {
            v.setVisited(true);
            this.dfs(v);
         }
      }

      vertex.setBeingVisited(false);
      vertex.setVisited(true);
   }

   public static void main(String[] args) {
      Vertex v0 = new Vertex("A");
      Vertex v1 = new Vertex("B");
      Vertex v2 = new Vertex("C");
      Vertex v3 = new Vertex("D");
      Vertex v4 = new Vertex("E");
      Vertex v5 = new Vertex("F");
      v5.addNeighbors(v0);
      v0.addNeighbors(v2);
      v0.addNeighbors(v4);
      v4.addNeighbors(v5);
      v2.addNeighbors(v1);
      v2.addNeighbors(v3);
      List<Vertex> graph = new ArrayList();
      graph.add(v4);
      graph.add(v3);
      graph.add(v0);
      graph.add(v5);
      graph.add(v2);
      graph.add(v1);
      CycleDetection cd = new CycleDetection();
      cd.detectCycle(graph);
   }
}
