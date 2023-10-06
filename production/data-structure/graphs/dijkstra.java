package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class dijkstra {
   public static void dijkstra(HashMap<String, HashMap<String, Integer>> vtces) {
      PriorityQueue<pair> queue = new PriorityQueue();
      HashMap<String, Boolean> map = new HashMap();
      ArrayList<String> vlist = new ArrayList(vtces.keySet());
      Iterator var4 = vlist.iterator();

      label41:
      while(true) {
         String string;
         do {
            if (!var4.hasNext()) {
               return;
            }

            string = (String)var4.next();
         } while(map.containsKey(string));

         queue.add(new pair(string, string, 0));

         while(true) {
            pair rv;
            do {
               if (queue.isEmpty()) {
                  continue label41;
               }

               rv = (pair)queue.remove();
            } while(map.containsKey(rv.vname));

            map.put(rv.vname, true);
            System.out.println(rv.vname + " via " + rv.path + " @ " + rv.wt);
            HashMap<String, Integer> nbr = (HashMap)vtces.get(rv.vname);
            ArrayList<String> nbrlist = new ArrayList(nbr.keySet());
            Iterator var9 = nbrlist.iterator();

            while(var9.hasNext()) {
               String string2 = (String)var9.next();
               if (!map.containsKey(string2)) {
                  queue.add(new pair(string2, rv.path + string2, rv.wt + (Integer)nbr.get(string2)));
               }
            }
         }
      }
   }

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
      dijkstra(graph.vtces);
   }
}
