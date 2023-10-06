package backtracking;

import java.util.ArrayList;
import java.util.List;

public class TravellingSalesManProblem {
   private int[][] graph;
   private List<Integer> path;
   private boolean[] visited;
   private int min;

   public TravellingSalesManProblem(int[][] graph) {
      this.graph = graph;
      this.path = new ArrayList();
      this.visited = new boolean[graph.length];
      this.initialize();
   }

   private void initialize() {
      this.path.add(0);
      this.visited[0] = true;
      this.min = Integer.MAX_VALUE;
   }

   public static void main(String[] args) {
      int[][] graph = new int[][]{{0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0}};
      TravellingSalesManProblem tsm = new TravellingSalesManProblem(graph);
      tsm.solve(0, 1, 0);
      System.out.println(tsm.min);
   }

   private void solve(int actualPosition, int counter, int cost) {
      if (counter == this.graph.length && this.graph[actualPosition][0] != 0) {
         this.path.add(0);
         this.path.forEach((num) -> {
            System.out.print(num + ", ");
         });
         System.out.println("\nCost " + (cost + this.graph[actualPosition][0]) + "\n");
         if (cost + this.graph[actualPosition][0] < this.min) {
            this.min = cost + this.graph[actualPosition][0];
         }

         this.path.remove(this.path.size() - 1);
      } else {
         for(int i = 0; i < this.graph.length; ++i) {
            if (this.isValid(actualPosition, i)) {
               this.visited[i] = true;
               this.path.add(i);
               this.solve(i, counter + 1, cost + this.graph[actualPosition][i]);
               this.visited[i] = false;
               this.path.remove(this.path.size() - 1);
            }
         }

      }
   }

   private boolean isValid(int actualPosition, int vertex) {
      if (this.visited[vertex]) {
         return false;
      } else {
         return this.graph[actualPosition][vertex] != 0;
      }
   }
}
