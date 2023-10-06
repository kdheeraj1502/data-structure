package graph.dijkstra.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {
   public void computePath(Vertex sourceVertex) {
      sourceVertex.setDistance(0.0);
      PriorityQueue<Vertex> priorityQueue = new PriorityQueue();
      priorityQueue.add(sourceVertex);

      while(!priorityQueue.isEmpty()) {
         Vertex acualVertex = (Vertex)priorityQueue.poll();
         Iterator var4 = acualVertex.getNeighbors().iterator();

         while(var4.hasNext()) {
            Edge edge = (Edge)var4.next();
            Vertex v = edge.getTargetVertex();
            double newDistance = acualVertex.getDistance() + edge.getWeight();
            if (newDistance < v.getDistance()) {
               priorityQueue.remove(v);
               v.setDistance(newDistance);
               v.setPredecessor(acualVertex);
               priorityQueue.add(v);
            }
         }
      }

   }

   public List<Vertex> getShortestPath(Vertex target) {
      List<Vertex> shortestPath = new ArrayList();

      for(Vertex vertex = target; vertex != null; vertex = vertex.getPredecessor()) {
         shortestPath.add(vertex);
      }

      Collections.reverse(shortestPath);
      return shortestPath;
   }

   public static void main(String[] args) {
      Vertex vertex0 = new Vertex("A");
      Vertex vertex1 = new Vertex("B");
      Vertex vertex2 = new Vertex("C");
      vertex0.addNeighbor(new Edge(1.0, vertex0, vertex1));
      vertex0.addNeighbor(new Edge(3.0, vertex0, vertex2));
      vertex1.addNeighbor(new Edge(1.0, vertex1, vertex2));
      DijkstraShortestPath shortestPath = new DijkstraShortestPath();
      shortestPath.computePath(vertex0);
      System.out.println(shortestPath.getShortestPath(vertex2));
   }
}
