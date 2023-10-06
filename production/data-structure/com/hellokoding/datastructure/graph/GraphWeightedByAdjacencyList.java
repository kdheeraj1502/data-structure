package com.hellokoding.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphWeightedByAdjacencyList {
   private int V;
   private List<List<WeightedVertex>> adjacencyList;

   public GraphWeightedByAdjacencyList(int V) {
      this.V = V;
      this.adjacencyList = new ArrayList(V);

      for(int i = 0; i < V; ++i) {
         this.adjacencyList.add(new ArrayList());
      }

   }

   public Integer getV() {
      return this.V;
   }

   public List<List<WeightedVertex>> getAdjacencyList() {
      return this.adjacencyList;
   }

   public void addEdge(int source, int dest, int weight) {
      ((List)this.adjacencyList.get(source)).add(new WeightedVertex(dest, weight));
   }

   public void printAdjacencyList() {
      for(int i = 0; i < this.V; ++i) {
         System.out.printf("Adjacency list of vertex %d is %s %s", i, this.adjacencyList.get(i), System.lineSeparator());
      }

   }

   public static void main(String[] args) {
      GraphWeightedByAdjacencyList g = new GraphWeightedByAdjacencyList(4);
      g.addEdge(0, 1, 19);
      g.addEdge(2, 0, 15);
      g.addEdge(2, 1, 17);
      g.addEdge(3, 2, 12);
      g.printAdjacencyList();
   }
}
