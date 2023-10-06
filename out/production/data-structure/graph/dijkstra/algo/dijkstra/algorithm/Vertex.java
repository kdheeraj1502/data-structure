package graph.dijkstra.algo.dijkstra.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
   private String name;
   private List<Edge> adjacenciesList;
   private boolean visited;
   private Vertex predecessor;
   private double minDistance = Double.MAX_VALUE;

   public Vertex(String name) {
      this.name = name;
      this.adjacenciesList = new ArrayList();
   }

   public void addNeighbour(Edge edge) {
      this.adjacenciesList.add(edge);
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Edge> getAdjacenciesList() {
      return this.adjacenciesList;
   }

   public void setAdjacenciesList(List<Edge> adjacenciesList) {
      this.adjacenciesList = adjacenciesList;
   }

   public boolean isVisited() {
      return this.visited;
   }

   public void setVisited(boolean visited) {
      this.visited = visited;
   }

   public Vertex getPredecessor() {
      return this.predecessor;
   }

   public void setPredecessor(Vertex predecessor) {
      this.predecessor = predecessor;
   }

   public double getMinDistance() {
      return this.minDistance;
   }

   public void setMinDistance(double minDistance) {
      this.minDistance = minDistance;
   }

   public String toString() {
      return this.name;
   }

   public int compareTo(Vertex otherVertex) {
      return Double.compare(this.minDistance, otherVertex.getMinDistance());
   }
}
