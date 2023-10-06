package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class wiredconnections {
   public static void main(String[] args) {
      int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
      System.out.println(connections(connections, 6));
   }

   public static int connections(int[][] connections, int n) {
      if (connections.length < n - 1) {
         return -1;
      } else {
         ArrayList<ArrayList<Integer>> graph = new ArrayList();

         int countcomponents;
         for(countcomponents = 0; countcomponents < n; ++countcomponents) {
            graph.add(new ArrayList());
         }

         int i;
         for(countcomponents = 0; countcomponents < connections.length; ++countcomponents) {
            int vname1 = connections[countcomponents][0];
            i = connections[countcomponents][1];
            ArrayList<Integer> nbr1 = (ArrayList)graph.get(vname1);
            nbr1.add(connections[countcomponents][1]);
            ArrayList<Integer> nbr2 = (ArrayList)graph.get(i);
            nbr2.add(connections[countcomponents][0]);
         }

         countcomponents = 0;
         int[] map = new int[n];

         for(i = 0; i < n; ++i) {
            if (map[i] == 0) {
               ++countcomponents;
               dfs(i, graph, map);
            }
         }

         return countcomponents - 1;
      }
   }

   public static void dfs(int src, ArrayList<ArrayList<Integer>> graph, int[] map) {
      if (map[src] != 1) {
         map[src] = 1;
         ArrayList<Integer> nbr = (ArrayList)graph.get(src);
         Iterator var4 = nbr.iterator();

         while(var4.hasNext()) {
            Integer integer = (Integer)var4.next();
            if (map[integer] == 0) {
               dfs(integer, graph, map);
            }
         }

      }
   }
}
