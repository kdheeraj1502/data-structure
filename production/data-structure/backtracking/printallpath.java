package backtracking;

public class printallpath {
   public static void main(String[] args) {
      int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}};
      solve(mat, 0, 0, "");
   }

   public static void solve(int[][] mat, int i, int j, String ans) {
      if (i < mat.length && j < mat[0].length) {
         if (i == mat.length - 1 && j == mat[0].length - 1) {
            System.out.println(ans + mat[i][j]);
         } else {
            int[] rx = new int[]{1, 0};
            int[] ry = new int[]{0, 1};

            for(int k = 0; k < ry.length; ++k) {
               solve(mat, i + rx[k], j + ry[k], ans + mat[i][j] + " ");
            }

         }
      }
   }
}
