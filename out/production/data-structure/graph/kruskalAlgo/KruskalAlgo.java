package graph.kruskalAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class KruskalAlgo {
   public void spanningTree(List<Vertex> vertexList, List<Edge> edgeList) {
      DisjointSet disjointSet = new DisjointSet(vertexList);
      List<Edge> tree = new ArrayList();
      Collections.sort(edgeList);
      Iterator var5 = edgeList.iterator();

      Edge edge;
      while(var5.hasNext()) {
         edge = (Edge)var5.next();
         Vertex u = edge.getStartVertex();
         Vertex v = edge.getTargetVertex();
         if (disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())) {
            tree.add(edge);
            disjointSet.union(u.getNode(), v.getNode());
         }
      }

      var5 = tree.iterator();

      while(var5.hasNext()) {
         edge = (Edge)var5.next();
         System.out.print("" + edge.getStartVertex() + "" + edge.getTargetVertex() + "-");
      }

   }

   public static void main(String[] args) {
      List<Vertex> vertexList = new ArrayList();
      vertexList.add(new Vertex("A"));
      vertexList.add(new Vertex("B"));
      vertexList.add(new Vertex("C"));
      vertexList.add(new Vertex("D"));
      vertexList.add(new Vertex("E"));
      vertexList.add(new Vertex("F"));
      vertexList.add(new Vertex("G"));
      vertexList.add(new Vertex("H"));
      List<Edge> edgeList = new ArrayList();
      edgeList.add(new Edge((Vertex)vertexList.get(0), (Vertex)vertexList.get(1), 3.0));
      edgeList.add(new Edge((Vertex)vertexList.get(0), (Vertex)vertexList.get(2), 2.0));
      edgeList.add(new Edge((Vertex)vertexList.get(0), (Vertex)vertexList.get(3), 5.0));
      edgeList.add(new Edge((Vertex)vertexList.get(1), (Vertex)vertexList.get(5), 13.0));
      edgeList.add(new Edge((Vertex)vertexList.get(1), (Vertex)vertexList.get(3), 2.0));
      edgeList.add(new Edge((Vertex)vertexList.get(2), (Vertex)vertexList.get(4), 5.0));
      edgeList.add(new Edge((Vertex)vertexList.get(2), (Vertex)vertexList.get(3), 2.0));
      edgeList.add(new Edge((Vertex)vertexList.get(3), (Vertex)vertexList.get(4), 4.0));
      edgeList.add(new Edge((Vertex)vertexList.get(3), (Vertex)vertexList.get(5), 6.0));
      edgeList.add(new Edge((Vertex)vertexList.get(3), (Vertex)vertexList.get(6), 3.0));
      edgeList.add(new Edge((Vertex)vertexList.get(4), (Vertex)vertexList.get(6), 6.0));
      edgeList.add(new Edge((Vertex)vertexList.get(5), (Vertex)vertexList.get(6), 2.0));
      edgeList.add(new Edge((Vertex)vertexList.get(5), (Vertex)vertexList.get(7), 3.0));
      edgeList.add(new Edge((Vertex)vertexList.get(6), (Vertex)vertexList.get(7), 6.0));
      KruskalAlgo kruskalAlgorithm = new KruskalAlgo();
      kruskalAlgorithm.spanningTree(vertexList, edgeList);
   }
}
