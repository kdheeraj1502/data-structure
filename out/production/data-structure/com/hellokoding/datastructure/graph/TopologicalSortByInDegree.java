package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class TopologicalSortByInDegree {
   static List<Integer> topologicalSortByInDegree(GraphDirectedByAdjacencyList g) {
      List<Integer> sorted = new ArrayList();
      int[] inDegree = new int[g.getV()];

      int var10002;
      int w;
      for(int v = 0; v < g.getV(); ++v) {
         for(Iterator var4 = ((List)g.getAdjacencyList().get(v)).iterator(); var4.hasNext(); var10002 = inDegree[w]++) {
            w = (Integer)var4.next();
         }
      }

      Queue<Integer> queue = new ArrayDeque();

      int v;
      for(v = 0; v < g.getV(); ++v) {
         if (inDegree[v] == 0) {
            queue.offer(v);
         }
      }

      while(!queue.isEmpty()) {
         v = (Integer)queue.poll();
         sorted.add(v);
         Iterator var9 = ((List)g.getAdjacencyList().get(v)).iterator();

         while(var9.hasNext()) {
            int w = (Integer)var9.next();
            var10002 = inDegree[w]--;
            if (inDegree[w] == 0) {
               queue.offer(w);
            }
         }
      }

      return sorted.size() == g.getV() ? sorted : new ArrayList();
   }

   static void printResult(List<Integer> sorted) {
      if (sorted.isEmpty()) {
         System.out.println("There are no topological orderings as the input graph is cyclic");
      } else {
         sorted.forEach((x) -> {
            System.out.printf("%d ", x);
         });
         System.out.println();
      }

   }

   public static void main(String[] args) {
      GraphDirectedByAdjacencyList g1 = new GraphDirectedByAdjacencyList(5);
      g1.addEdge(0, 1);
      g1.addEdge(1, 2);
      g1.addEdge(2, 0);
      g1.addEdge(1, 3);
      g1.addEdge(2, 4);
      printResult(topologicalSortByInDegree(g1));
      GraphDirectedByAdjacencyList g2 = new GraphDirectedByAdjacencyList(4);
      g2.addEdge(0, 1);
      g2.addEdge(2, 0);
      g2.addEdge(2, 1);
      g2.addEdge(3, 2);
      printResult(topologicalSortByInDegree(g2));
   }
}
