package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class ShortestPathByBellmanFord {
   static final int INFINITE = Integer.MAX_VALUE;
   static final int UNDEFINED = -1;

   static Object[] shortestPathByBellmanFord(GraphWeightedByAdjacencyList g, int source) {
      int[] distances = new int[g.getV()];
      int[] predecessors = new int[g.getV()];

      int u;
      for(u = 0; u < g.getV(); ++u) {
         distances[u] = Integer.MAX_VALUE;
         predecessors[u] = -1;
      }

      distances[source] = 0;

      for(u = 1; u < g.getV(); ++u) {
         for(int u = 0; u < g.getV(); ++u) {
            Iterator var6 = ((List)g.getAdjacencyList().get(u)).iterator();

            while(var6.hasNext()) {
               GraphWeightedByAdjacencyList.WeightedVertex v = (GraphWeightedByAdjacencyList.WeightedVertex)var6.next();
               if (distances[u] != Integer.MAX_VALUE) {
                  int alt = distances[u] + v.weight;
                  if (alt < distances[v.vertex]) {
                     distances[v.vertex] = alt;
                     predecessors[v.vertex] = u;
                  }
               }
            }
         }
      }

      for(u = 0; u < g.getV(); ++u) {
         Iterator var9 = ((List)g.getAdjacencyList().get(u)).iterator();

         while(var9.hasNext()) {
            GraphWeightedByAdjacencyList.WeightedVertex v = (GraphWeightedByAdjacencyList.WeightedVertex)var9.next();
            if (distances[u] != Integer.MAX_VALUE) {
               int alt = distances[u] + v.weight;
               if (alt < distances[v.vertex]) {
                  System.out.println("The input graph contains a negative-weight cycle");
                  return new Object[0];
               }
            }
         }
      }

      return new Object[]{distances, predecessors};
   }

   static void printResult(Object[] paths) {
      if (paths.length != 0) {
         int[] distances = (int[])((int[])paths[0]);
         int[] predecessors = (int[])((int[])paths[1]);
         System.out.println("Vertex\tDistance from source\tRoute from source");

         for(int v = 0; v < distances.length; ++v) {
            if (distances[v] == Integer.MAX_VALUE) {
               System.out.printf("%-8s%-24s%s%s", v, "N/A", "N/A", System.lineSeparator());
            } else {
               Deque<Integer> route = new ArrayDeque();
               route.push(v);

               for(int u = predecessors[v]; u >= 0; u = predecessors[u]) {
                  route.push(u);
               }

               System.out.printf("%-8d%-24d%s%s", v, distances[v], route.toString(), System.lineSeparator());
            }
         }

      }
   }

   public static void main(String[] args) {
      GraphWeightedByAdjacencyList g1 = new GraphWeightedByAdjacencyList(4);
      g1.addEdge(0, 1, -2);
      g1.addEdge(2, 0, 1);
      g1.addEdge(2, 1, 3);
      g1.addEdge(3, 2, 4);
      printResult(shortestPathByBellmanFord(g1, 3));
      GraphWeightedByAdjacencyList g2 = new GraphWeightedByAdjacencyList(4);
      g2.addEdge(0, 1, -5);
      g2.addEdge(2, 0, 1);
      g2.addEdge(1, 2, 3);
      g2.addEdge(3, 2, 4);
      printResult(shortestPathByBellmanFord(g2, 3));
   }
}
