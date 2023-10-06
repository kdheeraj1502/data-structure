package dynamic.programming;

public class NUmberOfIslands {
   public int numIslands(char[][] grid) {
      if (grid != null && grid.length != 0) {
         int numOfIslands = 0;

         for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
               if (grid[i][j] == '1') {
                  numOfIslands += this.dfs(grid, i, j);
               }
            }
         }

         return numOfIslands;
      } else {
         return 0;
      }
   }

   private int dfs(char[][] grid, int i, int j) {
      if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] != '0') {
         grid[i][j] = '0';
         this.dfs(grid, i - 1, j);
         this.dfs(grid, i, j + 1);
         this.dfs(grid, i + 1, j);
         this.dfs(grid, i, j - 1);
         return 1;
      } else {
         return 0;
      }
   }

   public static void main(String[] args) {
      char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
      NUmberOfIslands noi = new NUmberOfIslands();
      System.out.println(noi.numIslands(grid));
   }
}
