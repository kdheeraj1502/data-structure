package com.hellokoding.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUndirectedByAdjacencyList {
   private int V;
   private List<List<Integer>> adjacencyList;

   public GraphUndirectedByAdjacencyList(int V) {
      this.V = V;
      this.adjacencyList = new ArrayList(V);

      for(int i = 0; i < V; ++i) {
         this.adjacencyList.add(new ArrayList());
      }

   }

   public Integer getV() {
      return this.V;
   }

   public List<List<Integer>> getAdjacencyList() {
      return this.adjacencyList;
   }

   public void addEdge(int source, int dest) {
      ((List)this.adjacencyList.get(source)).add(dest);
      ((List)this.adjacencyList.get(dest)).add(source);
   }

   public void printAdjacencyList() {
      for(int i = 0; i < this.V; ++i) {
         System.out.printf("Adjacency list of vertex %d is %s %s", i, this.adjacencyList.get(i), System.lineSeparator());
      }

   }

   public static void main(String[] args) {
      GraphUndirectedByAdjacencyList graph = new GraphUndirectedByAdjacencyList(3);
      graph.addEdge(0, 1);
      graph.addEdge(1, 2);
      graph.addEdge(2, 0);
      graph.printAdjacencyList();
   }
}
