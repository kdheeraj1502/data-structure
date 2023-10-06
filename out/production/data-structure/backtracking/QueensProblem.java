package backtracking;

import java.util.Arrays;

public class QueensProblem {
   private int[][] chessBoard;
   private int numOfQueens;

   public QueensProblem() {
   }

   public QueensProblem(int numOfQueens) {
      this.numOfQueens = numOfQueens;
      this.chessBoard = new int[numOfQueens][numOfQueens];
   }

   private boolean isPlaceValid(int rowIndex, int colIndex) {
      int i;
      for(i = 0; i < this.chessBoard.length; ++i) {
         if (this.chessBoard[rowIndex][i] == 1) {
            return false;
         }
      }

      i = rowIndex;

      int j;
      for(j = colIndex; i < this.chessBoard.length && j >= 0; --j) {
         if (this.chessBoard[i][j] == 1) {
            return false;
         }

         ++i;
      }

      i = rowIndex;

      for(j = colIndex; i >= 0 && j >= 0; --j) {
         if (this.chessBoard[i][j] == 1) {
            return false;
         }

         --i;
      }

      return true;
   }

   public boolean nQueenProb(int colIndex) {
      if (this.chessBoard.length == colIndex) {
         return true;
      } else {
         for(int rowIndex = 0; rowIndex < this.numOfQueens; ++rowIndex) {
            if (this.isPlaceValid(rowIndex, colIndex)) {
               this.chessBoard[rowIndex][colIndex] = 1;
               if (this.nQueenProb(colIndex + 1)) {
                  return true;
               }

               this.chessBoard[rowIndex][colIndex] = 0;
            }
         }

         return false;
      }
   }

   public void solve(int numOfQueens) {
      this.numOfQueens = numOfQueens;
      this.chessBoard = new int[numOfQueens][numOfQueens];
      if (this.nQueenProb(0)) {
         this.printQueens();
      } else {
         System.out.println("There is no solution...");
      }

   }

   private void printQueens() {
      for(int i = 0; i < this.chessBoard.length; ++i) {
         for(int j = 0; j < this.chessBoard[i].length; ++j) {
            if (this.chessBoard[i][j] == 1) {
               System.out.print(" * ");
            } else {
               System.out.print(" - ");
            }
         }

         System.out.println();
      }

   }

   public static void main(String[] args) {
      char[][] chessBoard = new char[8][8];

      for(int i = 0; i < 8; ++i) {
         Arrays.fill(chessBoard[i], '.');
      }

      QueensProblem qp = new QueensProblem();
      System.out.println(System.currentTimeMillis() / 1000L);
      qp.solve(8);
      System.out.println(System.currentTimeMillis() / 1000L);
   }
}
