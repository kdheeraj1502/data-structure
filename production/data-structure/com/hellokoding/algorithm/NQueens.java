package com.hellokoding.algorithm;

public class NQueens {
   private void printBoard(int[][] board) {
      for(int i = 0; i < board.length; ++i) {
         for(int j = 0; j < board.length; ++j) {
            System.out.printf(" %d", board[i][j]);
         }

         System.out.println();
      }

   }

   private boolean isValid(int[][] board, int row, int col) {
      int i;
      for(i = 0; i < col; ++i) {
         if (board[row][i] == 1) {
            return false;
         }
      }

      i = row;

      int j;
      for(j = col; i >= 0 && j >= 0; --j) {
         if (board[i][j] == 1) {
            return false;
         }

         --i;
      }

      i = row;

      for(j = col; i < board.length && j >= 0; --j) {
         if (board[i][j] == 1) {
            return false;
         }

         ++i;
      }

      return true;
   }

   public boolean enumerate(int[][] board, int col) {
      if (col == board.length) {
         return true;
      } else {
         for(int i = 0; i < board.length; ++i) {
            if (this.isValid(board, i, col)) {
               board[i][col] = 1;
               if (this.enumerate(board, col + 1)) {
                  return true;
               }

               board[i][col] = 0;
            }
         }

         return false;
      }
   }

   public static void main(String[] args) {
      NQueens nQueens = new NQueens();
      int[][] board = new int[8][8];
      if (!nQueens.enumerate(board, 0)) {
         System.out.println("Solution not found!");
      }

      nQueens.printBoard(board);
   }
}
