package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class longestpath {
   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addvertex("4");
      graph.addvertex("5");
      graph.addedge("0", "1", 5);
      graph.addedge("0", "2", 3);
      graph.addedge("1", "3", 6);
      graph.addedge("1", "2", 2);
      graph.addedge("2", "4", 4);
      graph.addedge("2", "5", 2);
      graph.addedge("2", "3", 7);
      graph.addedge("3", "5", 1);
      graph.addedge("3", "4", -1);
      graph.addedge("4", "5", -2);
      graph.diplay();
      longetspath(graph.vtces, "1");
   }

   public static void longetspath(HashMap<String, HashMap<String, Integer>> vtces, String src) {
      LinkedList<String> st = new LinkedList();
      topsort(vtces, st);
      int[] dist = new int[vtces.size()];

      int i;
      for(i = 0; i < dist.length; ++i) {
         dist[i] = Integer.MIN_VALUE;
      }

      dist[Integer.parseInt(src)] = 0;

      while(true) {
         String vname;
         do {
            if (st.isEmpty()) {
               for(i = 0; i < dist.length; ++i) {
                  System.out.println(dist[i]);
               }

               return;
            }

            vname = (String)st.removeFirst();
         } while(dist[Integer.parseInt(vname)] == Integer.MIN_VALUE);

         HashMap<String, Integer> nbrs = (HashMap)vtces.get(vname);
         ArrayList<String> nbrname = new ArrayList(nbrs.keySet());
         Iterator var7 = nbrname.iterator();

         while(var7.hasNext()) {
            String string = (String)var7.next();
            if (dist[Integer.parseInt(string)] < dist[Integer.parseInt(vname)] + (Integer)nbrs.get(string)) {
               dist[Integer.parseInt(string)] = dist[Integer.parseInt(vname)] + (Integer)nbrs.get(string);
            }
         }
      }
   }

   public static void topsort(HashMap<String, HashMap<String, Integer>> vtces, LinkedList<String> st) {
      HashSet<String> map = new HashSet();
      ArrayList<String> vname = new ArrayList(vtces.keySet());
      Iterator var4 = vname.iterator();

      while(var4.hasNext()) {
         String string = (String)var4.next();
         if (!map.contains(string)) {
            dfs(map, st, string, vtces);
         }
      }

   }

   private static void dfs(HashSet<String> map, LinkedList<String> st, String src, HashMap<String, HashMap<String, Integer>> vtces) {
      map.add(src);
      ArrayList<String> nbrs = new ArrayList(((HashMap)vtces.get(src)).keySet());
      Iterator var5 = nbrs.iterator();

      while(var5.hasNext()) {
         String string = (String)var5.next();
         if (!map.contains(string)) {
            dfs(map, st, string, vtces);
         }
      }

      st.addFirst(src);
   }
}
