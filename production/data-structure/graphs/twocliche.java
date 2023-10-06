package graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class twocliche {
   public static void main(String[] args) {
      int[][] adj = new int[][]{{0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 0, 1, 0}};
      System.out.println(tc(adj));
   }

   public static boolean tc(int[][] adj) {
      int[][] adjnew = new int[adj.length][adj[0].length];

      for(int i = 0; i < adj.length; ++i) {
         for(int j = 0; j < adj[0].length; ++j) {
            if (adj[i][j] == 0 && i != j) {
               adjnew[i][j] = 1;
            }
         }
      }

      LinkedList<pair> queue = new LinkedList();
      HashMap<Integer, Integer> map = new HashMap();

      label60:
      for(int i = 0; i < adj.length; ++i) {
         if (!map.containsKey(i)) {
            queue.addLast(new pair(i, 1));

            int j;
            int nc;
            do {
               while(true) {
                  if (queue.isEmpty()) {
                     continue label60;
                  }

                  pair rv = (pair)queue.removeFirst();
                  if (map.containsKey(rv.vname)) {
                     j = rv.color;
                     nc = (Integer)map.get(rv.vname);
                     break;
                  }

                  map.put(rv.vname, rv.color);

                  for(j = 0; j < adjnew[0].length; ++j) {
                     if (adjnew[rv.vname][j] == 1) {
                        nc = 1;
                        if (rv.color == 1) {
                           nc = 2;
                        }

                        if (!map.containsKey(j)) {
                           queue.add(new pair(j, nc));
                        }
                     }
                  }
               }
            } while(nc == j);

            return false;
         }
      }

      return true;
   }
}
