package graphs;

import java.util.PriorityQueue;

public class minedgesreverse {
   public static void main(String[] args) {
      int[][] adj = new int[][]{{0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}};
      int[][] newadj = new int[adj.length][adj[0].length];

      int i;
      int j;
      for(i = 0; i < newadj.length; ++i) {
         for(j = 0; j < newadj[0].length; ++j) {
            newadj[i][j] = -1;
         }
      }

      for(i = 0; i < newadj.length; ++i) {
         for(j = 0; j < newadj[0].length; ++j) {
            if (adj[i][j] == 1) {
               newadj[i][j] = 0;
               newadj[j][i] = 1;
            }

            System.out.print(newadj[i][j] + "     ");
         }

         System.out.println();
      }

      dijkstra(0, 6, newadj);
   }

   public static void dijkstra(int src, int dest, int[][] adj) {
      PriorityQueue<pair> queue = new PriorityQueue();
      int[] vis = new int[adj.length];
      queue.add(new pair(src, 0, "" + src));

      while(true) {
         pair rv;
         do {
            if (queue.isEmpty()) {
               return;
            }

            rv = (pair)queue.remove();
         } while(vis[rv.vname] == 1);

         vis[rv.vname] = 1;
         if (rv.vname == dest) {
            System.out.println(rv.path + " @ " + rv.cost);
         }

         int[] nbr = adj[rv.vname];

         for(int i = 0; i < nbr.length; ++i) {
            if (nbr[i] > -1 && vis[i] == 0) {
               queue.add(new pair(i, rv.cost + nbr[i], rv.path + i));
            }
         }
      }
   }
}
