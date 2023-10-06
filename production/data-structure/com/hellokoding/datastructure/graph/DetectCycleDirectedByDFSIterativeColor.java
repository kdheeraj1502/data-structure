package com.hellokoding.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class DetectCycleDirectedByDFSIterativeColor {
   static final int WHITE = 0;
   static final int GRAY = 1;
   static final int BLACK = 2;

   static boolean dfsByIterativeWithColor(GraphDirectedByAdjacencyList g) {
      int[] color = new int[g.getV()];
      Deque<Integer> stack = new ArrayDeque(g.getV());

      for(int i = 0; i < g.getV(); ++i) {
         if (color[i] == 0) {
            stack.push(i);

            while(!stack.isEmpty()) {
               int v = (Integer)stack.peek();
               if (color[v] == 0) {
                  color[v] = 1;
               } else {
                  color[v] = 2;
                  stack.pop();
               }

               Iterator var5 = ((List)g.getAdjacencyList().get(v)).iterator();

               while(var5.hasNext()) {
                  int w = (Integer)var5.next();
                  if (color[w] == 1) {
                     return true;
                  }

                  if (color[w] == 0) {
                     stack.push(w);
                  }
               }
            }
         }
      }

      return false;
   }

   public static void main(String[] args) {
      GraphDirectedByAdjacencyList g1 = new GraphDirectedByAdjacencyList(5);
      g1.addEdge(0, 1);
      g1.addEdge(1, 2);
      g1.addEdge(2, 0);
      g1.addEdge(1, 3);
      g1.addEdge(2, 4);
      System.out.println(dfsByIterativeWithColor(g1));
      GraphDirectedByAdjacencyList g2 = new GraphDirectedByAdjacencyList(4);
      g2.addEdge(0, 1);
      g2.addEdge(2, 0);
      g2.addEdge(2, 1);
      g2.addEdge(3, 2);
      System.out.println(dfsByIterativeWithColor(g2));
   }
}
