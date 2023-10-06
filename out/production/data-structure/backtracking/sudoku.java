package backtracking;

public class sudoku {
   public static void main(String[] args) {
      for(int i = 0; i < 9; i += 3) {
         System.out.println("Row " + i);
         System.out.println();

         for(int j = 0; j < 9; j += 3) {
            for(int k = i; k < i + 3; ++k) {
               for(int z = j; z < j + 3; ++z) {
                  System.out.print(z + ", ");
               }

               System.out.println();
            }
         }
      }

      int[][] grid = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0, 0, 3, 1}, {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 8, 6, 3, 0, 0, 5}, {0, 5, 0, 0, 9, 0, 6, 0, 0}, {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4}, {0, 0, 5, 2, 0, 6, 3, 0, 0}};
      if (SolveSudoku(grid)) {
         printGrid(grid);
      }

   }

   static boolean SolveSudoku(int[][] grid) {
      return solve(grid, 0, 0);
   }

   static boolean solve(int[][] grid, int i, int j) {
      if (i == grid.length - 1 && j == grid.length) {
         return true;
      } else if (i >= grid.length) {
         return false;
      } else {
         if (j == grid.length) {
            j = 0;
            ++i;
         }

         if (grid[i][j] == 0) {
            for(int val = 1; val <= 9; ++val) {
               if (check(grid, i, j, val)) {
                  grid[i][j] = val;
                  if (solve(grid, i, j + 1)) {
                     return true;
                  }

                  grid[i][j] = 0;
               }
            }

            return false;
         } else {
            return solve(grid, i, j + 1);
         }
      }
   }

   private static boolean check(int[][] grid, int i, int j, int val) {
      int starti;
      for(starti = 0; starti < grid.length; ++starti) {
         if (grid[starti][j] == val) {
            return false;
         }
      }

      for(starti = 0; starti < grid.length; ++starti) {
         if (grid[i][starti] == val) {
            return false;
         }
      }

      starti = i / 3 * 3;
      int startj = j / 3 * 3;

      for(int k = starti; k < starti + 3; ++k) {
         for(int k2 = startj; k2 < startj + 3; ++k2) {
            if (grid[k][k2] == val) {
               return false;
            }
         }
      }

      return true;
   }

   static void printGrid(int[][] grid) {
      for(int k1 = 0; k1 < grid.length; ++k1) {
         for(int k2 = 0; k2 < grid.length; ++k2) {
            System.out.print(grid[k1][k2] + " ");
         }

         System.out.println();
      }

   }
}
