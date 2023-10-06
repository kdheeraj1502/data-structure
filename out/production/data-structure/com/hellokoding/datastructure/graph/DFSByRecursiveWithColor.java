package com.hellokoding.datastructure.graph;

import java.util.Iterator;
import java.util.List;

public class DFSByRecursiveWithColor {
   static final int WHITE = 0;
   static final int GRAY = 1;
   static final int BLACK = 2;

   static void dfsByRecursiveWithColor(GraphUndirectedByAdjacencyList g, int v, int[] color) {
      color[v] = 1;
      System.out.printf("%d ", v);
      Iterator var3 = ((List)g.getAdjacencyList().get(v)).iterator();

      while(var3.hasNext()) {
         Integer w = (Integer)var3.next();
         if (color[w] == 0) {
            dfsByRecursiveWithColor(g, w, color);
         }
      }

      color[v] = 2;
   }

   static void traversal(GraphUndirectedByAdjacencyList g) {
      int[] color = new int[g.getV()];

      for(int i = 0; i < g.getV(); ++i) {
         if (color[i] == 0) {
            dfsByRecursiveWithColor(g, i, color);
         }
      }

   }

   public static void main(String[] args) {
      GraphUndirectedByAdjacencyList g = new GraphUndirectedByAdjacencyList(5);
      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(1, 3);
      g.addEdge(2, 4);
      traversal(g);
   }
}
