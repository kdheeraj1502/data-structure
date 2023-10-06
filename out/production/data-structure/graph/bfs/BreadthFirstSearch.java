package graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
   public void traverse(Vertex root) {
      Queue<Vertex> queue = new LinkedList();
      root.setVisited(true);
      queue.add(root);

      while(!queue.isEmpty()) {
         Vertex actualVertex = (Vertex)queue.remove();
         System.out.println("�ctual visited vertex : " + actualVertex);
         Iterator var4 = actualVertex.getAdjacencyList().iterator();

         while(var4.hasNext()) {
            Vertex v = (Vertex)var4.next();
            if (!v.isVisited()) {
               v.setVisited(true);
               queue.add(v);
            }
         }
      }

   }

   public static void main(String[] args) {
      BreadthFirstSearch bfs = new BreadthFirstSearch();
      Vertex a = new Vertex("A");
      Vertex b = new Vertex("B");
      Vertex c = new Vertex("C");
      Vertex d = new Vertex("D");
      Vertex e = new Vertex("E");
      Vertex f = new Vertex("F");
      Vertex g = new Vertex("G");
      Vertex h = new Vertex("H");
      a.addNeighbors(b);
      a.addNeighbors(f);
      a.addNeighbors(g);
      b.addNeighbors(a);
      b.addNeighbors(c);
      b.addNeighbors(d);
      c.addNeighbors(b);
      d.addNeighbors(b);
      d.addNeighbors(e);
      f.addNeighbors(a);
      g.addNeighbors(a);
      g.addNeighbors(h);
      h.addNeighbors(g);
      bfs.traverse(a);
   }
}
