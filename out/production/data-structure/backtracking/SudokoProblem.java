package backtracking;

public class SudokoProblem {
   private int[][] sudokoTable;

   public SudokoProblem(int[][] sudokoTable) {
      this.sudokoTable = sudokoTable;
   }

   private boolean feasibleSudoko(int rowIndex, int colIndex) {
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

         if (this.sudokoTable[rowIndex][colIndex] != 0) {
            return this.feasibleSudoko(nextRowIndex, nextColIndex);
         } else {
            for(int number = 1; number <= 9; ++number) {
               if (this.isValid(rowIndex, colIndex, number)) {
                  this.sudokoTable[rowIndex][colIndex] = number;
                  if (this.feasibleSudoko(nextRowIndex, nextColIndex)) {
                     return true;
                  }

                  this.sudokoTable[rowIndex][colIndex] = 0;
               }
            }

            return false;
         }
      }
   }

   private boolean isValid(int rowIndex, int colIndex, int actualNumber) {
      int boxRowOffSet;
      for(boxRowOffSet = 0; boxRowOffSet < 9; ++boxRowOffSet) {
         if (this.sudokoTable[rowIndex][boxRowOffSet] == actualNumber) {
            return false;
         }
      }

      for(boxRowOffSet = 0; boxRowOffSet < 9; ++boxRowOffSet) {
         if (this.sudokoTable[boxRowOffSet][colIndex] == actualNumber) {
            return false;
         }
      }

      boxRowOffSet = rowIndex / 3 * 3;
      int boxColOffSet = colIndex / 3 * 3;

      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            if (actualNumber == this.sudokoTable[boxRowOffSet + i][boxColOffSet + j]) {
               return false;
            }
         }
      }

      return true;
   }

   private void printSolution() {
      for(int i = 0; i < 9; ++i) {
         if (i % 3 == 0 && i != 0) {
            System.out.println();
         }

         for(int j = 0; j < 9; ++j) {
            if (j % 3 == 0 && j != 0) {
               System.out.print(" ");
            }

            System.out.print(this.sudokoTable[i][j] + " ");
         }

         System.out.println();
      }

   }

   public void solve() {
      if (this.feasibleSudoko(0, 0)) {
         this.printSolution();
      } else {
         System.out.println("There is no solution ...");
      }

   }

   public static void main(String[] args) throws Exception {
      int a = 9;
      char c = (char)(a + 48);
      System.out.println(c);
      System.out.println("----------------");
      int[][] var10000 = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0, 0, 3, 1}, {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 8, 6, 3, 0, 0, 5}, {0, 5, 0, 0, 9, 0, 6, 0, 0}, {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4}, {0, 0, 5, 2, 0, 6, 3, 0, 0}};
      var10000 = new int[][]{{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
      int[][] sudokoTable2 = new int[][]{{0, 0, 1, 0, 8, 5, 0, 0, 4}, {0, 7, 4, 0, 0, 3, 8, 0, 0}, {0, 0, 0, 0, 4, 0, 0, 7, 0}, {7, 9, 0, 0, 0, 1, 0, 2, 0}, {0, 0, 3, 9, 0, 0, 5, 0, 7}, {0, 1, 0, 0, 0, 2, 0, 0, 0}, {0, 3, 0, 0, 2, 0, 0, 0, 5}, {0, 0, 9, 0, 0, 0, 3, 0, 2}, {0, 0, 0, 0, 0, 0, 0, 0, 0}};
      var10000 = new int[][]{{7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}, {7, 7, 7, 7, 7, 7, 7, 7, 7}};
      SudokoProblem sp = new SudokoProblem(sudokoTable2);
      sp.solve();
   }
}
