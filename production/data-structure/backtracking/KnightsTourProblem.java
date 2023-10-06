package backtracking;

public class KnightsTourProblem {
   private int[][] chessBoard = new int[8][8];
   private int[] xMoves = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
   private int[] yMoves = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
   private int numOfMoves = 8;

   public KnightsTourProblem() {
      this.initializeBoard();
   }

   private void initializeBoard() {
      for(int i = 0; i < 8; ++i) {
         for(int j = 0; j < 8; ++j) {
            this.chessBoard[i][j] = Integer.MIN_VALUE;
         }
      }

   }

   private boolean solve(int stepCount, int xCord, int yCord) {
      if (stepCount == 65) {
         return true;
      } else {
         for(int i = 0; i < this.numOfMoves; ++i) {
            int nextX = xCord + this.xMoves[i];
            int nextY = yCord + this.yMoves[i];
            if (this.isValid(nextX, nextY)) {
               this.chessBoard[nextX][nextY] = stepCount;
               if (this.solve(stepCount + 1, nextX, nextY)) {
                  return true;
               }

               this.chessBoard[nextX][nextY] = Integer.MIN_VALUE;
            }
         }

         return false;
      }
   }

   private boolean isValid(int nextX, int nextY) {
      if (nextX >= 0 && nextX < 8) {
         if (nextY >= 0 && nextY < 8) {
            return this.chessBoard[nextX][nextY] == Integer.MIN_VALUE;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void solveTour() {
      this.chessBoard[0][0] = 1;
      if (this.solve(2, 0, 0)) {
         this.printSolution();
      } else {
         System.out.println("No Feasible Solution ... ");
      }

   }

   public void printSolution() {
      for(int i = 0; i < 8; ++i) {
         for(int j = 0; j < 8; ++j) {
            if (this.chessBoard[i][j] < 10) {
               System.out.print("| ");
               System.out.print("0" + this.chessBoard[i][j]);
               System.out.print("| ");
            } else {
               System.out.print("| ");
               System.out.print(this.chessBoard[i][j]);
               System.out.print("| ");
            }
         }

         System.out.println();
      }

   }

   public static void main(String[] args) {
      KnightsTourProblem ktp = new KnightsTourProblem();
      ktp.solveTour();
   }
}
