package backtracking;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoko {
   public boolean isValidSudoku(char[][] board) {
      Set<Character> set = null;

      int col;
      int i;
      for(col = 0; col < 9; ++col) {
         set = new HashSet();

         for(i = 0; i < 9; ++i) {
            if (board[col][i] != '.' && set.contains(board[col][i])) {
               System.out.println("1 Issue" + set);
               return false;
            }

            set.add(board[col][i]);
         }
      }

      for(col = 0; col < 9; ++col) {
         set = new HashSet();

         for(i = 0; i < 9; ++i) {
            if (board[i][col] != '.' && set.contains(board[i][col])) {
               System.out.println("2 Issue" + set);
               return false;
            }

            set.add(board[i][col]);
         }
      }

      for(i = 0; i < 9; i += 3) {
         for(int j = 0; j < 9; j += 3) {
            set = new HashSet();

            for(int k = i; k < i + 3; ++k) {
               for(int z = j; z < j + 3; ++z) {
                  if (board[k][z] != '.' && set.contains(board[k][z])) {
                     System.out.println("3 Issue" + set);
                     return false;
                  }

                  set.add(board[k][z]);
               }
            }
         }
      }

      return true;
   }

   public static void main(String[] args) {
      char[][] board = new char[][]{{'.', '.', '.', '.', '.', '.', '5', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '3', '.', '.', '2', '.', '4', '.', '.'}, {'.', '.', '7', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '3', '4', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '.'}, {'.', '.', '.', '.', '.', '5', '2', '.', '.'}};
      IsValidSudoko is = new IsValidSudoko();
      System.out.println(is.isValidSudoku(board));
   }
}
