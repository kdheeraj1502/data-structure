package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class ratinamaze {
   public static void main(String[] args) {
      int[][] maze = new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
      System.out.println(findPath(maze, maze.length));
   }

   public static ArrayList<String> findPath(int[][] m, int n) {
      ArrayList<String> ans = new ArrayList();
      path(m, 0, 0, "", ans);
      Collections.sort(ans);
      return ans;
   }

   public static void path(int[][] m, int i, int j, String ans, ArrayList<String> list) {
      if (i >= 0 && i < m.length && j >= 0 && j < m[0].length && m[i][j] != 0) {
         if (i == m.length - 1 && j == m[0].length - 1) {
            list.add(ans);
         } else {
            m[i][j] = 0;
            path(m, i + 1, j, ans + "D", list);
            path(m, i - 1, j, ans + "U", list);
            path(m, i, j + 1, ans + "R", list);
            path(m, i, j - 1, ans + "L", list);
            m[i][j] = 1;
         }
      }
   }
}
