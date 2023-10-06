package com.hellokoding.datastructure.graph;

class GraphWeightedByAdjacencyList$WeightedVertex {
   final Integer vertex;
   final Integer weight;

   public GraphWeightedByAdjacencyList$WeightedVertex(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
   }

   public int getWeight() {
      return this.weight;
   }

   public String toString() {
      return String.format("%d (weight %d)", this.vertex, this.weight);
   }
}
