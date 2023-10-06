package dynamic.programming;

import java.util.Arrays;

public class DistanceNearestFill {
   int[][] graph;
   int[][] dp;

   DistanceNearestFill(int[][] graph) {
      this.graph = graph;
      this.dp = new int[graph.length][graph.length];
      this.initialize();
   }

   private void initialize() {
      for(int i = 0; i < this.dp.length; ++i) {
         Arrays.fill(this.dp[i], Integer.MAX_VALUE);
      }

   }

   public void nearestFil(int row, int col, int dist) {
      if (row >= 0 && row < this.graph.length && col >= 0 && col < this.graph[row].length) {
         if (this.dp[row][col] > dist) {
            this.dp[row][col] = dist;
            this.nearestFil(row, col - 1, dist + 1);
            this.nearestFil(row, col + 1, dist + 1);
            this.nearestFil(row + 1, col, dist + 1);
            this.nearestFil(row - 1, col, dist + 1);
         }
      }
   }

   public void solve() {
      for(int i = 0; i < this.graph.length; ++i) {
         for(int j = 0; j < this.graph[i].length; ++j) {
            if (this.graph[i][j] == 1) {
               this.nearestFil(i, j, 0);
            }
         }
      }

      Arrays.stream(this.dp).forEach((d) -> {
         System.out.println(Arrays.toString(d));
      });
   }

   public static void main(String[] args) {
      int[][] num = new int[][]{{1, 0, 1, 1, 0}, {1, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 1}};
      DistanceNearestFill dnf = new DistanceNearestFill(num);
      dnf.solve();
   }
}
