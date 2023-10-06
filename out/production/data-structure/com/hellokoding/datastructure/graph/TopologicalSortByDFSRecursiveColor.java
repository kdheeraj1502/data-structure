package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TopologicalSortByDFSRecursiveColor {
   static final int WHITE = 0;
   static final int GRAY = 1;
   static final int BLACK = 2;
   static boolean hasCycle = false;

   static void topologicalSortByDFSRecursive(GraphDirectedByAdjacencyList g, int v, int[] color, Deque<Integer> stack) {
      if (!hasCycle) {
         color[v] = 1;
         Iterator var4 = ((List)g.getAdjacencyList().get(v)).iterator();

         while(var4.hasNext()) {
            Integer w = (Integer)var4.next();
            if (color[w] == 1) {
               hasCycle = true;
            }

            if (color[w] == 0) {
               topologicalSortByDFSRecursive(g, w, color, stack);
            }
         }

         color[v] = 2;
         stack.push(v);
      }
   }

   static List<Integer> topologicalSort(GraphDirectedByAdjacencyList g) {
      int[] color = new int[g.getV()];
      Deque<Integer> stack = new ArrayDeque();
      hasCycle = false;

      for(int i = 0; i < g.getV(); ++i) {
         if (color[i] == 0) {
            topologicalSortByDFSRecursive(g, i, color, stack);
         }
      }

      return hasCycle ? new ArrayList() : new ArrayList(stack);
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
      printResult(topologicalSort(g1));
      GraphDirectedByAdjacencyList g2 = new GraphDirectedByAdjacencyList(4);
      g2.addEdge(0, 1);
      g2.addEdge(2, 0);
      g2.addEdge(2, 1);
      g2.addEdge(3, 2);
      printResult(topologicalSort(g2));
   }
}
