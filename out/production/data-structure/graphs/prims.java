package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class prims {
   public static void prims(HashMap<String, HashMap<String, Integer>> vtces) {
      PriorityQueue<pair> queue = new PriorityQueue();
      HashMap<String, Boolean> map = new HashMap();
      ArrayList<String> vtceslist = new ArrayList(vtces.keySet());
      Iterator var4 = vtceslist.iterator();

      while(var4.hasNext()) {
         String string = (String)var4.next();
         if (!map.containsKey(string)) {
            bft(vtces, string, map, queue);
         }
      }

   }

   private static void bft(HashMap<String, HashMap<String, Integer>> vtces, String src, HashMap<String, Boolean> map, PriorityQueue<pair> queue) {
      queue.add(new pair(src, "-1", 0));

      while(true) {
         pair rv;
         do {
            if (queue.isEmpty()) {
               return;
            }

            rv = (pair)queue.remove();
         } while(map.containsKey(rv.vname));

         map.put(rv.vname, true);
         System.out.println(rv.vname + " via " + rv.pathvtc + " @ " + rv.wt);
         HashMap<String, Integer> nbr = (HashMap)vtces.get(rv.vname);
         Iterator var6 = nbr.keySet().iterator();

         while(var6.hasNext()) {
            String nbvtc = (String)var6.next();
            if (!map.containsKey(nbvtc)) {
               queue.add(new pair(nbvtc, rv.vname, (Integer)nbr.get(nbvtc)));
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
      prims(graph.vtces);
   }
}
