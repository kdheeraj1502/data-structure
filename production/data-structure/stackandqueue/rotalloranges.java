package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class rotalloranges {
   public int orangesRotting(int[][] grid) {
      Queue<pair> q = new LinkedList();

      int maxt;
      for(maxt = 0; maxt < grid.length; ++maxt) {
         for(int j = 0; j < grid[0].length; ++j) {
            if (grid[maxt][j] == 2) {
               q.add(new pair(this, 0, maxt, j));
            }
         }
      }

      maxt = 0;
      int[] rx = new int[]{-1, 1, 0, 0};
      int[] ry = new int[]{0, 0, -1, 1};

      int j;
      while(!q.isEmpty()) {
         pair rv = (pair)q.remove();
         if (maxt < rv.time) {
            maxt = rv.time;
         }

         j = rv.i;
         int j = rv.j;

         for(int k = 0; k < 4; ++k) {
            int fi = j + rx[k];
            int fj = j + ry[k];
            int nr = grid.length;
            int nc = grid[0].length;
            if (fi >= 0 && fi < nr && fj >= 0 && fj < nc && grid[fi][fj] == 1) {
               q.add(new pair(this, rv.time + 1, fi, fj));
               grid[fi][fj] = 2;
            }
         }
      }

      for(int i = 0; i < grid.length; ++i) {
         for(j = 0; j < grid[0].length; ++j) {
            if (grid[i][j] == 1) {
               return -1;
            }
         }
      }

      return maxt;
   }
}
