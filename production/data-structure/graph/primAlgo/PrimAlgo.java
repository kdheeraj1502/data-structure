package graph.primAlgo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgo {
   private List<Vertex> unvisitedVertices;
   private List<Edge> spanningTree;
   private PriorityQueue<Edge> edgeHeap;
   private double fullCost;

   public PrimAlgo(List<Vertex> unvisitedList) {
      System.out.println();
      this.spanningTree = new ArrayList();
      this.unvisitedVertices = unvisitedList;
      this.edgeHeap = new PriorityQueue();
   }

   public void primsAlgorithm(Vertex vertex) {
      this.unvisitedVertices.remove(vertex);

      Iterator var2;
      Edge edge;
      while(!this.unvisitedVertices.isEmpty()) {
         var2 = vertex.getAdjacencies().iterator();

         while(var2.hasNext()) {
            edge = (Edge)var2.next();
            if (this.unvisitedVertices.contains(edge.getTargetVertex())) {
               this.edgeHeap.add(edge);
            }
         }

         Edge e = (Edge)this.edgeHeap.remove();
         this.spanningTree.add(e);
         this.fullCost += e.getWeight();
         vertex = e.getTargetVertex();
         this.unvisitedVertices.remove(vertex);
      }

      System.out.println(this.fullCost);
      var2 = this.spanningTree.iterator();

      while(var2.hasNext()) {
         edge = (Edge)var2.next();
         System.out.println(edge.getStartVertex() + "-" + edge.getTargetVertex());
      }

   }

   public void setUnvisitedVertices(List<Vertex> unvisitedVertices) {
      this.unvisitedVertices = unvisitedVertices;
   }

   public List<Edge> getSpanningTree() {
      return this.spanningTree;
   }

   public void clearData() {
      this.spanningTree.clear();
      this.edgeHeap.clear();
   }

   public static void main(String[] args) {
      List<Vertex> vertexList = new ArrayList();
      Vertex vertex0 = new Vertex("A");
      Vertex vertex1 = new Vertex("B");
      Vertex vertex2 = new Vertex("C");
      vertexList.add(vertex0);
      vertexList.add(vertex1);
      vertexList.add(vertex2);
      vertex0.addEdge(new Edge(vertex0, vertex1, 1.0));
      vertex0.addEdge(new Edge(vertex0, vertex2, 1.0));
      vertex1.addEdge(new Edge(vertex1, vertex2, 10.0));
      vertex1.addEdge(new Edge(vertex1, vertex0, 1.0));
      vertex2.addEdge(new Edge(vertex2, vertex0, 1.0));
      vertex2.addEdge(new Edge(vertex2, vertex1, 10.0));
      PrimAlgo algorithm = new PrimAlgo(vertexList);
      algorithm.primsAlgorithm(vertex2);
   }
}
