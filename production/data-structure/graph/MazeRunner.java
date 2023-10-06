package graph;

public class MazeRunner {
   private int[][] maze;
   private boolean[][] visited;

   public MazeRunner(int[][] maze) {
      this.maze = maze;
      this.visited = new boolean[maze.length][maze[0].length];
   }

   private boolean solveMaze(int rowIndex, int colIndex) {
      if (rowIndex >= this.maze.length - 1 && colIndex >= this.maze.length - 1) {
         this.visited[rowIndex][colIndex] = true;
         return true;
      } else {
         if (this.isValid(rowIndex, colIndex)) {
            this.visited[rowIndex][colIndex] = true;
            if (this.solveMaze(rowIndex + 1, colIndex)) {
               return true;
            }

            if (this.solveMaze(rowIndex - 1, colIndex)) {
               return true;
            }

            if (this.solveMaze(rowIndex, colIndex + 1)) {
               return true;
            }

            if (this.solveMaze(rowIndex, colIndex - 1)) {
               return true;
            }

            this.visited[rowIndex][colIndex] = false;
         }

         return false;
      }
   }

   private boolean isValid(int rowIndex, int colIndex) {
      if (rowIndex >= 0 && rowIndex <= this.maze.length - 1) {
         if (colIndex >= 0 && colIndex <= this.maze.length - 1) {
            if (this.visited[rowIndex][colIndex]) {
               return false;
            } else {
               return this.maze[rowIndex][colIndex] != 1;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void solve() {
      int i = false;
      int j = 0;
      boolean status = false;

      int i;
      for(i = 0; i < this.maze.length; ++i) {
         for(j = 0; j < this.maze[i].length; ++j) {
            if (this.maze[i][j] == 2) {
               status = true;
               break;
            }
         }

         if (status) {
            break;
         }
      }

      if (this.solveMaze(i, j)) {
         System.out.println("Solution exist");
         this.showResult();
      } else {
         System.out.println("No Solution..");
      }

   }

   private void showResult() {
      int i = false;
      int j = false;

      for(int i = 0; i < this.visited.length; ++i) {
         for(int j = 0; j < this.visited[i].length; ++j) {
            if (this.visited[i][j]) {
               System.out.println("[i][j] " + i + ", " + j);
            }
         }
      }

   }

   public static void main(String[] args) {
      int[][] num = new int[][]{{1, 1, 1, 1, 1}, {1, 2, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 3}};
      MazeRunner mr = new MazeRunner(num);
      mr.solve();
   }
}
