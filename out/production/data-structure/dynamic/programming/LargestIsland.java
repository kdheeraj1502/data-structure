package dynamic.programming;

import java.util.Arrays;

public class LargestIsland {
   int[][] graph;
   int[][] dp;
   int[][] visted;

   LargestIsland(int[][] graph) {
      this.graph = graph;
      this.dp = new int[graph.length][graph[0].length];
      this.visted = new int[graph.length][graph[0].length];
      this.initialize();
   }

   private void initialize() {
      for(int i = 0; i < this.dp.length; ++i) {
         Arrays.fill(this.dp[i], Integer.MAX_VALUE);
      }

   }

   public int largestIsland(int row, int col, int value) {
      if (row >= 0 && row < this.graph.length && col >= 0 && col < this.graph[row].length && this.graph[row][col] != 0) {
         this.graph[row][col] = 0;
         return 1 + this.largestIsland(row - 1, col, value) + this.largestIsland(row - 1, col + 1, value) + this.largestIsland(row, col + 1, value) + this.largestIsland(row + 1, col + 1, value) + this.largestIsland(row + 1, col, value) + this.largestIsland(row + 1, col - 1, value) + this.largestIsland(row, col - 1, value) + this.largestIsland(row - 1, col - 1, value);
      } else {
         return 0;
      }
   }

   public int solve() {
      int maxVal = 0;

      for(int i = 0; i < this.graph.length; ++i) {
         for(int j = 0; j < this.graph[i].length; ++j) {
            if (this.graph[i][j] == 1) {
               maxVal = Math.max(maxVal, this.largestIsland(i, j, this.graph[i][j]));
            }
         }
      }

      return maxVal;
   }

   public static void main(String[] args) {
      int[][] graph = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
      LargestIsland li = new LargestIsland(graph);
      System.out.println(li.solve());
   }
}
