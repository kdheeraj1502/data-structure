package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathByDijkstraWithMinHeap {
   static final int INFINITE = Integer.MAX_VALUE;
   static final int UNDEFINED = -1;

   static Object[] shortestPathByDijkstra(GraphWeightedByAdjacencyList g, int source) {
      int[] distances = new int[g.getV()];
      int[] predecessors = new int[g.getV()];
      PriorityQueue<GraphWeightedByAdjacencyList.WeightedVertex> minHeap = new PriorityQueue(g.getV(), Comparator.comparingInt(GraphWeightedByAdjacencyList.WeightedVertex::getWeight));

      for(int v = 0; v < g.getV(); ++v) {
         distances[v] = Integer.MAX_VALUE;
         predecessors[v] = -1;
         minHeap.add(new GraphWeightedByAdjacencyList.WeightedVertex(v, distances[v]));
      }

      distances[source] = 0;

      while(!minHeap.isEmpty()) {
         GraphWeightedByAdjacencyList.WeightedVertex u = (GraphWeightedByAdjacencyList.WeightedVertex)minHeap.poll();
         Iterator var6 = ((List)g.getAdjacencyList().get(u.vertex)).iterator();

         while(var6.hasNext()) {
            GraphWeightedByAdjacencyList.WeightedVertex v = (GraphWeightedByAdjacencyList.WeightedVertex)var6.next();
            if (distances[u.vertex] != Integer.MAX_VALUE) {
               int alt = distances[u.vertex] + v.weight;
               if (alt < distances[v.vertex]) {
                  distances[v.vertex] = alt;
                  predecessors[v.vertex] = u.vertex;
               }
            }
         }
      }

      return new Object[]{distances, predecessors};
   }

   static void printResult(Object[] paths) {
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

   public static void main(String[] args) {
      GraphWeightedByAdjacencyList g = new GraphWeightedByAdjacencyList(4);
      g.addEdge(0, 1, 2);
      g.addEdge(2, 0, 1);
      g.addEdge(2, 1, 5);
      g.addEdge(3, 2, 4);
      printResult(shortestPathByDijkstra(g, 3));
      printResult(shortestPathByDijkstra(g, 2));
   }
}
