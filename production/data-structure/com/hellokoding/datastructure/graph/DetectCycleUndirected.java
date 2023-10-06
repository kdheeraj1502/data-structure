package com.hellokoding.datastructure.graph;

import java.util.Iterator;
import java.util.List;

public class DetectCycleUndirected extends GraphUndirectedByAdjacencyList {
   public DetectCycleUndirected(int V) {
      super(V);
   }

   private boolean dfs(int v, boolean[] visited, int parent) {
      visited[v] = true;
      List<Integer> children = (List)this.getAdjacencyList().get(v);
      Iterator var5 = children.iterator();

      do {
         if (!var5.hasNext()) {
            return false;
         }

         Integer c = (Integer)var5.next();
         if (!visited[c] && this.dfs(c, visited, v)) {
            return true;
         }
      } while(v == parent);

      return true;
   }

   public boolean hasCycle() {
      boolean[] visited = new boolean[this.getV()];

      for(int i = 0; i < this.getV(); ++i) {
         if (!visited[i] && this.dfs(i, visited, -1)) {
            return true;
         }
      }

      return false;
   }

   public static void main(String[] args) {
      DetectCycleUndirected graph = new DetectCycleUndirected(3);
      graph.addEdge(0, 1);
      graph.addEdge(1, 2);
      graph.addEdge(2, 0);
      System.out.println(graph.hasCycle());
   }
}
