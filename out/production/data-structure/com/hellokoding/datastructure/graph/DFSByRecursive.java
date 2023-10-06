package com.hellokoding.datastructure.graph;

import java.util.Iterator;
import java.util.List;

public class DFSByRecursive {
   static void dfs(GraphUndirectedByAdjacencyList g, int v, boolean[] visited) {
      visited[v] = true;
      System.out.printf("%d ", v);
      Iterator var3 = ((List)g.getAdjacencyList().get(v)).iterator();

      while(var3.hasNext()) {
         Integer w = (Integer)var3.next();
         if (!visited[w]) {
            dfs(g, w, visited);
         }
      }

   }

   static void traversal(GraphUndirectedByAdjacencyList g) {
      boolean[] visited = new boolean[g.getV()];

      for(int i = 0; i < g.getV(); ++i) {
         if (!visited[i]) {
            dfs(g, i, visited);
         }
      }

   }

   public static void main(String[] args) {
      GraphUndirectedByAdjacencyList g = new GraphUndirectedByAdjacencyList(5);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(1, 0);
      g.addEdge(1, 3);
      g.addEdge(2, 4);
      traversal(g);
   }
}
