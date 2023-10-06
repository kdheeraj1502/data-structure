package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class cheapestflights {
   public static void main(String[] args) {
      int n = 5;
      int src = 0;
      int dst = 2;
      int k = 1;
      int[][] edges = new int[][]{{0, 3, 2}, {0, 1, 5}, {3, 1, 2}, {1, 2, 5}, {1, 4, 1}, {4, 2, 1}};
      cf(n, edges, src, dst, k);
   }

   public static void cf(int n, int[][] flights, int src, int dst, int k) {
      HashMap<Integer, HashMap<Integer, Integer>> adj = new HashMap();

      int min;
      for(min = 0; min < n; ++min) {
         HashMap<Integer, Integer> nbr = new HashMap();
         adj.put(min, nbr);
      }

      for(min = 0; min < flights.length; ++min) {
         int u = flights[min][0];
         int v = flights[min][1];
         int c = flights[min][2];
         HashMap<Integer, Integer> nbr = (HashMap)adj.get(u);
         nbr.put(v, c);
      }

      min = Integer.MAX_VALUE;
      System.out.println(bfs(adj, src, dst, k, min));
      new HashSet();
   }

   public static int bfs(HashMap<Integer, HashMap<Integer, Integer>> adj, int src, int dest, int k, int min) {
      int[] costs = new int[adj.size()];
      int[] stops = new int[adj.size()];
      Arrays.fill(costs, Integer.MAX_VALUE);
      Arrays.fill(stops, Integer.MAX_VALUE);
      costs[src] = 0;
      stops[src] = 0;
      PriorityQueue<pair> queue = new PriorityQueue();
      queue.add(new pair(src, 0, src + "", 0));

      while(true) {
         pair rv;
         do {
            if (queue.isEmpty()) {
               return -1;
            }

            rv = (pair)queue.remove();
            if (rv.vname == dest) {
               System.out.println(rv.path + "   @ " + rv.cost);
               return rv.cost;
            }
         } while(rv.stop > k);

         HashMap<Integer, Integer> nbr = (HashMap)adj.get(rv.vname);
         ArrayList<Integer> nbrlist = new ArrayList(nbr.keySet());
         Iterator var11 = nbrlist.iterator();

         while(var11.hasNext()) {
            Integer i = (Integer)var11.next();
            if (rv.cost + (Integer)nbr.get(i) < costs[i]) {
               queue.add(new pair(i, rv.cost + (Integer)nbr.get(i), rv.path + i, rv.stop + 1));
               costs[i] = rv.cost + (Integer)nbr.get(i);
               stops[i] = rv.stop;
            } else if (rv.stop < stops[i]) {
               queue.add(new pair(i, rv.cost + (Integer)nbr.get(i), rv.path + i, rv.stop + 1));
            }
         }
      }
   }

   public static int allpath(HashMap<Integer, HashMap<Integer, Integer>> adj, int src, int dest, HashSet<Integer> map, String path, int cost, int k, int stop) {
      if (src == dest) {
         return stop <= k + 1 ? cost : Integer.MAX_VALUE;
      } else {
         map.add(src);
         int myans = Integer.MAX_VALUE;
         HashMap<Integer, Integer> nbr = (HashMap)adj.get(src);
         ArrayList<Integer> nbrlist = new ArrayList(nbr.keySet());
         Iterator var11 = nbrlist.iterator();

         while(var11.hasNext()) {
            Integer i = (Integer)var11.next();
            if (!map.contains(i)) {
               int a = allpath(adj, i, dest, map, path + i, cost + (Integer)nbr.get(i), k, stop + 1);
               if (myans > a) {
                  myans = a;
               }
            }
         }

         map.remove(src);
         return myans;
      }
   }
}
