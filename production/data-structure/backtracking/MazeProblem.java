package backtracking;

public class MazeProblem {
   private int[][] mazeTable;
   private int[][] solutionTable;
   private int mazeSize;

   public MazeProblem(int[][] mazeTable) {
      this.mazeTable = mazeTable;
      this.mazeSize = this.mazeTable.length;
      this.solutionTable = new int[this.mazeSize][this.mazeSize];
   }

   private boolean solveMaze(int x, int y) {
      if (x == this.mazeSize - 1 && y == this.mazeSize - 1) {
         this.solutionTable[x][y] = 1;
         return true;
      } else {
         if (this.isValid(x, y)) {
            this.solutionTable[x][y] = 1;
            if (this.solveMaze(x, y + 1)) {
               return true;
            }

            if (this.solveMaze(x + 1, y)) {
               return true;
            }

            if (this.solveMaze(x - 1, y)) {
               return true;
            }

            if (this.solveMaze(x, y - 1)) {
               return true;
            }

            this.solutionTable[x][y] = 0;
         }

         return false;
      }
   }

   private boolean isValid(int x, int y) {
      if (x >= 0 && x < this.mazeSize) {
         if (y >= 0 && y < this.mazeSize) {
            if (this.mazeTable[x][y] != 1) {
               return false;
            } else {
               return this.solutionTable[x][y] != 1;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void showResult() {
      for(int i = 0; i < this.mazeSize; ++i) {
         for(int j = 0; j < this.mazeSize; ++j) {
            if (this.solutionTable[i][j] == 1) {
               System.out.print(" p ");
            } else {
               System.out.print(" - ");
            }
         }

         System.out.println();
      }

   }

   public void solve() {
      if (this.solveMaze(0, 0)) {
         this.showResult();
      } else {
         System.out.println("No solution");
         this.showResult();
      }

   }

   public static void main(String[] args) {
      int[][] mazeTable = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 0, 1}};
      int[][] mazeTable2 = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}};
      System.out.println("----1st maze------");
      MazeProblem mp = new MazeProblem(mazeTable);
      mp.solve();
      System.out.println("----2nd maze------");
      MazeProblem mp2 = new MazeProblem(mazeTable2);
      mp2.solve();
      int[][] mazeTable3 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}};
      System.out.println("----3rd maze------");
      MazeProblem mp3 = new MazeProblem(mazeTable3);
      mp3.solve();
   }
}
