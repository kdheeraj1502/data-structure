package mattrix;

public class searchmatrix {
   public static void main(String[] args) {
      int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
      System.out.println(search(matrix, 12));
   }

   public static boolean search(int[][] matrix, int target) {
      int r = 0;
      int c = matrix[0].length - 1;

      while(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
         if (matrix[r][c] < target) {
            ++r;
         } else {
            if (matrix[r][c] <= target) {
               return true;
            }

            --c;
         }
      }

      return false;
   }
}
