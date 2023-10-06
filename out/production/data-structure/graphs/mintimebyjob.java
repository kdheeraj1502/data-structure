package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class mintimebyjob {
   public static void topsort(HashMap<String, HashMap<String, Integer>> vtces) {
      HashMap<String, Integer> map = new HashMap();
      ArrayList<String> nbrlist = new ArrayList(vtces.keySet());
      Iterator var3 = nbrlist.iterator();

      while(var3.hasNext()) {
         String string = (String)var3.next();
         if (!map.containsKey(string)) {
            dfs(map, string, vtces, 1);
         }
      }

      System.out.println(map);
   }

   public static void dfs(HashMap<String, Integer> map, String src, HashMap<String, HashMap<String, Integer>> vtces, int t) {
      if (!map.containsKey(src) || t >= (Integer)map.get(src)) {
         map.put(src, t);
         HashMap<String, Integer> nbr = (HashMap)vtces.get(src);
         ArrayList<String> nbrlist = new ArrayList(nbr.keySet());
         Iterator var6 = nbrlist.iterator();

         while(true) {
            String string;
            do {
               if (!var6.hasNext()) {
                  return;
               }

               string = (String)var6.next();
            } while(map.containsKey(string) && t + 1 <= (Integer)map.get(string));

            dfs(map, string, vtces, t + 1);
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
      graph.addvertex("7");
      graph.addedge("0", "1", 1);
      graph.addedge("0", "2", 1);
      graph.addedge("0", "3", 1);
      graph.addedge("2", "4", 1);
      graph.addedge("4", "5", 1);
      graph.addedge("6", "7", 1);
      graph.addedge("7", "2", 10);
      graph.diplay();
      topsort(graph.vtces);
   }
}
