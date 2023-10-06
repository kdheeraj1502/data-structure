package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class klengthpath {
   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addvertex("4");
      graph.addvertex("5");
      graph.addvertex("6");
      graph.addedge("0", "1", 10);
      graph.addedge("1", "2", 10);
      graph.addedge("3", "0", 25);
      graph.addedge("2", "3", 10);
      graph.addedge("4", "3", 2);
      graph.addedge("5", "4", 3);
      graph.addedge("6", "4", 8);
      graph.addedge("5", "6", 3);
      graph.diplay();
      HashSet<String> map = new HashSet();
      System.out.println(dfs(graph.vtces, "0", map, 100));
   }

   public static boolean dfs(HashMap<String, HashMap<String, Integer>> adj, String src, HashSet<String> map, int k) {
      if (k <= 0) {
         return true;
      } else {
         map.add(src);
         HashMap<String, Integer> nbr = (HashMap)adj.get(src);
         ArrayList<String> nbrlist = new ArrayList(nbr.keySet());
         Iterator var6 = nbrlist.iterator();

         String i;
         int wtnbr;
         do {
            if (!var6.hasNext()) {
               map.remove(src);
               return false;
            }

            i = (String)var6.next();
            wtnbr = (Integer)nbr.get(i);
            if (wtnbr > k) {
               return true;
            }
         } while(map.contains(i) || !dfs(adj, i, map, k - wtnbr));

         return true;
      }
   }
}
