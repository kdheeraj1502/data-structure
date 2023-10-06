package graph.DAG;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
   private Stack<Vertex> stack = new Stack();

   public TopologicalOrdering(List<Vertex> graph) {
      for(int i = 0; i < graph.size(); ++i) {
         if (!((Vertex)graph.get(i)).isVisited()) {
            this.dfs((Vertex)graph.get(i));
         }
      }

   }

   private void dfs(Vertex vertex) {
      vertex.setVisited(true);
      Iterator var2 = vertex.getNeighbors().iterator();

      while(var2.hasNext()) {
         Edge e = (Edge)var2.next();
         if (!e.getTarget().isVisited()) {
            this.dfs(e.getTarget());
         }
      }

      this.stack.add(vertex);
   }

   public Stack<Vertex> getStack() {
      return this.stack;
   }
}
