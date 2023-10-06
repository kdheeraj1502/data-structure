package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class bellmanford {
   public static ArrayList<edgepair> alledges(HashMap<String, HashMap<String, Integer>> vtces) {
      ArrayList<edgepair> ans = new ArrayList();
      Iterator var2 = vtces.keySet().iterator();

      while(var2.hasNext()) {
         String v = (String)var2.next();
         HashMap<String, Integer> nbr = (HashMap)vtces.get(v);
         Iterator var5 = nbr.keySet().iterator();

         while(var5.hasNext()) {
            String nbrv = (String)var5.next();
            ans.add(new edgepair(v, nbrv, (Integer)nbr.get(nbrv)));
         }
      }

      return ans;
   }

   public static void bellmanford(HashMap<String, HashMap<String, Integer>> vtces, String src) {
      ArrayList<edgepair> edges = alledges(vtces);
      HashMap<String, Integer> map = new HashMap();
      Iterator var4 = vtces.keySet().iterator();

      while(var4.hasNext()) {
         String vname = (String)var4.next();
         map.put(vname, 1000000);
         if (vname == src) {
            map.put(vname, 0);
         }
      }

      int V = vtces.size();

      for(int i = 1; i <= V; ++i) {
         Iterator var6 = edges.iterator();

         while(var6.hasNext()) {
            edgepair e = (edgepair)var6.next();
            int oc = (Integer)map.get(e.v2);
            int nc = (Integer)map.get(e.v1) + e.cost;
            if (oc > nc) {
               if (i <= V - 1) {
                  map.put(e.v2, nc);
               } else {
                  System.out.println("-ve weight cycle present");
               }
            }
         }
      }

      System.out.println(map);
   }

   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("a");
      graph.addvertex("b");
      graph.addvertex("c");
      graph.addvertex("d");
      graph.addvertex("e");
      graph.addedge("a", "b", 8);
      graph.addedge("a", "c", 4);
      graph.addedge("a", "d", 5);
      graph.addedge("c", "d", -3);
      graph.addedge("d", "e", 4);
      graph.addedge("b", "e", 2);
      graph.addedge("e", "b", 1);
      graph.diplay();
      bellmanford(graph.vtces, "a");
   }
}
