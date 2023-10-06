package graphs;

public class ratinmaze {
   public static void rat(int[][] mat, int i, int j, String ans) {
      if (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && mat[i][j] != 0) {
         if (i == mat.length - 1 && j == mat[0].length - 1) {
            System.out.println(ans);
         } else {
            mat[i][j] = 0;
            rat(mat, i - 1, j, ans + "U");
            rat(mat, i + 1, j, ans + "D");
            rat(mat, i, j - 1, ans + "L");
            rat(mat, i, j + 1, ans + "R");
            mat[i][j] = 1;
         }
      }
   }

   public static void main(String[] args) {
      int[][] mat = new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
      rat(mat, 0, 0, "");
   }
}
