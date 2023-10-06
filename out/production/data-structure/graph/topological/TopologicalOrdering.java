package graph.topological;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
   private Stack<Vertex> stack = new Stack();

   public void dfs(Vertex vertex) {
      vertex.setVisited(true);
      Iterator var2 = vertex.getNeighbor().iterator();

      while(var2.hasNext()) {
         Vertex v = (Vertex)var2.next();
         if (!v.isVisited()) {
            v.setVisited(true);
            this.dfs(v);
         }
      }

      this.stack.push(vertex);
   }

   public Stack<Vertex> getStack() {
      return this.stack;
   }

   public static void main(String[] args) {
      TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
      List<Vertex> graph = new ArrayList();
      graph.add(new Vertex("0"));
      graph.add(new Vertex("1"));
      graph.add(new Vertex("2"));
      graph.add(new Vertex("3"));
      graph.add(new Vertex("4"));
      graph.add(new Vertex("5"));
      ((Vertex)graph.get(2)).addNeighbor((Vertex)graph.get(3));
      ((Vertex)graph.get(3)).addNeighbor((Vertex)graph.get(1));
      ((Vertex)graph.get(4)).addNeighbor((Vertex)graph.get(0));
      ((Vertex)graph.get(4)).addNeighbor((Vertex)graph.get(1));
      ((Vertex)graph.get(5)).addNeighbor((Vertex)graph.get(0));
      ((Vertex)graph.get(5)).addNeighbor((Vertex)graph.get(2));

      for(int i = 0; i < graph.size(); ++i) {
         if (!((Vertex)graph.get(i)).isVisited()) {
            topologicalOrdering.dfs((Vertex)graph.get(i));
         }
      }

      Stack<Vertex> stack = topologicalOrdering.getStack();

      for(int i = 0; i < graph.size(); ++i) {
         Vertex vertex = (Vertex)stack.pop();
         System.out.println(vertex + " ->");
      }

   }
}
