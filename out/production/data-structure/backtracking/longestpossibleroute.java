package backtracking;

public class longestpossibleroute {
   public static int max = Integer.MIN_VALUE;

   public static void main(String[] args) {
      int[][] mat = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 0, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
      solve(mat, 0, 0, 0, 1, 7);
      System.out.println(max);
   }

   public static void solve(int[][] arr, int ans, int i, int j, int di, int dj) {
      if (j == dj && i == di) {
         if (max < ans) {
            max = ans;
         }

      } else if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length && arr[i][j] != 0 && arr[i][j] != -1) {
         int[] rx = new int[]{1, -1, 0, 0};
         int[] ry = new int[]{0, 0, 1, -1};
         arr[i][j] = -1;

         for(int k = 0; k < ry.length; ++k) {
            solve(arr, ans + 1, i + rx[k], j + ry[k], di, dj);
         }

         arr[i][j] = 1;
      }
   }
}
