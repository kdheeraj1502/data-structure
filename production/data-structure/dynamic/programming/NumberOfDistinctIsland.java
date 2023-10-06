package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIsland {
   private int[][] grid;

   public NumberOfDistinctIsland(int[][] grid) {
      this.grid = grid;
   }

   public int numDistinctIslands() {
      int m = this.grid.length;
      int n = this.grid[0].length;
      Set<List<List<Integer>>> distinctIslands = new HashSet();

      for(int i = 0; i < m; ++i) {
         for(int j = 0; j < n; ++j) {
            List<List<Integer>> island = new ArrayList();
            if (this.grid[i][j] == 1) {
               this.dfs(i, j, i, j, island);
               distinctIslands.add(island);
            }
         }
      }

      distinctIslands.stream().forEach((list) -> {
         System.out.println(list);
      });
      return distinctIslands.size();
   }

   private void dfs(int i, int j, int row, int col, List<List<Integer>> island) {
      if (row >= 0 && row < this.grid.length && col >= 0 && col < this.grid[row].length && this.grid[row][col] != 0) {
         this.grid[row][col] = 0;
         island.add(Arrays.asList(row - i, col - j));
         this.dfs(i, j, row - 1, col, island);
         this.dfs(i, j, row, col + 1, island);
         this.dfs(i, j, row + 1, col, island);
         this.dfs(i, j, row, col - 1, island);
      }
   }

   public static void main(String[] args) {
      int[][] grid = new int[][]{{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
      NumberOfDistinctIsland ndi = new NumberOfDistinctIsland(grid);
      System.out.println(ndi.numDistinctIslands());
   }
}
