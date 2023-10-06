package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BFSByIterative {
   public static void bfsByIterative(GraphUndirectedByAdjacencyList g, int v) {
      boolean[] visited = new boolean[g.getV()];
      Deque<Integer> queue = new ArrayDeque();
      queue.offer(v);

      while(true) {
         do {
            if (queue.isEmpty()) {
               return;
            }

            v = (Integer)queue.poll();
         } while(visited[v]);

         visited[v] = true;
         System.out.printf("%d ", v);
         Iterator var4 = ((List)g.getAdjacencyList().get(v)).iterator();

         while(var4.hasNext()) {
            Integer w = (Integer)var4.next();
            queue.offer(w);
         }
      }
   }

   public static void main(String[] args) {
      GraphUndirectedByAdjacencyList g = new GraphUndirectedByAdjacencyList(5);
      g.addEdge(0, 1);
      g.addEdge(1, 2);
      g.addEdge(2, 0);
      g.addEdge(1, 3);
      g.addEdge(2, 4);
      bfsByIterative(g, 0);
   }
}
