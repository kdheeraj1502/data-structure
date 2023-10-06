package graphs;

import java.util.LinkedList;

public class minstepsKnight {
   public static void main(String[] args) {
      int[] kpos = new int[]{5, 0};
      int[] target = new int[]{1, 3};
      int n = 7;
      minsteps(kpos, target, n);
   }

   public static void minsteps(int[] kpos, int[] target, int n) {
      int[][] vis = new int[n][n];
      int[][] ans = new int[n][n];
      LinkedList<int[]> queue = new LinkedList();
      int xpos = kpos[0];
      int ypos = kpos[1];
      int xt = target[0];
      int yt = target[1];
      int[] arr = new int[]{xpos, ypos};
      queue.addLast(arr);
      int[] cx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
      int[] cy = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

      while(!queue.isEmpty()) {
         int[] rv = (int[])queue.removeFirst();
         if (rv[0] == xt && rv[1] == yt) {
            System.out.println(ans[xt][yt]);
            break;
         }

         if (vis[rv[0]][rv[1]] != 1) {
            vis[rv[0]][rv[1]] = 1;

            for(int i = 0; i < 8; ++i) {
               int x = rv[0] + cx[i];
               int y = rv[1] + cy[i];
               if (x >= 0 && y >= 0 && x < n && y < n && vis[x][y] == 0) {
                  int[] arr1 = new int[]{x, y};
                  queue.addLast(arr1);
                  ans[x][y] = ans[rv[0]][rv[1]] + 1;
               }
            }
         }
      }

   }
}
