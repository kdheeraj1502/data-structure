package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class MatrixPath {
   public static List<List<Integer>> getAllPath(int[][] num) {
      List<List<Integer>> result = new ArrayList();
      getAllPath(num, 0, 0, result, new ArrayList());
      return result;
   }

   public static void getAllPath(int[][] num, int row, int col, List<List<Integer>> result, List<Integer> curr) {
      if (num.length != 1) {
         if (num[row].length != 1) {
            if (row >= num.length && col >= num[row].length) {
               result.add(curr);
               curr.clear();
            } else {
               for(int i = 0; i < num.length; ++i) {
               }

            }
         }
      }
   }

   private static void canMove(int[][] num, int row, int col) {
      boolean var10000;
      if (row < num.length && col < num[row].length) {
         var10000 = true;
      } else {
         var10000 = false;
      }

   }

   public static void main(String[] args) {
      int[][] var10000 = new int[][]{{1, 2, 3}, {4, 5, 6}};
   }
}
