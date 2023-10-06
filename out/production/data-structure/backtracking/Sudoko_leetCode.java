package backtracking;

public class Sudoko_leetCode {
   public void solveSudoku(char[][] board) {
      this.solveSudoku(0, 0, board);
      this.printSolution(board);
   }

   private void printSolution(char[][] board) {
      for(int i = 0; i < 9; ++i) {
         if (i % 3 == 0 && i != 0) {
            System.out.println();
         }

         for(int j = 0; j < 9; ++j) {
            if (j % 3 == 0 && j != 0) {
               System.out.print(" ");
            }

            System.out.print(board[i][j] + " ");
         }

         System.out.println();
      }

   }

   private boolean solveSudoku(int rowIndex, int colIndex, char[][] board) {
      if (rowIndex == 9) {
         return true;
      } else {
         int nextRowIndex = false;
         int nextColIndex = false;
         int nextRowIndex;
         int nextColIndex;
         if (colIndex == 8) {
            nextRowIndex = rowIndex + 1;
            nextColIndex = 0;
         } else {
            nextRowIndex = rowIndex;
            nextColIndex = colIndex + 1;
         }

         if (board[rowIndex][colIndex] != 0) {
            return this.solveSudoku(nextRowIndex, nextColIndex, board);
         } else {
            for(int number = 1; number <= 9; ++number) {
               if (this.isValid(rowIndex, colIndex, number, board)) {
                  board[rowIndex][colIndex] = (char)(number + 48);
                  if (this.solveSudoku(nextRowIndex, nextColIndex, board)) {
                     return true;
                  }

                  board[rowIndex][colIndex] = '.';
               }
            }

            return false;
         }
      }
   }

   private boolean isValid(int rowIndex, int colIndex, int actualNumber, char[][] board) {
      int boxRowOffSet;
      for(boxRowOffSet = 0; boxRowOffSet < 9; ++boxRowOffSet) {
         if (board[rowIndex][boxRowOffSet] == actualNumber) {
            return false;
         }
      }

      for(boxRowOffSet = 0; boxRowOffSet < 9; ++boxRowOffSet) {
         if (board[boxRowOffSet][colIndex] == actualNumber) {
            return false;
         }
      }

      boxRowOffSet = rowIndex / 3 * 3;
      int boxColOffSet = colIndex / 3 * 3;

      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            if ((char)(actualNumber + 48) == board[boxRowOffSet + i][boxColOffSet + j]) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean feasibleSudoko(int rowIndex, int colIndex, char[][] board) {
      if (rowIndex == 9) {
         return true;
      } else {
         int nextRowIndex = false;
         int nextColIndex = false;
         int nextRowIndex;
         int nextColIndex;
         if (colIndex == 8) {
            nextRowIndex = rowIndex + 1;
            nextColIndex = 0;
         } else {
            nextRowIndex = rowIndex;
            nextColIndex = colIndex + 1;
         }

         if (board[rowIndex][colIndex] != '.') {
            return this.feasibleSudoko(nextRowIndex, nextColIndex, board);
         } else {
            for(int number = 1; number <= 9; ++number) {
               if (this.isValid_1(rowIndex, colIndex, number, board)) {
                  board[rowIndex][colIndex] = (char)(number + 48);
                  if (this.feasibleSudoko(nextRowIndex, nextColIndex, board)) {
                     return true;
                  }

                  board[rowIndex][colIndex] = '.';
               }
            }

            return false;
         }
      }
   }

   private boolean isValid_1(int rowIndex, int colIndex, int actualNumber, char[][] board) {
      int boxRowOffSet;
      for(boxRowOffSet = 0; boxRowOffSet < 9; ++boxRowOffSet) {
         if (board[rowIndex][boxRowOffSet] == (char)(actualNumber + 48)) {
            return false;
         }
      }

      for(boxRowOffSet = 0; boxRowOffSet < 9; ++boxRowOffSet) {
         if (board[boxRowOffSet][colIndex] == (char)(actualNumber + 48)) {
            return false;
         }
      }

      boxRowOffSet = rowIndex / 3 * 3;
      int boxColOffSet = colIndex / 3 * 3;

      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            if ((char)(actualNumber + 48) == board[boxRowOffSet + i][boxColOffSet + j]) {
               return false;
            }
         }
      }

      return true;
   }

   private void printSolution_1(char[][] board) {
      for(int i = 0; i < 9; ++i) {
         if (i % 3 == 0 && i != 0) {
            System.out.println();
         }

         for(int j = 0; j < 9; ++j) {
            if (j % 3 == 0 && j != 0) {
               System.out.print(" ");
            }

            System.out.print(board[i][j] + " ");
         }

         System.out.println();
      }

   }

   public void solve(char[][] board) {
      if (this.feasibleSudoko(0, 0, board)) {
         this.printSolution_1(board);
      } else {
         System.out.println("There is no solution ...");
      }

   }

   public static void main(String[] args) {
      char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
      Sudoko_leetCode sl = new Sudoko_leetCode();
      sl.solve(board);
   }
}
