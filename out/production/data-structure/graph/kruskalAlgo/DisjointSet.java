package graph.kruskalAlgo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisjointSet {
   private int nodeCount = 0;
   private int setCount = 0;
   private List<Node> rootNodes;

   public DisjointSet(List<Vertex> vertices) {
      this.rootNodes = new ArrayList(vertices.size());
      this.makeSets(vertices);
   }

   public int find(Node n) {
      Node current;
      for(current = n; current.getParent() != null; current = current.getParent()) {
      }

      Node root = current;

      Node temp;
      for(current = n; current != root; current = temp) {
         temp = current.getParent();
         current.setParent(root);
      }

      return root.getId();
   }

   public void union(Node node1, Node node2) {
      int index1 = this.find(node1);
      int index2 = this.find(node2);
      if (index1 != index2) {
         Node root1 = (Node)this.rootNodes.get(index1);
         Node root2 = (Node)this.rootNodes.get(index2);
         if (root1.getHeight() < root2.getHeight()) {
            root1.setParent(root2);
         } else if (root1.getHeight() > root2.getHeight()) {
            root2.setParent(root1);
         } else {
            root2.setParent(root1);
            root1.setHeight(root1.getHeight() + 1);
         }

         --this.setCount;
      }
   }

   public void makeSets(List<Vertex> vertices) {
      Iterator var2 = vertices.iterator();

      while(var2.hasNext()) {
         Vertex v = (Vertex)var2.next();
         this.makeSet(v);
      }

   }

   public void makeSet(Vertex vertex) {
      Node n = new Node(0, this.rootNodes.size(), (Node)null);
      vertex.setNode(n);
      this.rootNodes.add(n);
      ++this.setCount;
      ++this.nodeCount;
   }
}
