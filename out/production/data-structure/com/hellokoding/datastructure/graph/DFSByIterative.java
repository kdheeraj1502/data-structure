package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class DFSByIterative {
   static void dfsByIterative(GraphUndirectedByAdjacencyList g, int v) {
      boolean[] visited = new boolean[g.getV()];
      Deque<Integer> stack = new ArrayDeque();
      stack.push(v);

      while(true) {
         do {
            if (stack.isEmpty()) {
               return;
            }

            v = (Integer)stack.pop();
         } while(visited[v]);

         visited[v] = true;
         System.out.printf("%d ", v);
         Iterator var4 = ((List)g.getAdjacencyList().get(v)).iterator();

         while(var4.hasNext()) {
            Integer w = (Integer)var4.next();
            stack.push(w);
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
      dfsByIterative(g, 0);
   }
}
