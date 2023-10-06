package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblemForMultipleSolution {
   char[][] chessBoard = (char[][])null;
   List<List<String>> res = new ArrayList();

   public List<List<String>> solveNQueens(int n) {
      this.chessBoard = new char[n][n];

      for(int i = 0; i < n; ++i) {
         for(int j = 0; j < n; ++j) {
            this.chessBoard[i][j] = '.';
         }
      }

      this.solve(0);
      return this.res;
   }

   void solve(int column) {
      if (column == this.chessBoard.length) {
         this.populateResult();
      } else {
         for(int i = 0; i < this.chessBoard.length; ++i) {
            if (this.isValid(i, column)) {
               this.chessBoard[i][column] = 'Q';
               this.solve(column + 1);
               this.chessBoard[i][column] = '.';
            }
         }

      }
   }

   void populateResult() {
      StringBuilder sb = new StringBuilder();
      List<String> ans = new ArrayList();

      for(int i = 0; i < this.chessBoard.length; ++i) {
         for(int j = 0; j < this.chessBoard[0].length; ++j) {
            sb.append(this.chessBoard[i][j]);
         }

         ans.add(sb.toString());
         sb.setLength(0);
      }

      this.res.add(ans);
   }

   boolean isValid(int row, int col) {
      int i;
      for(i = 0; i < this.chessBoard.length; ++i) {
         if (this.chessBoard[row][i] == 'Q') {
            return false;
         }
      }

      i = row;

      int j;
      for(j = col; i < this.chessBoard.length && j >= 0; --j) {
         if (this.chessBoard[i][j] == 'Q') {
            return false;
         }

         ++i;
      }

      i = row;

      for(j = col; i >= 0 && j >= 0; --j) {
         if (this.chessBoard[i][j] == 'Q') {
            return false;
         }

         --i;
      }

      return true;
   }
}
